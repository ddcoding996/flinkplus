package com.ddcoding.flinkplus.schedule;

import com.ddcoding.flinkplus.dao.mapper.JobInstanceMapper;
import com.ddcoding.flinkplus.model.dto.JobInstanceDTO;
import com.ddcoding.flinkplus.model.enums.JobInstanceStatusEnum;
import com.ddcoding.flinkplus.model.pojo.JobInstance;
import com.ddcoding.flinkplus.schedule.task.InstanceStatusSyncTask;
import com.ddcoding.flinkplus.service.transform.JobInstanceTransform;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

/**
 * 实例状态同步定时任务
 *
 * @author: ddcoding
 * @date: 2020/1/27
 */
@Slf4j
@Component
public class InstanceStatusSyncSchedule {
    @Autowired
    private JobInstanceMapper jobInstanceMapper;
    @Autowired
    private InstanceStatusSyncTask instanceStatusSyncTask;
    @Autowired
    private JobInstanceTransform jobInstanceTransform;

    @Scheduled(fixedDelay = 10 * 1000, initialDelay = 10 * 1000)
    public void instanceStatusSyncSchedule() throws Exception {
        JobInstance condition = new JobInstance();
        condition.setStatus(JobInstanceStatusEnum.RUNNING.getValue());
        List<JobInstance> jobInstances = jobInstanceMapper.select(condition);
        Collection<JobInstanceDTO> jobInstanceDTOS = jobInstanceTransform.transform(jobInstances);
        if (CollectionUtils.isNotEmpty(jobInstanceDTOS)) {
            log.info("instanceStatusSyncSchedule start");
            for (JobInstanceDTO jobInstanceDTO : jobInstanceDTOS) {
                instanceStatusSyncTask.asyncInstanceStatusSyncTask(jobInstanceDTO);
            }
        }
    }
}
