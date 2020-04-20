package com.example.rabbitmq.topic;

import com.example.rabbitmq.config.TopicRabbitConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 主题模式：（通配符模式，topic）
 * @author norhtking
 */
@Component
public class TopicSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send() {
        String context = "hi, i am message all";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend(TopicRabbitConfig.TOPIC_EXCHANGE, "topic.1", context);
    }
    public void send1() {
        String context = "hi, i am message 1";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend(TopicRabbitConfig.TOPIC_EXCHANGE, "topic.message", context);
    }
    public void send2() {
        String context = "hi, i am message 2";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend(TopicRabbitConfig.TOPIC_EXCHANGE, "topic.messages", context);
    }
}
