package com.miaosha.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author lzj
 * @date 2019/5/14
 */
@Getter
@Setter
@Component
public class ServerInfo {

    @Value("${server.address}")
    private String address;

    @Value("${server.port}")
    private String port;

}
