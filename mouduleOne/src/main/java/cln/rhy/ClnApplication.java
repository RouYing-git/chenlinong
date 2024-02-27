package cln.rhy;

import cln.rhy.config.MyConfig;
import cln.rhy.config.TestProperties;
import cln.rhy.test.Class1;
import cln.rhy.test.DebugInvocationHandler;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import java.time.LocalDateTime;

/**
 * @description:
 * @author: 15262726991
 * @since: 2023/11/15
 */
@SpringBootApplication
//@EnableConfigurationProperties({TestProperties.class})
public class ClnApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClnApplication.class, args);
    }
}
