# Hbase
docker 部署 
docker run -d -h hbase -p 2181:2181 -p 8080:8080 -p 8085:8085 -p 9090:9090 -p 9095:9095 -p 16000:16000 -p 16010:16010 -p 16020:16020 --name hbase1.3 harisekhon/hbase:1.3

springboot 整合Hbase

文章地址：https://juejin.im/post/5f16460be51d45348165fb6d