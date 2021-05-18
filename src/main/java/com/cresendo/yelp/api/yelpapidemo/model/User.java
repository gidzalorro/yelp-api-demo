package com.cresendo.yelp.api.yelpapidemo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
	
	@JsonProperty("profile_url")
	private String profileUrl;
	
	@JsonProperty("image_url")
	private String imageUrl;
	
	private String name;
	
	public User(){
	}
	
	public User(final String profileUrl, final String imageUrl, final String name) {
		this.profileUrl = profileUrl;
		this.imageUrl = imageUrl;
		this.name = name;
	}
	
	@JsonProperty("profile_url")
	public String getProfileUrl() {
		return profileUrl;
	}

	@JsonProperty("image_url")
	public String getImageUrl() {
		return imageUrl;
	}

	public String getName() {
		return name;
	}
	
}
