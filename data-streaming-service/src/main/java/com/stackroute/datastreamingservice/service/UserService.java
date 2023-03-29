package com.stackroute.datastreamingservice.service;

import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.datastreamingservice.model.User;

import reactor.core.publisher.Flux;

@Service
public class UserService {
	
	public Flux<User> getUserData() {

			/*
//		 * Below code reads data stored locally in the specified path into a file
//		 * reference variable and maps it into an array of objects of type User defined
//		 * by the User POJO. It is then passed onto flux which streams the object one by
//		 * one.
//		 */

		InputStream userData;
		ObjectMapper objectMapper = new ObjectMapper();
		User[] userArray;
		Flux<User> user = null;
		Logger logger = LoggerFactory.getLogger(UserService.class);
		try {
			logger.info("Attempting to read file..");
			userData = getClass().getResourceAsStream("/data/CustomerData.json");
			logger.info("Attempting to map user data into object array..");
			userArray= objectMapper.readValue(userData, User[].class);
			logger.info("Success - Streaming data..");
			user = Flux.fromArray(userArray);
		} catch (StreamReadException e) {
			logger.error("Error in reading from Stream - StreamReadException occured.");
		} catch (DatabindException e) {
			logger.error("Error in binding - DataBind exception occured.");
		} catch (IOException e) {
			logger.error("Error in IO operations - IO exception occured.");
		} catch (NullPointerException e){
			logger.error("Error - the given pathname is null - NullPointerException occured.");
		}
		return user;
	}
}
