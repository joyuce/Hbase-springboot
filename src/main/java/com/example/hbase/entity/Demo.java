package com.example.hbase.entity;

import com.example.hbase.hbase.HbaseColumn;
import com.example.hbase.hbase.HbaseTable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Sorin
 * @Descriptions:
 * @Date: Created in 2018/3/22
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@HbaseTable(tableName = "t_demo")
public class Demo {

    @HbaseColumn(family = "rowkey", qualifier = "rowkey")
    private String id;

    @HbaseColumn(family = "demo", qualifier = "content")
    private String content;

    @HbaseColumn(family = "demo", qualifier = "avg")
    private String avg;

}
