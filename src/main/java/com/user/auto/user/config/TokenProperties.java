package com.user.auto.user.config;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Data
@Configuration
@ConfigurationProperties(prefix = "token")
public class TokenProperties {
    private String prefix;
    private String header;
    private String secret;
    private Integer ttl;
    private List<String> whitelist;
}
