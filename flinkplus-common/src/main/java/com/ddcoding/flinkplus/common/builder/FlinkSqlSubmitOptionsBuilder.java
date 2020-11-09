package com.ddcoding.flinkplus.common.builder;

import com.ddcoding.flinkplus.common.util.JsonUtil;
import com.ddcoding.flinkplus.common.util.PlinkSqlUtil;
import com.ddcoding.flinkplus.common.util.PlinkUtil;
import com.ddcoding.flinkplus.model.common.FlinkConfig;
import com.ddcoding.flinkplus.model.common.FlinkSubmitOptions;
import com.ddcoding.flinkplus.model.dto.JobInstanceDTO;
import com.ddcoding.flinkplus.sql.model.SqlConfig;
import org.apache.commons.text.StringEscapeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ddcoding
 * @date: 2020/10/13
 */
public class FlinkSqlSubmitOptionsBuilder implements FlinkSubmitOptionsBuilder {
    @Override
    public FlinkSubmitOptions builder(JobInstanceDTO jobInstanceDTO) {
        String jobName = "FLINKPLUS_SQL_" + jobInstanceDTO.getJob().getName();
        FlinkSubmitOptions flinkSubmitOptions = new FlinkSubmitOptions();
        flinkSubmitOptions.setJobName(jobName);
        flinkSubmitOptions.setMainJarPath(PlinkUtil.getPlinkHome() + PlinkSqlUtil.SQL_JAR_FILE);
        FlinkConfig flinkConfig = jobInstanceDTO.getFlinkConfig();
        flinkConfig.setMainClass(PlinkSqlUtil.PLINK_SQL_JOB_DRIVER_CLASS_NAME);
        SqlConfig sqlConfig = new SqlConfig();
        sqlConfig.setJobName(jobName);
        sqlConfig.setSql(jobInstanceDTO.getExtraConfig().get("sql").textValue());
        List<String> args = new ArrayList<>();
        args.add("\"-c\"");
        args.add('"' + StringEscapeUtils.escapeJava(JsonUtil.toJSONString(sqlConfig)) + '"');
        flinkConfig.setArgs(String.join(" ", args));
        flinkSubmitOptions.setFlinkConfig(flinkConfig);
        return flinkSubmitOptions;
    }
}
