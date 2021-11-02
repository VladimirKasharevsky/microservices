package com.epam.services.config;


import com.epam.services.domain.User;
import com.epam.services.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@Log4j2
public class MessageListener {

    @Autowired
    UserRepository userRepository;

    @RabbitListener(queues = MqConfig.QUEUE)
    private void listener(User user) throws InterruptedException {
        userRepository.save(user);
        log.info("User " + user.getUser() + " added to DB");
    }
}
