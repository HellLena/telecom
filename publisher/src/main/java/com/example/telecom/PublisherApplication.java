package com.example.telecom;

import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class PublisherApplication {

  public static void main(String[] args) {
    new SpringApplicationBuilder()
        .sources(PublisherApplication.class)
        .bannerMode(Banner.Mode.OFF)
        .web(WebApplicationType.NONE)
        .run(args);
  }

}
