package cn.ekgc.socip;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <b>智慧公务车信息平台-系统功能 Provider 启动类</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@MapperScan("cn.ekgc.socip.dao")
@EnableEurekaClient
@SpringBootApplication
public class SocipSystemProviderStarter {
	public static void main(String[] args) {
		SpringApplication.run(SocipSystemProviderStarter.class, args);
	}
}
