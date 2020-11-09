package com.ddcoding.flinkplus.web.controller;

import com.ddcoding.flinkplus.model.enums.JobClientVersionEnum;
import com.ddcoding.flinkplus.model.enums.JobInstanceStatusEnum;
import com.ddcoding.flinkplus.model.enums.JobTypeEnum;
import com.ddcoding.flinkplus.model.resp.Result;
import com.ddcoding.flinkplus.model.resp.ResultCode;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: ddcoding
 * @date: 2020/2/3
 */
@RestController
@RequestMapping("/job/enum")
public class JobEnumController {
    @RequestMapping("/jobInstanceStatus")
    public Result jobInstanceStatus() {
        return base(JobInstanceStatusEnum.class);
    }

    @RequestMapping("/jobType")
    public Result jobType() {
        return base(JobTypeEnum.class);
    }

    @RequestMapping("/jobClientVersion")
    public Result jobClientVersion() {
        return base(JobClientVersionEnum.class);
    }

    private <T extends Class> Result base(T enumClass) {
        return new Result<>(ResultCode.SUCCESS, enumClass.getEnumConstants());
    }
}
