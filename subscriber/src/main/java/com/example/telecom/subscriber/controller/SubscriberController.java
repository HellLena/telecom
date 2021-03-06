package com.example.telecom.subscriber.controller;

import com.example.telecom.subscriber.model.Message;
import com.example.telecom.subscriber.service.SubscriberService;

import javassist.NotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SubscriberController {

  private final SubscriberService subscriberService;

  @PostMapping
  public ResponseEntity addMessage(@RequestBody Message message) {
    try {
      subscriberService.addMessage(message);
      return new ResponseEntity(HttpStatus.OK);
    } catch (NotFoundException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
