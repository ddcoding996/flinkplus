package com.ddcoding.flinkplus.service.transform;

import com.ddcoding.flinkplus.common.util.JsonUtil;
import com.ddcoding.flinkplus.dao.mapper.JobMapper;
import com.ddcoding.flinkplus.model.common.FlinkConfig;
import com.ddcoding.flinkplus.model.dto.JobDTO;
import com.ddcoding.flinkplus.model.dto.JobInstanceDTO;
import com.ddcoding.flinkplus.model.enums.JobInstanceStatusEnum;
import com.ddcoding.flinkplus.model.exception.FlinkPlusRuntimeException;
import com.ddcoding.flinkplus.model.pojo.Job;
import com.ddcoding.flinkplus.model.pojo.JobInstance;
import com.ddcoding.flinkplus.service.FlinkClusterService;
import com.ddcoding.flinkplus.service.factory.FlinkClusterServiceFactory;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author: ddcoding
 * @date: 2020/1/27
 */
@Service
public class JobInstanceTransform implements Transform<JobInstanceDTO, JobInstance> {
    @Autowired
    private JobMapper jobMapper;
    @Autowired
    private JobTransform jobTransform;
    @Autowired
    private FlinkClusterServiceFactory flinkClusterServiceFactory;

    @Override
    public JobInstanceDTO transform(JobInstance jobInstance) {
        if (jobInstance == null) {
            return null;
        }
        return transform(Collections.singletonList(jobInstance)).stream().findFirst().orElse(null);
    }

    @Override
    public Collection<JobInstanceDTO> transform(Collection<JobInstance> pojoList) {
        if (CollectionUtils.isEmpty(pojoList)) {
            return Collections.emptyList();
        }

        //根据jobId批量查询，提升性能
        Example example = new Example(Job.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id", pojoList.stream().map(JobInstance::getJobId).collect(Collectors.toList()));
        Map<Long, JobDTO> jobDTOMap = jobTransform.transform(jobMapper.selectByExample(example)).stream().collect(Collectors.toMap(JobDTO::getId, Function.identity()));

        FlinkClusterService defaultFlinkClusterService = flinkClusterServiceFactory.getDefaultFlinkClusterService();

        return pojoList.stream().map(jobInstance -> {
            if (jobInstance == null) {
                return null;
            }
            JobInstanceDTO jobInstanceDTO = new JobInstanceDTO();
            BeanUtils.copyProperties(jobInstance, jobInstanceDTO);
            if (jobInstanceDTO.getFlinkConfigJson() != null) {
                jobInstanceDTO.setFlinkConfig(JsonUtil.parseObject(jobInstanceDTO.getFlinkConfigJson(), FlinkConfig.class));
            } else {
                jobInstanceDTO.setFlinkConfig(new FlinkConfig());
            }
            if (jobInstanceDTO.getExtraConfigJson() != null) {
                jobInstanceDTO.setExtraConfig(JsonUtil.parseObject(jobInstanceDTO.getExtraConfigJson()));
            } else {
                jobInstanceDTO.setExtraConfig(JsonNodeFactory.instance.objectNode());
            }
            //setLastStatusDesc
            JobInstanceStatusEnum statusEnum = JobInstanceStatusEnum.getEnum(jobInstance.getStatus());
            if (statusEnum != null) {
                jobInstanceDTO.setStatusDesc(statusEnum.getDesc());
            }
            if (jobInstance.getAppId() != null) {
                try {
                    jobInstanceDTO.setUiAddress(defaultFlinkClusterService.getJobUiAddress(jobInstanceDTO));
                } catch (Exception e) {
                    throw new FlinkPlusRuntimeException(e);
                }
            }

            if (jobInstance.getJobId() != null) {
                jobInstanceDTO.setJob(jobDTOMap.get(jobInstance.getJobId()));
            }
            return jobInstanceDTO;
        }).collect(Collectors.toList());
    }

    @Override
    public JobInstance inverseTransform(JobInstanceDTO dto) {
        if (dto == null) {
            return null;
        }
        return inverseTransform(Collections.singletonList(dto)).stream().findFirst().orElse(null);
    }

    @Override
    public Collection<JobInstance> inverseTransform(Collection<JobInstanceDTO> dtoList) {
        return dtoList.stream().map(dto -> {
            if (dto == null) {
                return null;
            }
            if (dto.getFlinkConfig() != null) {
                dto.setFlinkConfigJson(JsonUtil.toJSONString(dto.getFlinkConfig()));
            }
            if (dto.getExtraConfig() != null) {
                dto.setExtraConfigJson(JsonUtil.toJSONString(dto.getExtraConfig()));
            }
            return dto;
        }).collect(Collectors.toList());
    }
}
