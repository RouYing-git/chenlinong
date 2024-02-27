package cln.rhy.config;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;
import java.util.HashSet;
import java.util.Set;

/**
 * redis连接池配置
 */
@Configuration
public class RedisConfig {

    @Value("${spring.redis.host:localhost}")
    private String host;
    @Value("${spring.redis.password}")
    private String password;
    @Value("${spring.redis.port:6379}")
    private Integer port;
    @Value("${spring.redis.database:1}")
    private Integer database;
    @Value("${spring.redis.lettuce.pool.max-idle:20}")
    private Integer maxIdle;
    @Value("${spring.redis.lettuce.pool.min-idle:20}")
    private Integer minIdle;
    @Value("${spring.redis.lettuce.pool.max-active:100}")
    private Integer maxTotal;
    @Value("${spring.redis.lettuce.pool.max-wait}")
    private String maxWaitMillis;
    @Value("${spring.redis.lettuce.shutdown-timeout}")
    private String shutdownTimeoutMillis;
    @Value("${spring.redis.timeout}")
    private String timeoutMillis;

    @Bean
    LettuceConnectionFactory lettuceConnectionFactory() {
        // 连接池配置
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        poolConfig.setMaxIdle(maxIdle);
        poolConfig.setMinIdle(minIdle);
        poolConfig.setMaxTotal(maxTotal);

        // 参数兜底
        if (null == maxWaitMillis || "".equals(maxWaitMillis)) {
            poolConfig.setMaxWaitMillis(5000L);
        } else {
            maxWaitMillis = maxWaitMillis.replace("ms", "");
            poolConfig.setMaxWaitMillis(Long.valueOf(maxWaitMillis));
        }

        Integer shutdownTimeout;
        if (null == shutdownTimeoutMillis || "".equals(shutdownTimeoutMillis)) {
            shutdownTimeout = 100;
        } else {
            shutdownTimeoutMillis = shutdownTimeoutMillis.replace("ms", "");
            shutdownTimeout = Integer.valueOf(shutdownTimeoutMillis);
        }

        Integer timeout;
        if (null == timeoutMillis || "".equals(timeoutMillis)) {
            timeout = 5000;
        } else {
            timeoutMillis = timeoutMillis.replace("ms", "");
            timeout = Integer.valueOf(timeoutMillis);
        }

        LettucePoolingClientConfiguration.LettucePoolingClientConfigurationBuilder builder =
            LettucePoolingClientConfiguration.builder();
        builder.poolConfig(poolConfig);
        builder.commandTimeout(Duration.ofSeconds(timeout / 1000));
        builder.shutdownTimeout(Duration.ofMillis(shutdownTimeout));
        LettucePoolingClientConfiguration lettuceConfig = builder.build();

        // 区分单机还是集群
        String[] nodeArr = host.split(",");

        if (1 == nodeArr.length) {
            // 单机redis
            RedisStandaloneConfiguration redisConfig = new RedisStandaloneConfiguration();

            redisConfig.setHostName(host);
            redisConfig.setPort(port);
            if (password != null && !"".equals(password)) {
                redisConfig.setPassword(RedisPassword.of(password));
            }
            return new LettuceConnectionFactory(redisConfig, lettuceConfig);
        } else {
            // 集群redis
            RedisClusterConfiguration redisConfig = new RedisClusterConfiguration();
            Set<RedisNode> nodes = new HashSet<>();
            String[] arr;
            for (String node : nodeArr) {
                arr = node.split(":");
                if (1 == arr.length) {
                    nodes.add(new RedisNode(arr[0], port));
                } else {
                    nodes.add(new RedisNode(arr[0], Integer.valueOf(arr[1])));
                }
            }
            redisConfig.setClusterNodes(nodes);
            // 跨集群执行命令时要遵循的最大重定向数量
            redisConfig.setMaxRedirects(3);
            redisConfig.setPassword(RedisPassword.of(password));
            return new LettuceConnectionFactory(redisConfig, lettuceConfig);
        }
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(LettuceConnectionFactory lettuceConnectionFactory) {
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        lettuceConnectionFactory.setDatabase(database);
        template.setConnectionFactory(lettuceConnectionFactory);
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        // key采用String的序列化方式
        template.setKeySerializer(stringRedisSerializer);
        template.setValueSerializer(jackson2JsonRedisSerializer);
        template.setHashKeySerializer(stringRedisSerializer);
        template.setHashValueSerializer(stringRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }
}