package com.example.rabbitmq.topic;

import com.example.rabbitmq.config.TopicRabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 主题模式：（通配符模式，topic）
 * 消费者2
 * @author norhtking
 */
@Component
@RabbitListener(queues = TopicRabbitConfig.TOPIC_QUEUE_NAME2)
public class TopicReceiver2 {

    /**接收消息*/
    @RabbitHandler
    public void process(String message) {
        System.out.println("Topic Receiver2  : " + message);
    }
}
