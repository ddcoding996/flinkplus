package com.ddcoding.flinkplus.model.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * Flink 作业实例
 *
 * @author ddcoding
 * @date 2020/01/13
 */
@Getter
@Setter
@NoArgsConstructor
public class JobInstance extends BaseModel {
    private static final long serialVersionUID = 1L;
    /**
     * 作业id
     */
    private Long jobId;
    /**
     * 实例启动时的镜像作业配置
     */
    private String flinkConfigJson;
    /**
     * 实例启动时的镜像作业配置
     */
    private String extraConfigJson;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 提交到集群返回的任务id
     */
    private String appId;
    /**
     * 启动时间
     */
    private Date startTime;
    /**
     * 停止时间
     */
    private Date stopTime;
}
