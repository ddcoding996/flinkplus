package com.ddcoding.flinkplus.common.builder;

import com.ddcoding.flinkplus.model.common.FlinkSubmitOptions;
import com.ddcoding.flinkplus.model.dto.JobInstanceDTO;

/**
 * @author: ddcoding
 * @date: 2020/10/13
 */
public interface FlinkSubmitOptionsBuilder {
    FlinkSubmitOptions builder(JobInstanceDTO jobInstanceDTO);
}
