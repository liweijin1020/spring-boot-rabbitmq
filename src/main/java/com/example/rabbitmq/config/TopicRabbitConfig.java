package com.example.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 主题模式（通配符模式 topic）
 * 配置类
 * @author norhtking
 */
@Configuration
public class TopicRabbitConfig {
    /**队列名称*/
    public static final String TOPIC_QUEUE_NAME1 = "topic.message";
    public static final String TOPIC_QUEUE_NAME2 = "topic.messages";
    /**交换机名称*/
    public static final String TOPIC_EXCHANGE = "spring_boot_topic_exchange";

    /**创建队列*/
    @Bean
    public Queue queueTopic1() {
        return new Queue(TOPIC_QUEUE_NAME1,true);
    }
    @Bean
    public Queue queueTopic2() {
        return new Queue(TOPIC_QUEUE_NAME2,true);
    }
    /**声明交换机*/
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(TOPIC_EXCHANGE);
    }

    /**将队列绑定到交换机上*/
    @Bean
    public Binding bindingExchangeTopicQueueName1(Queue queueTopic1,TopicExchange topicExchange) {
        return BindingBuilder.bind(queueTopic1).to(topicExchange).with("topic.message");
    }
    @Bean
    public Binding bindingExchangeTopicQueueName2(Queue queueTopic2,TopicExchange topicExchange) {
        return BindingBuilder.bind(queueTopic2).to(topicExchange).with("topic.#");
    }
}
