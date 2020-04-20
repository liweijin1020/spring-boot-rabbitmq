package com.example.rabbitmq.fanout;

import com.example.rabbitmq.config.FanoutRabbitConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 订阅模式
 * 生产者
 * @author norhtking
 */
@Component
public class FanoutSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    public void send() {
        String context = "hi, fanout msg ";
        System.out.println("Sender : " + context);
        /**路由key为空字符串表示使用默认的*/
        this.rabbitTemplate.convertAndSend(FanoutRabbitConfig.FANOUT_EXCHANGE,"", context);
    }
}
