package com.example.telecom.publisher.service;

import com.example.telecom.publisher.model.Message;
import com.example.telecom.publisher.model.enumeration.ActionType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.util.concurrent.ThreadLocalRandom;

import javax.annotation.PostConstruct;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PublisherService {

  @Value("${subscriber.url}")
  private String subscriberUrl;

  @PostConstruct
  public void run() throws InterruptedException {
    log.info("Publisher Service started. Subscriber url: {}", subscriberUrl);

    ObjectMapper objectMapper = new ObjectMapper();
    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    while (true) {
      ActionType[] actionTypeValues = ActionType.values();
      Message message = new Message(
        ThreadLocalRandom.current().nextLong(1, Long.MAX_VALUE),
        actionTypeValues[ThreadLocalRandom.current().nextInt(actionTypeValues.length)],
        Instant.now().toEpochMilli()
      );

      try {
        HttpEntity<String> request = new HttpEntity<>(objectMapper.writeValueAsString(message), headers);
        restTemplate.postForObject(subscriberUrl, request, String.class);
        log.info("Sent message: {}", message);
      } catch (JsonProcessingException | RestClientException e) {
        log.error("Error while processing message: {}, error: {}", message, e.getMessage());
      }

      Thread.sleep(5000);

    }
  }

}
