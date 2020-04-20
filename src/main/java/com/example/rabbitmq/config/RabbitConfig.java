package com.example.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类
 * @author norhtking
 */
@Configuration
public class RabbitConfig {
    @Bean
    public Queue helloQueue() {
        return new Queue("hello");
    }

    /**多对多*/
    @Bean
    public Queue neoQueue() {
        return new Queue("neo");
    }

    /**发送对象*/
    @Bean
    public Queue objectQueue() {
        return new Queue("object");
    }
}
