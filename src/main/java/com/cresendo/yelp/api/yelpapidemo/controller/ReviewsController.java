package com.cresendo.yelp.api.yelpapidemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cresendo.yelp.api.yelpapidemo.model.Review;
import com.cresendo.yelp.api.yelpapidemo.model.UserReview;
import com.cresendo.yelp.api.yelpapidemo.service.ReviewService;

@RestController
@RequestMapping("/custom-yelp")
public class ReviewsController {
	
	@Autowired
	ReviewService reviewService;
	
	@RequestMapping(value = "/reviews/{id}", produces = {"application/json"}, method = RequestMethod.GET)
	public ResponseEntity<List<UserReview>> getReviewsById(@PathVariable String id) {
		try {
			Review review = reviewService.getReviewsById(id);
            return ResponseEntity.status(HttpStatus.OK).body(review.getReviews());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.valueOf(e.getLocalizedMessage()), e.getMessage(), e);
        }
		
	}
	
}
