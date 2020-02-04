package com.epam.webapp.entity;

import java.util.Date;
import java.util.Objects;

public class Review implements Identifiable {
    public static final String REVIEW_TABLE_NAME = "review";
    public static final String ID_COLUMN_NAME = "id";
    public static final String USER_ID_COLUMN_NAME = "user_id";
    public static final String REVIEW_MESSAGE_COLUMN_NAME = "review_msg";
    public static final String STAR_COLUMN_NAME = "star";
    public static final String DATE_COLUMN_NAME = "date";

    private Long id;
    private Long userId;
    private String reviewMessage;
    private Integer star;
    private Date date;

    public Review(Long id, Long userId, String reviewMessage, Integer star, Date date) {
        this.id = id;
        this.userId = userId;
        this.reviewMessage = reviewMessage;
        this.star = star;
        this.date = date;
    }

    public Review(Long userId, String reviewMsg, Integer star, Date date) {
        this.userId = userId;
        this.reviewMessage = reviewMsg;
        this.star = star;
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

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
                Objects.equals(star, review.star) &&
                Objects.equals(date, review.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, reviewMessage, star, date);
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", userId=" + userId +
                ", reviewMessage='" + reviewMessage + '\'' +
                ", star=" + star +
                ", date=" + date +
                '}';
    }
}
