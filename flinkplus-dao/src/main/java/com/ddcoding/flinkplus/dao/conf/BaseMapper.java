package com.ddcoding.flinkplus.dao.conf;


import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by ddcoding on 2020/01/10
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
