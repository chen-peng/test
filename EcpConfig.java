
package com.xwtec.coupon.config;

import com.xwtech.xwecp.service.logic.client.XWECPLIClient;
import com.xwtech.xwecp.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;


/**
 *  * @author chenpeng
 *   */
@Configuration
public class EcpConfig {

    private static final Logger logger = LoggerFactory.getLogger(EcpConfig.class);

    @Value("${ecp.platform.url}")
    private String platformUrl;
    @Value("${ecp.client.channel}")
    private String clientChannel;
    @Value("${ecp.platform.user}")
    private String platformUser;
    @Value("${ecp.platform.password}")
    private String platformPassword;
    @Value("${ecp.connection.timeout}")
    private String connectionTimeout;
    @Value("${ecp.connection.soTimeout}")
    private String connectionSoTimeout;
    @Value("${ecp.connection.maxThread}")
    private String connectionMaxThread;
    @Value("${ecp.connection.maxConnectionsPerHost}")
    private String connectionMaxConnectionsPerHost;
    @Value("${ecp.client.logger}")
    private String clientLogger;
    @Value("${ecp.client.isLog}")
    private String clientIsLog;

    @Bean
    public XWECPLIClient xWECPLIClient() {
        XWECPLIClient xwecpliClient = null;
        logger.info("初始化 XWECPLIClient 开始.");
        if (!StringUtil.isNull(platformUrl) && !StringUtil.isNull(clientChannel) && !StringUtil.isNull(platformUrl) && !StringUtil.isNull(platformPassword)) {
            Properties props = new Properties();
            props.put("platform.url", platformUrl);
            props.put("client.channel", clientChannel);
            props.put("platform.user", platformUser);
            props.put("platform.password", platformPassword);
            props.put("connection.timeout", connectionTimeout);
            props.put("connection.soTimeout", connectionSoTimeout);
            props.put("connection.maxThread", connectionMaxThread);
            props.put("connection.maxConnectionsPerHost", connectionMaxConnectionsPerHost);
            props.put("client.logger", clientLogger);
            props.put("client.isLog", clientIsLog);
            xwecpliClient = XWECPLIClient.createInstance(props);
            logger.info("ecp platformUrl:{}", platformUrl);
            logger.info("ecp clientChannel:{}", clientChannel);
            logger.info("ecp platformUser:{}", platformUser);
            logger.info("ecp platformPassword:{}", platformPassword);
            logger.info("ecp connectionTimeout:{}", connectionTimeout);
            logger.info("ecp connectionSoTimeout:{}", connectionSoTimeout);
            logger.info("ecp connectionMaxThread:{}", connectionMaxThread);
            logger.info("ecp connectionMaxConnectionsPerHost:{}", connectionMaxConnectionsPerHost);
            logger.info("ecp clientLogger:{}", clientLogger);
            logger.info("ecp clientIsLog:{}", clientIsLog);

            logger.info("初始化 XWECPLIClient 成功.");
        } else {
            logger.error("初始化 XWECPLIClient 失败.请检查以下ECP初始化参数是否配置：ecp.platform.url|ecp.platform.channel|ecp.platform.user|ecp.platform.password");
        }
        return xwecpliClient;
    }

}

