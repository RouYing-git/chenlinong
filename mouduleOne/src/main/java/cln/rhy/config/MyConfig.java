package cln.rhy.config;

import cln.rhy.test.Class1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

/**
 * @description:
 * @author: 15262726991
 * @since: 2023/11/15
 */
@Configuration
public class MyConfig {

    @Bean
    public static Class1 createClass(@Value("${myProperty}") String myProperty) {
        System.out.println(LocalDateTime.now() + "现在我在createClass方法内部" + myProperty);
        return new Class1(myProperty, "123");
    }

    public static void main(String[] args) {
       /* String d = "file:/opt/sinitek/nasdata2/yui/hgf";
        String replace = d.replaceAll("ss", "https://test-ireswechat.mszq.com/wechat");
        System.out.println(replace);*/
        long l = Math.addExact(12345L, 34567908L);
        System.out.println(l);
    }

}
