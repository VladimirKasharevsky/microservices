package com.epam.services.controller;

import com.epam.services.domain.User;
import com.epam.services.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/")
@Log4j2
public class MicroVisualizerServiceController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/saved-messages")
    public List<User> message(){
        System.out.println("11111");
        List<User> list = userRepository.findAll();
        userRepository.findAll();
        log.info(Arrays.toString(list.toArray()));
        return list;
    }
}
