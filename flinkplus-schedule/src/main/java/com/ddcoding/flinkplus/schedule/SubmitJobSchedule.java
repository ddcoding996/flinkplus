package com.ddcoding.flinkplus.schedule;

import com.ddcoding.flinkplus.dao.mapper.JobInstanceMapper;
import com.ddcoding.flinkplus.model.dto.JobInstanceDTO;
import com.ddcoding.flinkplus.model.enums.JobInstanceStatusEnum;
import com.ddcoding.flinkplus.model.pojo.JobInstance;
import com.ddcoding.flinkplus.schedule.task.SubmitJobTask;
import com.ddcoding.flinkplus.service.transform.JobInstanceTransform;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

/**
 * 作业异步提交定时任务
 * 扫描待启动的实例进行异步的提交
 *
 * @author: ddcoding
 * @date: 2020/1/27
 */
@Slf4j
@Component
public class SubmitJobSchedule {
    @Autowired
    private JobInstanceMapper jobInstanceMapper;
    @Autowired
    private SubmitJobTask submitJobTask;
    @Autowired
    private JobInstanceTransform jobInstanceTransform;

    /**
     * 从数据库查询出装备执行的任务
     * 使用任务调度提交flink任务
     * @throws Exception
     */
    @Scheduled(fixedDelay = 5 * 1000, initialDelay = 10 * 1000)
    public void submitJobSchedule() throws Exception {
        JobInstance condition = new JobInstance();
        condition.setStatus(JobInstanceStatusEnum.WAITING_START.getValue());
        List<JobInstance> jobInstances = jobInstanceMapper.select(condition);
        Collection<JobInstanceDTO> jobInstanceDTOS = jobInstanceTransform.transform(jobInstances);
        if (CollectionUtils.isNotEmpty(jobInstanceDTOS)) {
            log.info("submitJobSchedule start");
            //异步提交flink任务
            for (JobInstanceDTO jobInstanceDTO : jobInstanceDTOS) {
                submitJobTask.asyncSubmitJobTask(jobInstanceDTO);
            }
        }
    }
}
