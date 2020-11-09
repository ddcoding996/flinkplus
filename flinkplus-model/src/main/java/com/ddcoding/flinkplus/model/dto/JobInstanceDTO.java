package com.ddcoding.flinkplus.model.dto;

import com.ddcoding.flinkplus.model.common.FlinkConfig;
import com.ddcoding.flinkplus.model.pojo.JobInstance;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;

/**
 * @Author ddcoding
 * @Create 2020/1/21 10:14
 */
@Getter
@Setter
@NoArgsConstructor
public class JobInstanceDTO extends JobInstance {
    private static final long serialVersionUID = 1L;

    private String statusDesc;

    private String uiAddress;

    private JobDTO job;

    @Valid
    private FlinkConfig flinkConfig;

    @Valid
    private JsonNode extraConfig;

}
