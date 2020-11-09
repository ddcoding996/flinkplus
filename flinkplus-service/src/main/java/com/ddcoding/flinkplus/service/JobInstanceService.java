package com.ddcoding.flinkplus.service;

import com.ddcoding.flinkplus.model.dto.JobInstanceDTO;
import com.ddcoding.flinkplus.model.pojo.JobInstance;
import com.ddcoding.flinkplus.model.req.PageReq;
import com.github.pagehelper.PageInfo;

/**
 * @Author ddcoding
 * @Create 2020/1/21 10:13
 */
public interface JobInstanceService {
    PageInfo<JobInstanceDTO> queryJobInstances(JobInstanceDTO jobInstanceDTO, PageReq pageReq);

    void updateJobAndInstanceStatus(JobInstance jobInstance);

    String startLog(Long jobInstanceId);

    String getStartLogFilePath(JobInstanceDTO jobInstanceDTO);
}
