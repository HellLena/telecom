package com.example.telecom.subscriber.model.mapper;

import com.example.telecom.subscriber.model.Message;
import com.example.telecom.subscriber.model.Purchase;
import com.example.telecom.subscriber.model.Subscription;

import org.mapstruct.Mapper;

@Mapper
public interface MessageMapper {

  Purchase messageToPurchase(Message message);
  Subscription messageToSubscription(Message message);

}
