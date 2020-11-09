package com.ddcoding.flinkplus.sql.model.sqlparse;

import lombok.Data;

/**
 * @author: ddcoding
 * @date: 2020/7/17
 */
@Data
public class SqlParseColumn {
    private String name;
    private String type;
    private Boolean nullable;
    private String constraint;
    private String comment;
    private Boolean isPhysical = true;
}
