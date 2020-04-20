package com.example.rabbitmq.many;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 多对多
 * 消费者1
 * @author norhtking
 */
@Component
@RabbitListener(queues = "neo")
public class NeoReceiver1 {

    @RabbitHandler
    public void process(String neo) {
        System.out.println("Receiver1 : " +neo);
    }
}
