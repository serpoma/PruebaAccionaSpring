package com.serpoworks.api.rest.acciona;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "twitter.property")
public class MyTwitterPropertiesConfig {
	
	// No se recogeran Tweets que no tengan al menos 1500 followers.
	private Integer numMinFollowers = 1500;
	
	// Solo se recogeran Tweets de estos idiomas
	private List<String> listLocationPermitted =  Arrays.asList("es", "fr", "it");
	
	//Numero máximo HashTags mas usados.
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
