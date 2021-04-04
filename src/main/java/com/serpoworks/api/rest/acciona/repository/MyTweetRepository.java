package com.serpoworks.api.rest.acciona.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.serpoworks.api.rest.acciona.model.MyTweet;

public interface MyTweetRepository extends JpaRepository <MyTweet, String>{

    @Query("from MyTweet t where t.username= ?1 and t.isValidated=true") 
	List<MyTweet> readValidatedTweets(String username);
    
    @Query("select t.hashTags from MyTweet t where t.hashTags <> ''")
	List<String> findAllHashtags();
	


}
