package com.ddcoding.flinkplus.common.builder;

import com.ddcoding.flinkplus.common.util.UploadUtil;
import com.ddcoding.flinkplus.model.common.FlinkSubmitOptions;
import com.ddcoding.flinkplus.model.dto.JobInstanceDTO;

/**
 * @author: ddcoding
 * @date: 2020/10/13
 */
public class FlinkJarSubmitOptionsBuilder implements FlinkSubmitOptionsBuilder {
    @Override
    public FlinkSubmitOptions builder(JobInstanceDTO jobInstanceDTO) {
        FlinkSubmitOptions flinkSubmitOptions = new FlinkSubmitOptions();
        flinkSubmitOptions.setJobName("FLINKPLUS_JAR_" + jobInstanceDTO.getJob().getName());
        flinkSubmitOptions.setMainJarPath(UploadUtil.getJobJarsPath(jobInstanceDTO.getJobId(), jobInstanceDTO.getFlinkConfig().getJarName()));
        flinkSubmitOptions.setFlinkConfig(jobInstanceDTO.getFlinkConfig());
        return flinkSubmitOptions;
    }
}
