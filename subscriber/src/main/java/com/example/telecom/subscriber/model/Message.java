package com.example.telecom.subscriber.model;

import com.example.telecom.subscriber.model.enumeration.ActionType;
import com.example.telecom.subscriber.util.InstantToLocalDateTimeDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Message {

  @NotNull
  private Long msisdn;
  @NotNull
  private ActionType action;
  @NotNull
  @JsonDeserialize(using = InstantToLocalDateTimeDeserializer.class)
  private LocalDateTime timestamp;

}
