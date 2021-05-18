package com.cresendo.yelp.api.yelpapidemo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserReview {
	
	private User user;
	private String text;
	
	public UserReview(){
	}
	
	public UserReview(final User user, final String text) {
		this.user = user;
		this.text = text;
	}

	public User getUser() {
		return user;
	}

	public String getText() {
		return text;
	}
	
	

}
