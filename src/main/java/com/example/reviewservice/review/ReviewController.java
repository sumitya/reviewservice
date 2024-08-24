package com.example.reviewservice.review;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }


    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews(@RequestParam Long companyId) {
        List<Review> review = reviewService.getAllReviews(companyId);
        if(review != null) return ResponseEntity.ok(review);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long reviewId) {
        return new ResponseEntity<>(reviewService.getReview(reviewId),HttpStatus.OK);

    }

    @PostMapping
    public  ResponseEntity<String> addReview(@RequestParam Long companyId,
                                             @RequestBody Review review) {
       reviewService.addReview(companyId,review);
       return new ResponseEntity<>("Review Added ",HttpStatus.OK);
    }
}
