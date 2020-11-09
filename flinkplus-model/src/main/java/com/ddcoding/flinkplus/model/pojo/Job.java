package com.ddcoding.flinkplus.model.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Flink 作业
 *
 * @author ddcoding
 * @date 2020/01/13
 */
@Getter
@Setter
@NoArgsConstructor
public class Job extends BaseModel {
    private static final long serialVersionUID = 1L;
    /**
     * Flink作业名称，全局唯一
     */
    @NotBlank(message = "job name must not be empty")
    private String name;
    /**
     * 作业描述
     */
    private String description;
    /**
     * 作业类型
     */
    @NotNull(message = "job type must not be null")
    private Integer type;
    /**
     * Flink 客户端版本
     */
    private String clientVersion;
    /**
     * 作业flink参数配置
     */
    private String flinkConfigJson;
    /**
     * 作业额外配置
     */
    private String extraConfigJson;
    /**
     * 最新实例ID
     */
    private Long lastInstanceId;
    /**
     * 最新实例状态
     *
     */
    private Integer lastStatus;
    /**
     * 最新实例对应的集群任务id
     */
    private String lastAppId;
    /**
     * 最新实例启动时间
     */
    private Date lastStartTime;
    /**
     * 最新实例停止时间
     */
    private Date lastStopTime;
}
