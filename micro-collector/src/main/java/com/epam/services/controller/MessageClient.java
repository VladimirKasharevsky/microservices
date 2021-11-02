package com.epam.services.controller;

import com.epam.services.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("recipient")
public interface MessageClient {

    @GetMapping("/message")
    List<User> getAllMessages();
}
