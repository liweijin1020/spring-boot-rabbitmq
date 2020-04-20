package com.example.rabbitmq.object;

import com.example.model.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 生产者发送对象
 * @author norhtking
 */
@Component
public class ObjectSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(User user) {
        System.out.println("Sender object: " + user.toString());
        rabbitTemplate.convertAndSend("object",user);
    }
}
