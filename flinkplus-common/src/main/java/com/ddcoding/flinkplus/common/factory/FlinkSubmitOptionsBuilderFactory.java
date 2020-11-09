package com.ddcoding.flinkplus.common.factory;

import com.ddcoding.flinkplus.common.builder.FlinkJarSubmitOptionsBuilder;
import com.ddcoding.flinkplus.common.builder.FlinkSqlSubmitOptionsBuilder;
import com.ddcoding.flinkplus.common.builder.FlinkSubmitOptionsBuilder;
import com.ddcoding.flinkplus.model.enums.JobTypeEnum;
import com.ddcoding.flinkplus.model.exception.PlinkMessageException;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ddcoding
 * @date: 2020/10/13
 */
public class FlinkSubmitOptionsBuilderFactory {
    private static final Map<JobTypeEnum, FlinkSubmitOptionsBuilder> builderMap = new HashMap<>();

    static {
        builderMap.put(JobTypeEnum.FLINK_JAR, new FlinkJarSubmitOptionsBuilder());
        builderMap.put(JobTypeEnum.FLINK_SQL, new FlinkSqlSubmitOptionsBuilder());
    }

    public static FlinkSubmitOptionsBuilder create(JobTypeEnum jobTypeEnum) {
        if (builderMap.containsKey(jobTypeEnum)) {
            return builderMap.get(jobTypeEnum);
        }
        throw new PlinkMessageException(jobTypeEnum + " not support");
    }
}
