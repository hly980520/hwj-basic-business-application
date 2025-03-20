package com.hwj.basic.business.application.config;

import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.StringJoiner;

/**
 * @Program: hwj
 * @Description: xxl-job配置类
 * @author: peng.huang
 * @since: 2025-03-20 17:22:20
 */
@Configuration
@ConfigurationProperties(prefix = "hwj.xxl-job.executor")
public class XxlJobConfig {

    private static final Logger logger = LoggerFactory.getLogger(XxlJobConfig.class);


    private String addresses;

    private String appName;

    private String ip;

    private Integer port;

    private String accessToken;

    private String logPath;

    private Integer logRetentionDays;

    @Bean
    public XxlJobSpringExecutor xxlJobExecutor() {
        logger.info(">>>>>>>>>>> xxl-job config init.");
        XxlJobSpringExecutor xxlJobSpringExecutor = new XxlJobSpringExecutor();
        xxlJobSpringExecutor.setAdminAddresses(addresses);
        xxlJobSpringExecutor.setAppname(appName);
        xxlJobSpringExecutor.setIp(ip);
        xxlJobSpringExecutor.setPort(port);
        xxlJobSpringExecutor.setAccessToken(accessToken);
        xxlJobSpringExecutor.setLogPath(logPath);
        xxlJobSpringExecutor.setLogRetentionDays(logRetentionDays);

        return xxlJobSpringExecutor;
    }

    public String getAddresses() {
        return addresses;
    }

    public void setAddresses(String addresses) {
        this.addresses = addresses;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getLogPath() {
        return logPath;
    }

    public void setLogPath(String logPath) {
        this.logPath = logPath;
    }

    public Integer getLogRetentionDays() {
        return logRetentionDays;
    }

    public void setLogRetentionDays(Integer logRetentionDays) {
        this.logRetentionDays = logRetentionDays;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", XxlJobConfig.class.getSimpleName() + "[", "]")
                .add("addresses='" + addresses + "'")
                .add("appName='" + appName + "'")
                .add("ip='" + ip + "'")
                .add("port=" + port)
                .add("accessToken='" + accessToken + "'")
                .add("logPath='" + logPath + "'")
                .add("logRetentionDays=" + logRetentionDays)
                .toString();
    }
}
