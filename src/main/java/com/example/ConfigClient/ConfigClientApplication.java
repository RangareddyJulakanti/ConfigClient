package com.example.ConfigClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
@RefreshScope
public class ConfigClientApplication {

	@Autowired
	ConfigClientConfiguration configClientConfiguration;
	@Value("${some.other.property}")
	private  String property;

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}
	@RequestMapping(name = "/")
	public String printConfig(){
		StringBuilder builder=new StringBuilder();
		builder.append(configClientConfiguration.getProperty());
		builder.append(" || ");
		builder.append(property);
		return  builder.toString();
	}
}
