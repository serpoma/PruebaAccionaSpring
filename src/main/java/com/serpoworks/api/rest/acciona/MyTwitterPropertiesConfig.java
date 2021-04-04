package com.serpoworks.api.rest.acciona;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "twitter.property")
public class MyTwitterPropertiesConfig {
	
	private Integer numMinFollowers = 1500;
	private List<String> listLocationPermitted =  Arrays.asList("es", "fr", "it");
	private Integer numHashtagsMoreUsed = 10;	
	
	public Integer getNumMinFollowers() {
		return numMinFollowers;
	}
	public void setNumMinFollowers(Integer numMinFollowers) {
		this.numMinFollowers = numMinFollowers;
	}
	public List<String> getListLocationPermitted() {
		return listLocationPermitted;
	}
	public void setListLocationPermitted(List<String> listLocationPermitted) {
		this.listLocationPermitted = listLocationPermitted;
	}
	public Integer getNumHashtagsMoreUsed() {
		return numHashtagsMoreUsed;
	}
	public void setNumHashtagsMoreUsed(Integer numHashtagsMoreUsed) {
		this.numHashtagsMoreUsed = numHashtagsMoreUsed;
	}
	
	

}
