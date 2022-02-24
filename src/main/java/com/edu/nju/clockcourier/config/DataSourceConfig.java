package com.edu.nju.clockcourier.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 * Created by zzh on 2022/2/24.
 */
@Configuration
@MapperScan({"com.edu.nju.clockcourier.dao"})
public class DataSourceConfig {
}
