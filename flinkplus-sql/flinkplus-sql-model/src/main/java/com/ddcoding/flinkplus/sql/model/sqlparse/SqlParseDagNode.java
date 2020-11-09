package com.ddcoding.flinkplus.sql.model.sqlparse;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ddcoding
 * @date: 2020/7/30
 */
@Data
@NoArgsConstructor
public class SqlParseDagNode {
    private SqlParseNode node;
    private List<SqlParseDagNode> childList = new ArrayList<>();

    public SqlParseDagNode(SqlParseNode node) {
        this.node = node;
    }
}
