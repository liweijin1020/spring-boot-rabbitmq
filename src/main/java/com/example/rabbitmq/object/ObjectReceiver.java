package com.example.rabbitmq.object;

import com.example.model.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消费者：接收对象
 * @author norhtking
 */
@Component
@RabbitListener(queues = "object")
public class ObjectReceiver {

    /**接收消息*/
    @RabbitHandler
    public void process(User user) {
        System.out.println("Receiver object: " + user);
    }
}
