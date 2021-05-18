package com.cresendo.yelp.api.yelpapidemo.model;

import java.util.List;

public class Review {
	
	private List<UserReview> reviews;
	
	public Review(){
	}

	public Review(final List<UserReview> reviews) {
		this.reviews = reviews;
	}

	public List<UserReview> getReviews() {
		return reviews;
	}

}
