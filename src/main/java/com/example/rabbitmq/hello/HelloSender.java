package com.example.rabbitmq.hello;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 简单队列
 * 生产者
 * @author norhtking
 */
@Component
public class HelloSender {
    /**定义模板*/
    @Autowired
    private RabbitTemplate rabbitTemplate;
    /**发送消息*/
    public void send() {
        String message = "hello,"+new Date();
        System.out.println("Sender : "+message);
        rabbitTemplate.convertAndSend("hello",message);
    }
}
