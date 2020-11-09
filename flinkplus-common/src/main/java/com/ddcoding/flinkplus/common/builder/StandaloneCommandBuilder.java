package com.ddcoding.flinkplus.common.builder;

import com.ddcoding.flinkplus.common.util.FlinkConfigUtil;
import com.ddcoding.flinkplus.model.common.FlinkConfig;
import com.ddcoding.flinkplus.model.common.FlinkSubmitOptions;
import com.ddcoding.flinkplus.model.exception.PlinkException;
import org.apache.commons.lang3.StringUtils;
import org.apache.flink.util.Preconditions;

import java.util.stream.Collectors;
import static com.ddcoding.flinkplus.common.util.MessageFormatUtil.format;

/**
 * @author: ddcoding
 * @date: 2020/8/24
 */
public class StandaloneCommandBuilder implements FlinkShellCommandBuilder {

    public static final StandaloneCommandBuilder INSTANCE = new StandaloneCommandBuilder();

    private StandaloneCommandBuilder() {
    }

    private static final String runScript = "{0}/bin/flink run ";
    private static final String detached = "-d ";
    private static final String parallelism = "-p {0} ";
    private static final String confItem = "-D {0} ";
    private static final String mainClass = "-c {0} ";
    private static final String mainJarPath = "{0} ";
    private static final String args = "{0}";

    /**
     * 构建flink的standalone模式的shell提交命令
     * @param flinkSubmitOptions
     * @return
     */
    @Override
    public String buildRunCommand(FlinkSubmitOptions flinkSubmitOptions) throws PlinkException {
        FlinkConfig flinkConfig = flinkSubmitOptions.getFlinkConfig();
        StringBuilder builder = new StringBuilder();
        builder.append(format(runScript, FlinkConfigUtil.getFlinkHome())).append(detached);
        if (flinkConfig.getParallelism() != null) {
            builder.append(format(parallelism, flinkConfig.getParallelism()));
        }
        if (flinkConfig.getConfigs() != null) {
            builder.append(flinkConfig.getConfigs().stream().map(c -> format(confItem, c)).collect(Collectors.joining()));
        }
        if (StringUtils.isNotBlank(flinkConfig.getMainClass())) {
            builder.append(format(mainClass, flinkConfig.getMainClass()));
        }
        builder.append(format(mainJarPath, Preconditions.checkNotNull(flinkSubmitOptions.getMainJarPath())));
        if (StringUtils.isNotBlank(flinkConfig.getArgs())) {
            builder.append(format(args, flinkConfig.getArgs()));
        }
        return builder.toString();
    }
}
