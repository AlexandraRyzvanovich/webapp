package com.epam.webapp.entity;

import java.util.Objects;

public class Review {
    public static final String REVIEW_TABLE_NAME = "review";
    public static final String USER_COLUMN_NAME = "user_id";
    public static final String REVIEW_MESSAGE_COLUMN_NAME = "review_msg";

    private long userId;
    private String reviewMessage;

    public Review(long userId, String reviewMessage) {
        this.userId = userId;
        this.reviewMessage = reviewMessage;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getReviewMessage() {
        return reviewMessage;
    }

    public void setReviewMessage(String reviewMessage) {
        this.reviewMessage = reviewMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return userId == review.userId &&
                Objects.equals(reviewMessage, review.reviewMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, reviewMessage);
    }
}
