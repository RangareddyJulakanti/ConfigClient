package com.example.ConfigClient;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created by RANGAREJ on 8/27/2017.
 */
@Configuration
@ConfigurationProperties(prefix = "some.other")
@RefreshScope
public class ConfigClientConfiguration {
    private String property;

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }
}
