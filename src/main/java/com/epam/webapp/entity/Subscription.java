package com.epam.webapp.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class Subscription {
    private long id;
    private long userId;
    private Date paidDate;
    private Date validTo;
    private BigDecimal amount;
    private SubscriptionStatus status;

    public Subscription(long id, long userId, Date paidDate, Date validTo, BigDecimal amount, SubscriptionStatus status) {
        this.id = id;
        this.userId = userId;
        this.paidDate = paidDate;
        this.validTo = validTo;
        this.amount = amount;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Date getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(Date paidDate) {
        this.paidDate = paidDate;
    }

    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public SubscriptionStatus getStatus() {
        return status;
    }

    public void setStatus(SubscriptionStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscription that = (Subscription) o;
        return id == that.id &&
                userId == that.userId &&
                Objects.equals(paidDate, that.paidDate) &&
                Objects.equals(validTo, that.validTo) &&
                Objects.equals(amount, that.amount) &&
                status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, paidDate, validTo, amount, status);
    }
}
