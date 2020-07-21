package com.example.hbase.hbase;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class HconnectionFactory implements InitializingBean {

    protected final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${hbase.zookeeper.quorum}")
    private String zkQuorum;

    //@Value("${hbase.master}")
    //private String hBaseMaster;
    //
    //@Value("${hbase.zookeeper.property.clientPort}")
    //private String zkPort;

    private static Configuration conf = HBaseConfiguration.create();

    public static Connection connection;

    @Override
    public void afterPropertiesSet(){
        //conf.set("hbase.master","xx:16000");
        conf.set("hbase.zookeeper.quorum", zkQuorum);
        //conf.set("zookeeper.znode.parent", "/hbase");
        try {
            connection = ConnectionFactory.createConnection(conf);
            logger.info("获取connectiont连接成功！");
        } catch (IOException e) {
            e.printStackTrace ();
            logger.error("获取connectiont连接失败！");
        }
    }

    public static void main(String[] args) throws IOException {
        //第一步，设置HBsae配置信息
        Configuration configuration = HBaseConfiguration.create();
        configuration.set("hbase.zookeeper.quorum","xx");  //hbase 服务地址
        //这里使用的是接口Admin   该接口有一个实现类HBaseAdmin   也可以直接使用这个实现类
        // HBaseAdmin baseAdmin = new HBaseAdmin(configuration);
        Admin admin = ConnectionFactory.createConnection(configuration).getAdmin();
        if(admin !=null){
            try {
                //获取到数据库所有表信息
                HTableDescriptor[] allTable = admin.listTables();
                for (HTableDescriptor hTableDescriptor : allTable) {
                    System.out.println(hTableDescriptor.getNameAsString());
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
