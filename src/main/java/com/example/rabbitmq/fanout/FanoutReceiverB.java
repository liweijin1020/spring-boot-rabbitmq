package com.example.rabbitmq.fanout;

import com.example.rabbitmq.config.FanoutRabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 订阅模式
 * 消费者A
 * @author norhtking
 */
@Component
@RabbitListener(queues = FanoutRabbitConfig.FANOUT_QUEUE_NAME_B)
public class FanoutReceiverB {
    /**接收消息*/
    @RabbitHandler
    public void process(String message) {
        System.out.println("fanout Receiver B  : " + message);
    }
}
