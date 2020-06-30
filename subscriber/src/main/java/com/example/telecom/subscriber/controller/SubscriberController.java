package com.example.telecom.subscriber.controller;

import com.example.telecom.subscriber.model.Message;
import com.example.telecom.subscriber.service.SubscriberService;

import javassist.NotFoundException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SubscriberController {

  private final SubscriberService subscriberService;

  @PostMapping
  public void addMessage(@RequestBody Message message) throws NotFoundException {
    subscriberService.addMessage(message);
  }

}
