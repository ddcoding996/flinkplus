package com.ddcoding.flinkplus.common.builder;

import com.ddcoding.flinkplus.model.common.FlinkSubmitOptions;
import com.ddcoding.flinkplus.model.exception.FlinkPlusException;

public interface FlinkShellCommandBuilder {

    String buildRunCommand(FlinkSubmitOptions flinkSubmitOptions) throws FlinkPlusException;

}
