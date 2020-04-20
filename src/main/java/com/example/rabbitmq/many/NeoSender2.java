package com.example.rabbitmq.many;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 多对多
 * 生产者2
 * @author norhtking
 */
@Component
public class NeoSender2 {
    /**Rabbit模板*/
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(int i) throws InterruptedException {
        String context = "spring boot neo queue"+" ****** "+i;
        /**模仿业务量大，有延时*/
        Thread.sleep(1000);
        System.out.println("Sender2 : " + context);
        this.rabbitTemplate.convertAndSend("neo", context);
    }
}
