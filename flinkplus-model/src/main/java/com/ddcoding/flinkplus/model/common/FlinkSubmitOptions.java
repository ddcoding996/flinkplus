package com.ddcoding.flinkplus.model.common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author: ddcoding
 * @date: 2020/8/24
 */
@Getter
@Setter
@NoArgsConstructor
public class FlinkSubmitOptions {
    private String jobName;
    private String queue;
    private String savePointPath;
    private String libPath;
    private String mainJarPath;
    private FlinkConfig flinkConfig;
}
