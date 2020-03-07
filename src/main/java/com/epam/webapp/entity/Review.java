package com.epam.webapp.entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class Review implements Identifiable {
    public static final String REVIEW_TABLE_NAME = "review";
    public static final String ID_COLUMN_NAME = "id";
    public static final String USER_ID_COLUMN_NAME = "user_id";
    public static final String REVIEW_MESSAGE_COLUMN_NAME = "review_msg";
    public static final String DATE_COLUMN_NAME = "date";

    private Long id;
    private Long userId;
    private String reviewMessage;
    private LocalDateTime date;

    public Review(Long id, Long userId, String reviewMessage, LocalDateTime date) {
        this.id = id;
        this.userId = userId;
        this.reviewMessage = reviewMessage;
        this.date = date;
    }

    public Review(Long userId, String reviewMsg, LocalDateTime date) {
        this.userId = userId;
        this.reviewMessage = reviewMsg;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getReviewMessage() {
        return reviewMessage;
    }

    public void setReviewMessage(String reviewMessage) {
        this.reviewMessage = reviewMessage;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return Objects.equals(id, review.id) &&
                Objects.equals(userId, review.userId) &&
                Objects.equals(reviewMessage, review.reviewMessage) &&
                Objects.equals(date, review.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, reviewMessage, date);
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", userId=" + userId +
                ", reviewMessage='" + reviewMessage + '\'' +
                ", date=" + date +
                '}';
    }
}
