package com.ddcoding.flinkplus.sql.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: ddcoding
 * @date: 2020/7/8
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SqlConfig {
    private String jobName;
    private String sql;
}
