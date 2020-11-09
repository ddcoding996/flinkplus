package com.ddcoding.flinkplus.http;

import com.ddcoding.flinkplus.model.exception.PlinkException;
import org.apache.hadoop.yarn.api.records.YarnApplicationState;

/**
 * @author: ddcoding
 * @date: 2020/9/4
 */
public interface YarnClientRpcService {
    void killApplication(String appId) throws PlinkException;

    YarnApplicationState getYarnApplicationState(String appId) throws PlinkException;
}
