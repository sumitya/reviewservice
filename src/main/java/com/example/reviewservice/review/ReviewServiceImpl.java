package com.example.reviewservice.review;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService{

    private ReviewRepo repo;

    public ReviewServiceImpl(ReviewRepo repo) {
        this.repo = repo;
    }

    @Override
    public Review getReview( Long reviewId) {
        return repo.findById(reviewId).orElse(null);
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews = repo.findByCompanyId(companyId);
        return  reviews;
    }

    @Override
    public void addReview(Long companyId, Review review) {
        if(companyId != 0L && review != null) {
            review.setCompanyId(companyId);
            repo.save(review);
        }
    }
}
