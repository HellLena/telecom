package com.example.telecom.subscriber.model;

import com.example.telecom.subscriber.model.enumeration.ActionType;

import java.time.Instant;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
public class Subscription {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotNull
  private Long msisdn;
  @NotNull
  @Enumerated(EnumType.STRING)
  private ActionType action;
  @NotNull
  private LocalDateTime timestamp;

}
