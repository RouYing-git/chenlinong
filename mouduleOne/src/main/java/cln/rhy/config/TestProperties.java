package cln.rhy.config;

import lombok.Data;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: 15262726991
 * @since: 2023/11/30
 */
@Data
//@EnableAutoConfiguration  加这个没用
@Configuration
//要么在此类加上面这个注解  要么在启动类加@EnableConfigurationProperties({TestProperties.class})
// 这两种方式都可以使得@ConfigurationProperties(prefix = "my.value")生效
//加@EnableAutoConfiguration没用，因为他的意义范围很大指的是在springboot项目中开启可以自动配置的功能，至于自动配置哪些它管不了，并且它包含在@SpringBootApplication注解中一般不用单拿出来写。
@ConfigurationProperties(prefix = "my.value")
public class TestProperties {

    private String pro1;

    private String pro2;

}
