package com.stackroute.dataingestionservice.controller;



import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.dataingestionservice.model.User;
@RestController
@RequestMapping("/api")
public class ListeningController {

    private final WebClient webClient;

    private final ObjectMapper objectMapper;

    public ListeningController() {
        this.webClient = WebClient.create();
        this.objectMapper = new ObjectMapper();
    }
    @GetMapping("/listen")
    public void startStreaming() {
        webClient.get()
                .uri("http://localhost:8080/api/stream")
                .accept(MediaType.APPLICATION_STREAM_JSON)
                .retrieve()
                .bodyToFlux(User.class)
                .doOnNext(this::processUser)
                .blockLast();
    }

    private void processUser(User user) {
        try {
            String json = objectMapper.writeValueAsString(user);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}