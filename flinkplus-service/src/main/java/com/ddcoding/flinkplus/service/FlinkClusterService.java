package com.ddcoding.flinkplus.service;

import com.ddcoding.flinkplus.model.dto.JobInstanceDTO;
import com.ddcoding.flinkplus.model.enums.JobInstanceStatusEnum;

/**
 * @author: ddcoding
 * @date: 2020/1/19
 */
public interface FlinkClusterService {
    /**
     * 作业实例提交flink job
     *
     * @param jobInstanceDTO 作业实例信息
     * @return appId
     */
    String submitJob(JobInstanceDTO jobInstanceDTO, String logFile) throws Exception;

    /**
     * 查询flink job的状态对应的作业实例状态
     *
     * @param jobInstanceDTO 作业实例信息
     * @return 状态枚举
     */
    JobInstanceStatusEnum jobStatus(JobInstanceDTO jobInstanceDTO) throws Exception;

    /**
     * 停止作业实例对应的flink job
     *
     * @return 是否成功
     */
    void stopJob(String appId) throws Exception;

    /**
     * 获取任务的ui地址
     *
     * @param jobInstanceDTO 作业实例信息
     * @return 是否成功
     */
    String getJobUiAddress(JobInstanceDTO jobInstanceDTO) throws Exception;
}
