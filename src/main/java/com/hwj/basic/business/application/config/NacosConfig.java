package com.hwj.basic.business.application.config;

import com.alibaba.nacos.spring.context.annotation.config.EnableNacosConfig;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableNacosConfig
@NacosPropertySource(dataId = "hwj-basic-business-application-env.properties", groupId = "hwj", autoRefreshed = true)
public class NacosConfig {

}
