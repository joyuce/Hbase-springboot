package com.example.hbase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hbase.entity.Demo;
import com.example.hbase.hbase.HBaseDaoUtil;

/**
 * @Author: Sorin
 * @Descriptions:
 * @Date: Created in 2018/3/21
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private HBaseDaoUtil hBaseDaoUtil;

    @GetMapping("/save")
    public Object save() {
        Demo demo = new Demo("1", "2323", "sajosj");
        boolean r = hBaseDaoUtil.save(demo);
        return r;
    }

    @GetMapping("/get")
    public Object getBean() {
        List<Demo> demo = hBaseDaoUtil.get(new Demo(), "1");
        return demo;
    }
}
