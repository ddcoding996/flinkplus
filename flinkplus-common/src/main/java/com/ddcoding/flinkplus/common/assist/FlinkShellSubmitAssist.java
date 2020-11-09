package com.ddcoding.flinkplus.common.assist;

import com.ddcoding.flinkplus.common.builder.FlinkShellCommandBuilder;
import com.ddcoding.flinkplus.common.builder.FlinkSubmitOptionsBuilder;
import com.ddcoding.flinkplus.common.factory.FlinkSubmitOptionsBuilderFactory;
import com.ddcoding.flinkplus.common.util.FileUtil;
import com.ddcoding.flinkplus.model.common.FlinkSubmitOptions;
import com.ddcoding.flinkplus.model.dto.JobInstanceDTO;
import com.ddcoding.flinkplus.model.enums.JobTypeEnum;
import com.ddcoding.flinkplus.model.exception.PlinkMessageException;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.ddcoding.flinkplus.common.util.MessageFormatUtil.format;

/**
 * @author: ddcoding
 * @date: 2020/1/19
 */
@Slf4j
public class FlinkShellSubmitAssist {
    private final FlinkShellCommandBuilder flinkShellCommandBuilder;
    private final String appIdRegex;
    private final Pattern compile;

    public FlinkShellSubmitAssist(FlinkShellCommandBuilder flinkShellCommandBuilder, String appIdRegex) {
        this.flinkShellCommandBuilder = flinkShellCommandBuilder;
        this.appIdRegex = appIdRegex;
        compile = Pattern.compile(appIdRegex);
    }

    //提交flink任务
    public String submitJob(JobInstanceDTO jobInstanceDTO, String logFile) throws Exception {
        JobTypeEnum jobTypeEnum = JobTypeEnum.getEnum(jobInstanceDTO.getJob().getType());
        FlinkSubmitOptionsBuilder flinkSubmitOptionsBuilder = FlinkSubmitOptionsBuilderFactory.create(jobTypeEnum);
        FlinkSubmitOptions flinkSubmitOptions = flinkSubmitOptionsBuilder.builder(jobInstanceDTO);
        String runCommand = flinkShellCommandBuilder.buildRunCommand(flinkSubmitOptions);
        String command = format("{0} >> {1} 2>&1", runCommand, logFile);
        log.debug("command:{}", command);
        log.info("jobInstance {} logging to file {}", jobInstanceDTO.getId(), logFile);
        //執行提交，本质还是执行shell命令
        int exitCode = syncExecShellCommand(command);
        if (exitCode != 0) {
            throw new PlinkMessageException("submit job failed! exitCode is " + exitCode);
        }
        String log = FileUtil.readFileToString(logFile);
        Matcher matcher = compile.matcher(log);
        if (matcher.find() && matcher.groupCount() == 1) {
            return matcher.group(1);
        }
        return null;
    }

    //执行flink任务，执行shell任务提交
    public static int syncExecShellCommand(String command) throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("/bin/sh", "-c", command);
        Process process = processBuilder.start();
        return process.waitFor();
    }
}
