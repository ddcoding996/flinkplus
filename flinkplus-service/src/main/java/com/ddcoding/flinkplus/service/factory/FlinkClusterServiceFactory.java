package com.ddcoding.flinkplus.service.factory;

import com.ddcoding.flinkplus.service.FlinkClusterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: ddcoding
 * @date: 2020/1/19
 */
@Service
public class FlinkClusterServiceFactory {

    private final static String FLINK_CLUSTER_SERVICE_SUFFIX = "FlinkClusterServiceImpl";

    @Value("${cluster.mode}")
    private String defaultClusterMode;

    @Autowired
    Map<String, FlinkClusterService> flinkClusterServiceMap = new ConcurrentHashMap<>();

    public FlinkClusterService getDefaultFlinkClusterService() {
        return getFlinkClusterService(defaultClusterMode);
    }

    public FlinkClusterService getFlinkClusterService(String mode) {
        String serviceName = mode + FLINK_CLUSTER_SERVICE_SUFFIX;
        FlinkClusterService flinkClusterService = flinkClusterServiceMap.get(serviceName);
        if (flinkClusterService == null) {
            throw new RuntimeException("no flinkClusterServiceImpl defined " + serviceName);
        }
        return flinkClusterService;
    }
}
