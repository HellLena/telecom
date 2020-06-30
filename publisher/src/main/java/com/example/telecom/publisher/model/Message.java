package com.example.telecom.publisher.model;


import com.example.telecom.publisher.model.enumeration.ActionType;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Message {

  private Long msisdn;
  private ActionType action;
  private Long timestamp;

}
