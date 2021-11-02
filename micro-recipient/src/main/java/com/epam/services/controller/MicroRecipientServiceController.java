package com.epam.services.controller;

import com.epam.services.config.MessageListener;
import com.epam.services.domain.User;
import com.epam.services.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
@Log4j2
public class MicroRecipientServiceController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/message")
    public List<User> message(){
        List<User> list = userRepository.findAll();
        userRepository.deleteAll();
        log.info("All users deleted from DB");
        return list;
    }
}
