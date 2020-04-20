package com.example.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 订阅模式
 * 配置类
 * @author norhtking
 */
@Configuration
public class FanoutRabbitConfig {
    /**队列名称*/
    public static final String FANOUT_QUEUE_NAME_A = "fanout.A";
    public static final String FANOUT_QUEUE_NAME_B = "fanout.B";
    public static final String FANOUT_QUEUE_NAME_C = "fanout.C";

    /**交换机名称*/
    public static final String FANOUT_EXCHANGE = "spring_boot_fanout_exchange";

    /**创建队列A*/
    @Bean
    public Queue aQueue() {
        return new Queue(FANOUT_QUEUE_NAME_A,true);
    }
    /**创建队列B*/
    @Bean
    public Queue bQueue() {
        return new Queue(FANOUT_QUEUE_NAME_B,true);
    }
    /**创建队列C*/
    @Bean
    public Queue cQueue() {
        return new Queue(FANOUT_QUEUE_NAME_C,true);
    }
    /**声明交换机*/
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(FANOUT_EXCHANGE);
    }
    /**将队列绑定到交换机上*/
    @Bean
    public Binding bindingAQueueAndFanoutExchange(Queue aQueue,FanoutExchange fanoutExchange) {
        /**因为广播方式，不需要设置路由key*/
        return BindingBuilder.bind(aQueue).to(fanoutExchange);
    }
    @Bean
    public Binding bindingBQueueAndFanoutExchange(Queue bQueue,FanoutExchange fanoutExchange) {
        /**因为广播方式，不需要设置路由key*/
        return BindingBuilder.bind(bQueue).to(fanoutExchange);
    }
    @Bean
    public Binding bindingCQueueAndFanoutExchange(Queue cQueue,FanoutExchange fanoutExchange) {
        /**因为广播方式，不需要设置路由key*/
        return BindingBuilder.bind(cQueue).to(fanoutExchange);
    }
}
