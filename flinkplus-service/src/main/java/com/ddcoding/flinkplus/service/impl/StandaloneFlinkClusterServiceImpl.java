package com.ddcoding.flinkplus.service.impl;

import com.ddcoding.flinkplus.common.assist.FlinkShellSubmitAssist;
import com.ddcoding.flinkplus.common.builder.StandaloneCommandBuilder;
import com.ddcoding.flinkplus.http.FlinkRestRpcService;
import com.ddcoding.flinkplus.model.dto.JobInstanceDTO;
import com.ddcoding.flinkplus.model.enums.JobInstanceStatusEnum;
import com.ddcoding.flinkplus.service.FlinkClusterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: ddcoding
 * @date: 2020/1/19
 */
@Service("standaloneFlinkClusterServiceImpl")
public class StandaloneFlinkClusterServiceImpl implements FlinkClusterService {
    @Autowired
    private FlinkRestRpcService flinkRestRpcService;

    private final FlinkShellSubmitAssist flinkShellSubmitAssist =
            new FlinkShellSubmitAssist(StandaloneCommandBuilder.INSTANCE, "Job has been submitted with JobID ([a-zA-Z0-9]+)");

    //提交flink任务
    @Override
    public String submitJob(JobInstanceDTO jobInstanceDTO, String logFile) throws Exception {
        return flinkShellSubmitAssist.submitJob(jobInstanceDTO, logFile);
    }

    @Override
    public JobInstanceStatusEnum jobStatus(JobInstanceDTO jobInstanceDTO) throws Exception {
        String status = flinkRestRpcService.queryJobStatus(jobInstanceDTO.getAppId());
        if (status != null) {
            switch (status) {
                case "FINISHED": {
                    return JobInstanceStatusEnum.SUCCESS;
                }
                case "FAILED": {
                    return JobInstanceStatusEnum.RUN_FAILED;
                }
                case "RUNNING": {
                    return JobInstanceStatusEnum.RUNNING;
                }
            }
        }
        return JobInstanceStatusEnum.UNKNOWN;
    }

    @Override
    public void stopJob(String appId) throws Exception {
        flinkRestRpcService.stopJob(appId);
    }

    @Override
    public String getJobUiAddress(JobInstanceDTO jobInstanceDTO) throws Exception {
        return flinkRestRpcService.getJobUiAddress(jobInstanceDTO.getAppId());
    }
}
