package com.ddcoding.flinkplus.service;

import com.ddcoding.flinkplus.sql.model.SqlDebugConfig;
import com.ddcoding.flinkplus.sql.model.sqlparse.SqlParseInfo;

import java.util.List;
import java.util.Map;

/**
 * @author: ddcoding
 * @date: 2020/9/24
 */
public interface FlinkSqlService {

    SqlParseInfo parse(String sql);

    Map<String, List<String>> debug(SqlDebugConfig sqlDebugConfig);
}
