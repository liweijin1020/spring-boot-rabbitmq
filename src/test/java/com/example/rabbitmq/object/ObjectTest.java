package com.example.rabbitmq.object;

import com.example.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ObjectTest {
    @Autowired
    private ObjectSender objectSender;
    @Test
    public void objectTest(){
        User user = new User();
        user.setUserName("allen");
        user.setPassWord("123456");
        objectSender.send(user);
    }
}
