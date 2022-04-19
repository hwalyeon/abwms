package kr.co.seculink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@EnableDiscoveryClient
public class AbWmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbWmsApplication.class, args);
	}
	
    /**
     * AWS redis의 경우 CONFIG등 명령어를 허용하지 않음
     * local 제외
     * @return
     */
    /*
    @Profile(value = {"!local"})
    @Bean
    public ConfigureRedisAction configureRedisAction() {
        return ConfigureRedisAction.NO_OP;
    }
    */

}
