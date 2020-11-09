package com.ddcoding.flinkplus.service.impl;

import com.ddcoding.flinkplus.common.util.PlinkSqlUtil;
import com.ddcoding.flinkplus.service.PlinkSqlService;
import com.ddcoding.flinkplus.sql.model.SqlDebugConfig;
import com.ddcoding.flinkplus.sql.model.sqlparse.SqlParseInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author: ddcoding
 * @date: 2020/9/24
 */
@Slf4j
@Service
public class PlinkSqlServiceImpl implements PlinkSqlService {

    /**
     * PlinkSqlParser.create(sql).getSqlParseInfo()
     *
     * @param sql flink sql
     */
    @Override
    public SqlParseInfo parse(String sql) {
        return PlinkSqlUtil.parse(sql);
    }

    /**
     * SqlDebugDriver.debug(sqlDebugConfig)
     *
     * @param sqlDebugConfig SqlDebugConfig
     * @return Map<String, List < String>>
     */
    @Override
    public Map<String, List<String>> debug(SqlDebugConfig sqlDebugConfig) {
        return PlinkSqlUtil.debug(sqlDebugConfig);
    }

}
