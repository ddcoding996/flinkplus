package com.ddcoding.flinkplus.web.controller;

import com.ddcoding.flinkplus.model.dto.JobInstanceDTO;
import com.ddcoding.flinkplus.model.req.PageReq;
import com.ddcoding.flinkplus.model.resp.Result;
import com.ddcoding.flinkplus.model.resp.ResultCode;
import com.ddcoding.flinkplus.service.JobInstanceService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * JobInstance
 *
 * @Author ddcoding
 * @Create 2020/1/21 9:50
 */
@RestController
@RequestMapping("/jobInstance")
public class JobInstanceController {
    @Autowired
    private JobInstanceService jobInstanceService;

    /**
     * 查询作业列表
     */
    @RequestMapping("/queryJobInstances")
    public Result<PageInfo<JobInstanceDTO>> queryJobInstances(JobInstanceDTO jobInstanceDTO, PageReq pageReq) {
        PageInfo<JobInstanceDTO> jobInstanceDTOPageInfo = jobInstanceService.queryJobInstances(jobInstanceDTO, pageReq);
        return new Result<>(ResultCode.SUCCESS, jobInstanceDTOPageInfo);
    }

    /**
     * 查询实例启动日志
     *
     * @param jobInstanceId 作业实例id
     */
    @RequestMapping("/startLog/{jobInstanceId}")
    public Result<String> queryJob(@PathVariable(value = "jobInstanceId") @NotNull Long jobInstanceId) {
        String startLog = jobInstanceService.startLog(jobInstanceId);
        return new Result<>(ResultCode.SUCCESS, ResultCode.SUCCESS.getDesc(), startLog);
    }
}
