package com.ddcoding.flinkplus.model.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

/**
 * @author: ddcoding
 * @date: 2020/2/13
 */
@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum JobClientVersionEnum {
    V_1_10_X("1.10.x", "flink 1.10");

    private String value;
    private String desc;

    JobClientVersionEnum(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static JobClientVersionEnum getEnum(String value) {
        if (value == null)
            return null;
        for (JobClientVersionEnum jobClientVersionEnum : JobClientVersionEnum.values()) {
            if (jobClientVersionEnum.getValue().equals(value))
                return jobClientVersionEnum;
        }
        return null;
    }
}
