package com.example.telecom.subscriber.service;

import com.example.telecom.subscriber.model.Message;
import com.example.telecom.subscriber.model.Purchase;
import com.example.telecom.subscriber.model.Subscription;
import com.example.telecom.subscriber.model.enumeration.ActionType;
import com.example.telecom.subscriber.model.mapper.MessageMapper;
import com.example.telecom.subscriber.repository.PurchaseRepository;
import com.example.telecom.subscriber.repository.SubscriptionRepository;

import javassist.NotFoundException;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class SubscriberService {

  private final PurchaseRepository purchaseRepository;
  private final SubscriptionRepository subscriptionRepository;
  private final MessageMapper messageMapper;

  public void addMessage(Message message) throws NotFoundException {
    log.info("Receive message: {}", message);
    ActionType actionType = message.getAction();
    switch (actionType) {
      case PURCHASE:
        Purchase purchase = purchaseRepository.save(messageMapper.messageToPurchase(message));
        log.info("Saved purchase with id: {}", purchase.getId());
        break;
      case SUBSCRIPTION:
        Subscription subscription = subscriptionRepository.save(messageMapper.messageToSubscription(message));
        log.info("Saved subscription with id: {}", subscription.getId());
        break;
      default:
        log.error("Action {} not found.", actionType.name());
        throw new NotFoundException(String.format("Action %s not found.", actionType.name()));
    }
  }

}
