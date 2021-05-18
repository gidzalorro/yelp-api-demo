package com.cresendo.yelp.api.yelpapidemo.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cresendo.yelp.api.yelpapidemo.model.Review;
import com.cresendo.yelp.api.yelpapidemo.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService{

	@Autowired
    private RestTemplate restTemplate;
	
	@Value("${yelpapi.base.url}")
	private String baseUrl;
	
	@Value("${yelpapi.reviews.path}")
	private String reviewPath;
	
	@Value("${yelpapi.auth.key}")
	private String authKey;
	
	@Value("${headers.key.auth}")
	private String authorization;
	

	@Override
	public Review getReviewsById(String id) {
		
		String reviewsUrl = baseUrl+reviewPath;
				
		HttpHeaders headers = new HttpHeaders();
	    headers.set(authorization, "Bearer "+authKey);
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    
	    HttpEntity<String> requestHeaders = new HttpEntity<String>(headers);
	    Map<String, String> params = new HashMap<String, String>();
	    params.put("id", id);
	    
	    ResponseEntity<Review> reviewEntity = restTemplate.exchange(reviewsUrl, HttpMethod.GET, requestHeaders, Review.class, params);

		return reviewEntity.getBody();
	}

}
