package com.serpoworks.api.rest.acciona.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serpoworks.api.rest.acciona.model.MyTweet;
import com.serpoworks.api.rest.acciona.service.MyTweetService;


@RestController
@RequestMapping("/api/v1")
public class MyTweetController {
	
	@Autowired
	MyTweetService myTweetService;
		
	@GetMapping("mytweets/collect")
	public List<MyTweet> collectTweets() {
		return this.myTweetService.collectTweets();
	}
	
	@GetMapping("mytweets/read")
	public List<MyTweet> readTweets() {
		return this.myTweetService.readTweets();
	}
	
	@GetMapping("/mytweets/validate/{tweetId}")
	public MyTweet validateTweet(@PathVariable String tweetId) {			
		return this.myTweetService.validateTweet(tweetId);		
	}
	
	@GetMapping("/mytweets/readValidated/{username}")
	public List<MyTweet> readValidatedTweet(@PathVariable String username) {			
		return this.myTweetService.readValidatedTweet(username);		
	}
	
	@GetMapping("mytweets/findTopHashtags")
	public Map<String, Integer> findTopHashtags(){
		return this.myTweetService.findTopHashtags();
	}
	
	
	


}
