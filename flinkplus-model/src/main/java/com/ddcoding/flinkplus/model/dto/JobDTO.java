package com.ddcoding.flinkplus.model.dto;

import com.ddcoding.flinkplus.model.common.FlinkConfig;
import com.ddcoding.flinkplus.model.pojo.Job;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;

/**
 * @author: ddcoding
 * @date: 2020/1/17
 */
@Getter
@Setter
@NoArgsConstructor
public class JobDTO extends Job {
    private static final long serialVersionUID = 1L;

    private String typeDesc;

    private String lastStatusDesc;

    private String clientVersionDesc;

    private String lastUiAddress;

    @Valid
    private FlinkConfig flinkConfig;

    private JsonNode extraConfig;

    private AuthMap authMap;

    @Getter
    @Setter
    @NoArgsConstructor
    public static class AuthMap {
        private Boolean edit = false;
        private Boolean delete = false;
        private Boolean start = false;
        private Boolean stop = false;
        private Boolean restart = false;
    }

}
