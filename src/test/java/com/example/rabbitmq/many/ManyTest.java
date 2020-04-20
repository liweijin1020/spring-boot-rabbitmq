package com.example.rabbitmq.many;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManyTest {

    @Autowired
    private NeoSender1 neoSender1;
    @Autowired
    private NeoSender2 neoSender2;

    @Test
    public void oneToMany() throws InterruptedException {
        for (int i=0; i < 100; i++) {
            this.neoSender1.send(i);
        }
    }

    @Test
    public void manyToMany() throws InterruptedException {
        for (int i = 0; i < 50; i++) {
            neoSender1.send(i);
            neoSender2.send(i);
        }
    }
}
