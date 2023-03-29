package com.stackroute.dataingestionservice.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.dataingestionservice.service.ListeningService;

@RestController
@RequestMapping("/ingestion")
public class ListeningController {
	private final ListeningService listeningService;

	public ListeningController(ListeningService listeningService) {
		this.listeningService = listeningService;
	}

	@GetMapping("/receiveUserData")
	@CrossOrigin
	public void startStreaming() {
		listeningService.startStreaming();
	}
}
