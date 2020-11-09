package com.ddcoding.flinkplus.web.controller;

import com.ddcoding.flinkplus.model.resp.Result;
import com.ddcoding.flinkplus.model.resp.ResultCode;
import com.ddcoding.flinkplus.service.PlinkSqlService;
import com.ddcoding.flinkplus.sql.model.SqlDebugConfig;
import com.ddcoding.flinkplus.sql.model.sqlparse.SqlParseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author: ddcoding
 * @date: 2020/8/18
 */
@RestController
@RequestMapping("/sql")
public class SqlController {
    @Autowired
    private PlinkSqlService plinkSqlService;


    /**
     * parse sql
     *
     * @param sql
     * @return
     */
    @RequestMapping("/parse")
    public Result<SqlParseInfo> parse(String sql) {
        return new Result<>(ResultCode.SUCCESS, plinkSqlService.parse(sql));
    }

    /**
     * debug sql
     *
     * @param sqlDebugConfig SqlDebugConfig
     * @return Result<Map < String, List < String>>>  map<tableName,resultData>
     */
    @PostMapping("/debug")
    public Result<Map<String, List<String>>> debug(@RequestBody SqlDebugConfig sqlDebugConfig) {
        return new Result<>(ResultCode.SUCCESS, plinkSqlService.debug(sqlDebugConfig));
    }
}
