package com.ddcoding.flinkplus.http;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: ddcoding
 * @date: 2020/1/27
 */
public interface FlinkRestRpcService {

    String queryJobStatus(String jobId);

    void stopJob(String jobId);

    String getJobUiAddress(String jobId);

    @Getter
    @Setter
    public class RunConfig {
        private String entryClass;
        private String programArgs;
        private Integer parallelism;
        private Boolean allowNonRestoredState;
        private String savepointPath;
    }
}
