package com.ddcoding.flinkplus.http.impl;

import com.ddcoding.flinkplus.common.util.HadoopConfigUtil;
import com.ddcoding.flinkplus.http.YarnClientRpcService;
import com.ddcoding.flinkplus.model.exception.FlinkPlusException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.flink.util.Preconditions;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.security.UserGroupInformation;
import org.apache.hadoop.service.Service.STATE;
import org.apache.hadoop.yarn.api.records.ApplicationReport;
import org.apache.hadoop.yarn.api.records.YarnApplicationState;
import org.apache.hadoop.yarn.client.api.YarnClient;
import org.apache.hadoop.yarn.util.ConverterUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author: ddcoding
 * @date: 2020/9/4
 */
@Slf4j
@Service
public class YarnClientRpcServiceImpl implements YarnClientRpcService {
    @Value("${kerberos.keytab}")
    private String kerberosKeytab;
    @Value("${kerberos.principal}")
    private String kerberosPrincipal;

    private YarnClient reusableYarnClient;

    @Override
    public void killApplication(String appId) throws FlinkPlusException {
        try {
            YarnClient yarnClient = getReusableYarnClient();
            yarnClient.killApplication(ConverterUtils.toApplicationId(appId));
        } catch (Exception e) {
            throw new FlinkPlusException(e);
        }
    }

    @Override
    public YarnApplicationState getYarnApplicationState(String appId) throws FlinkPlusException {
        return getYarnApplicationState(HadoopConfigUtil.getHadoopHome(), appId);
    }

    public YarnApplicationState getYarnApplicationState(String hadoopHome, String appId) {
        Preconditions.checkArgument(StringUtils.isNotBlank(hadoopHome), "hadoopHome is empty");
        Preconditions.checkArgument(StringUtils.isNotBlank(appId), "appId is empty");
        try {
            YarnClient yarnClient = getReusableYarnClient();
            ApplicationReport report = yarnClient.getApplicationReport(ConverterUtils.toApplicationId(appId));
            Preconditions.checkNotNull(report, "getYarnApplicationReport is null");
            return report.getYarnApplicationState();
        } catch (Exception e) {
            log.error("getYarnApplicationState fail...hadoopHome={},appId={}", hadoopHome, appId, e);
        }
        return null;
    }

    private YarnClient getYarnClient() throws FlinkPlusException, IOException {
        YarnClient yarnClient = YarnClient.createYarnClient();
        Configuration config = HadoopConfigUtil.getConfiguration();
        if (StringUtils.isNotBlank(kerberosKeytab) && StringUtils.isNotBlank(kerberosPrincipal)) {
            UserGroupInformation.setConfiguration(config);
            UserGroupInformation.loginUserFromKeytab(kerberosPrincipal, kerberosKeytab);
        }
        yarnClient.init(config);
        yarnClient.start();
        return yarnClient;
    }

    private synchronized YarnClient getReusableYarnClient() throws FlinkPlusException, IOException {
        if (reusableYarnClient == null || !reusableYarnClient.isInState(STATE.STARTED)) {
            reusableYarnClient = getYarnClient();
        }
        return reusableYarnClient;
    }

}
