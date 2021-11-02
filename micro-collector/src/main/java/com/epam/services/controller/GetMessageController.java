package com.epam.services.controller;


import com.epam.services.domain.User;
import com.epam.services.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
public class GetMessageController {

    @Autowired
    private MessageClient messageClient;

    @Autowired
    UserRepository userRepository;

    @GetMapping
    @Scheduled(fixedRate = 15000)
    public List<User> getMessage() {
        List<User> users = messageClient.getAllMessages();
        if (users.size() == 0) {
            log.info("No messages to add");
        } else {
            users.forEach(user -> {
                userRepository.save(user);
                log.info("User {} was added to DB", user.getUser());
            });
        }
        return users;
    }
}
