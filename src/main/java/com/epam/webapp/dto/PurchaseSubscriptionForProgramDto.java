package com.epam.webapp.dto;

import com.epam.webapp.entity.Identifiable;
import com.epam.webapp.entity.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class PurchaseSubscriptionForProgramDto implements Identifiable {
    private Long userId;
    private LocalDateTime paidDate;
    private BigDecimal amount;
    private OrderStatus orderStatus;
    private Long subscriptionId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public PurchaseSubscriptionForProgramDto(Long userId, LocalDateTime paidDate, BigDecimal amount, OrderStatus orderStatus, Long subscriptionId, LocalDateTime startDate, LocalDateTime endDate) {
        this.userId = userId;
        this.paidDate = paidDate;
        this.amount = amount;
        this.orderStatus = orderStatus;
        this.subscriptionId = subscriptionId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(LocalDateTime paidDate) {
        this.paidDate = paidDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Long getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(Long subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseSubscriptionForProgramDto that = (PurchaseSubscriptionForProgramDto) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(paidDate, that.paidDate) &&
                Objects.equals(amount, that.amount) &&
                orderStatus == that.orderStatus &&
                Objects.equals(subscriptionId, that.subscriptionId) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, paidDate, amount, orderStatus, subscriptionId, startDate, endDate);
    }

    @Override
    public String toString() {
        return "PurchaseSubscriptionForProgramDto{" +
                "userId=" + userId +
                ", paidDate=" + paidDate +
                ", amount=" + amount +
                ", orderStatus=" + orderStatus +
                ", subscriptionId=" + subscriptionId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
