package com.example.reviewservice.review;

import java.util.List;

public interface ReviewService {
    Review getReview(Long reviewId);
    List<Review> getAllReviews(Long id);
    void addReview(Long companyId, Review review);
}
