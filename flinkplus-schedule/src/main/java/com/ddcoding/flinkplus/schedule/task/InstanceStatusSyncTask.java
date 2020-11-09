package com.ddcoding.flinkplus.schedule.task;

import com.ddcoding.flinkplus.model.dto.JobInstanceDTO;
import com.ddcoding.flinkplus.model.enums.JobInstanceStatusEnum;
import com.ddcoding.flinkplus.model.pojo.JobInstance;
import com.ddcoding.flinkplus.service.FlinkClusterService;
import com.ddcoding.flinkplus.service.JobInstanceService;
import com.ddcoding.flinkplus.service.factory.FlinkClusterServiceFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author: ddcoding
 * @date: 2020/1/27
 */
@Slf4j
@Component
public class InstanceStatusSyncTask {
    @Autowired
    private FlinkClusterServiceFactory flinkClusterServiceFactory;
    @Autowired
    private JobInstanceService jobInstanceService;

    @Async("commonThreadExecutor")
    public void asyncInstanceStatusSyncTask(JobInstanceDTO jobInstanceDTO) {
        JobInstance jobInstanceStopped;
        JobInstanceStatusEnum jobInstanceStatusEnum;
        try {
            //提交平台实例（flink job）到flink集群
            FlinkClusterService defaultFlinkClusterService = flinkClusterServiceFactory.getDefaultFlinkClusterService();
            jobInstanceStatusEnum = defaultFlinkClusterService.jobStatus(jobInstanceDTO);
            switch (jobInstanceStatusEnum) {
                case RUN_FAILED:
                case SUCCESS: {
                    jobInstanceStopped = new JobInstance();
                    jobInstanceStopped.setStatus(jobInstanceStatusEnum.getValue());
                    jobInstanceStopped.setStopTime(new Date());
                    break;
                }
                default: {
                    return;
                }
            }
            jobInstanceStopped.setId(jobInstanceDTO.getId());
            jobInstanceStopped.setJobId(jobInstanceDTO.getJobId());
            jobInstanceService.updateJobAndInstanceStatus(jobInstanceStopped);
        } catch (Exception e) {
            log.warn("asyncSubmitJob error jobInstanceId={}", jobInstanceDTO.getId(), e);
        }
    }
}
