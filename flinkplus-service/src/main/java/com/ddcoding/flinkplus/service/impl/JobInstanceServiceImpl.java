package com.ddcoding.flinkplus.service.impl;

import com.ddcoding.flinkplus.common.util.FileUtil;
import com.ddcoding.flinkplus.dao.mapper.JobInstanceMapper;
import com.ddcoding.flinkplus.dao.mapper.JobMapper;
import com.ddcoding.flinkplus.model.dto.JobInstanceDTO;
import com.ddcoding.flinkplus.model.exception.FlinkPlusMessageException;
import com.ddcoding.flinkplus.model.exception.FlinkPlusRuntimeException;
import com.ddcoding.flinkplus.model.pojo.Job;
import com.ddcoding.flinkplus.model.pojo.JobInstance;
import com.ddcoding.flinkplus.model.req.PageReq;
import com.ddcoding.flinkplus.service.JobInstanceService;
import com.ddcoding.flinkplus.service.transform.JobInstanceTransform;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * @Author ddcoding
 * @Create 2020/1/21 10:18
 */
@Slf4j
@Service
public class JobInstanceServiceImpl implements JobInstanceService {
    @Value("${logging.instance.dir}")
    private String instanceLogDir;
    @Value("${logging.instance.pattern}")
    private String instanceLogPattern;

    @Autowired
    private JobMapper jobMapper;
    @Autowired
    private JobInstanceMapper jobInstanceMapper;
    @Autowired
    private JobInstanceTransform jobInstanceTransform;


    @Override
    public PageInfo<JobInstanceDTO> queryJobInstances(JobInstanceDTO jobInstanceDTO, PageReq pageReq) {
        if (jobInstanceDTO == null) {
            jobInstanceDTO = new JobInstanceDTO();
        }
        PageHelper.startPage(pageReq.getPageNum(), pageReq.getPageSize());
        List<JobInstance> jobInstanceList = jobInstanceMapper.select(jobInstanceDTO);
        PageInfo<JobInstance> jobInstancePageInfo = new PageInfo<>(jobInstanceList);
        return jobInstanceTransform.pageInfoTransform(jobInstancePageInfo);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateJobAndInstanceStatus(JobInstance jobInstance) {
        int jobInstanceRowCnt = jobInstanceMapper.updateByPrimaryKeySelective(jobInstance);
        if (jobInstanceRowCnt == 0) {
            throw new FlinkPlusMessageException("update job instance status fail");
        }
        if (jobInstance.getJobId() == null) {
            throw new FlinkPlusMessageException("update job instance status fail,jobId is null");
        }
        Job job = new Job();
        job.setId(jobInstance.getJobId());
        job.setLastStatus(jobInstance.getStatus());
        job.setLastAppId(jobInstance.getAppId());
        job.setLastStartTime(jobInstance.getStartTime());
        job.setLastStopTime(jobInstance.getStopTime());
        int jobRowCnt = jobMapper.updateByPrimaryKeySelective(job);
        if (jobRowCnt == 0) {
            throw new FlinkPlusMessageException("update job status fail");
        }
    }

    @Override
    public String startLog(Long jobInstanceId) {
        JobInstance jobInstance = jobInstanceMapper.selectByPrimaryKey(jobInstanceId);
        if (jobInstance == null) {
            return null;
        }
        JobInstanceDTO jobInstanceDTO = jobInstanceTransform.transform(jobInstance);
        String startLogFilePath = getStartLogFilePath(jobInstanceDTO);
        try {
            return FileUtil.readFileToString(startLogFilePath);
        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e) {
            throw new FlinkPlusRuntimeException("read instance start log error", e);
        }
    }

    @Override
    public String getStartLogFilePath(JobInstanceDTO jobInstanceDTO) {
        return String.format(instanceLogDir + instanceLogPattern, jobInstanceDTO.getJobId(), jobInstanceDTO.getId());
    }
}
