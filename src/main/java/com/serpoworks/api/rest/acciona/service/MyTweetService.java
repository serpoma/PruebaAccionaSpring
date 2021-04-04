package com.serpoworks.api.rest.acciona.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serpoworks.api.rest.acciona.MyTwitterPropertiesConfig;
import com.serpoworks.api.rest.acciona.model.MyTweet;
import com.serpoworks.api.rest.acciona.repository.MyTweetRepository;

import twitter4j.HashtagEntity;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

@Service
public class MyTweetService {
	
	@Autowired
	MyTweetRepository myTweetRepository;
	
	@Autowired
	MyTwitterPropertiesConfig myTwitterConfig;
	
	public MyTweet save (MyTweet tweet) {
		return this.myTweetRepository.saveAndFlush(tweet);
	}
	
	public List<MyTweet> readTweets(){
		return myTweetRepository.findAll();		
	}
	
	public MyTweet validateTweet(String tweetId) {
		
		Optional<MyTweet> t = myTweetRepository.findById(tweetId);
		
		if (t.isPresent()) {
			MyTweet tt = t.get();
			tt.setValidated(true);
			
			return this.myTweetRepository.saveAndFlush(tt);
		}
		else {
			return new MyTweet();
		}		
		
	}
	
	public List<MyTweet> readValidatedTweet(String username) {
		
		return myTweetRepository.readValidatedTweets(username);
		
	}

		
	public List<MyTweet> collectTweets() {
		
		List<MyTweet> tweets = new ArrayList<MyTweet>();
		
		Twitter twitter = TwitterFactory.getSingleton();
		List<Status> statuses = null;
		try {
			statuses = twitter.getHomeTimeline();
		} catch (TwitterException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Showing home timeline.");
		for (Status status : statuses) {
			
				if (status.getUser().getFollowersCount() > myTwitterConfig.getNumMinFollowers()
						&& myTwitterConfig.getListLocationPermitted().contains(status.getLang())) {
					
					MyTweet t = new MyTweet();
					
					t.setId(Long.toString(status.getId()));
					t.setUsername(status.getUser().getScreenName());
					t.setText(status.getText());
					t.setLang(status.getLang());
					t.setHashTags(this.extractHashtags(status));
					
					if (this.myTweetRepository.saveAndFlush(t) != null) {
						tweets.add(t);
					}
																	
				}
			
				
				
		 }
		
		return tweets;
	}

	public Map<String, Integer> findTopHashtags() {		
		
	   List<String> output = new ArrayList<String>();
		
	   List<String> listHashTags =  this.myTweetRepository.findAllHashtags();
	   	   
	   for (String e : listHashTags) {
		   
		   List<String> myList = new ArrayList<String>(Arrays.asList(e.split(",")));
		   
		   for (String ee: myList) {
			   output.add(ee);
		   }		   
	   }
	   	   
	   return countFrequencies(output);	 
					   
	}
	
	
	//METODOS PRIVADOS
	
	private String extractHashtags(Status status) {
		
		String output="";
		
		HashtagEntity[] hashtagEntities = status.getHashtagEntities();
		  
		if (hashtagEntities != null && hashtagEntities.length > 0) {
		    StringBuilder s = new StringBuilder();
		    s.append(hashtagEntities[0].getText());
		    
		    for (int i = 1; i < hashtagEntities.length; i++) {
		      s.append(",");
		      s.append(hashtagEntities[i].getText());
		    }
		    
		    output = s.toString();
		    
		  }
		
		return output;

	}
	
	 private static Map<String,Integer> countFrequencies(List<String> list)
	    {
	        // hashmap to store the frequency of element
	        Map<String, Integer> hm = new HashMap<String, Integer>();
	  
	        for (String i : list) {
	            Integer j = hm.get(i);
	            hm.put(i, (j == null) ? 1 : j + 1);
	        }
	        
	        
	        //LinkedHashMap preserve the ordering of elements in which they are inserted
	        LinkedHashMap<String, Integer> reverseSortedMap = new LinkedHashMap<>();
	         
	        //Use Comparator.reverseOrder() for reverse ordering
	        hm.entrySet()
	            .stream()
	            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) 
	            .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));
	         
	        System.out.println("Reverse Sorted Map   : " + reverseSortedMap);
	        
	        return reverseSortedMap;

	    }



	

}
