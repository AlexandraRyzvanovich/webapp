package com.epam.webapp.dto;

import com.epam.webapp.entity.Identifiable;
import com.epam.webapp.entity.OrderStatus;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class PurchaseSubscriptionForProgramDto implements Identifiable {
    public static final String USER_ID_COLUMN_NAME = "user_id";
    public static final String PAID_DATE_COLUMN_NAME = "paid_date";
    public static final String AMOUNT_COLUMN_NAME = "amount";
    public static final String ORDER_STATUS_COLUMN_NAME = "status";
    public static final String SUBSCRIPTION_ID_COLUMN_NAME = "subscription_id";
    public static final String DIET_COLUMN_NAME = "diet";
    public static final String VALID_TO_COLUMN_NAME = "valid_to";
    public static final String PROGRAM_STATUS_COLUMN_NAME = "status";

    private Long userId;
    private Date paidDate;
    private BigDecimal amount;
    private OrderStatus orderStatus;
    private Long subscriptionId;
    private Date startDate;
    private Date endDate;

    public PurchaseSubscriptionForProgramDto(Long userId, Date paidDate, BigDecimal amount, OrderStatus orderStatus, Long subscriptionId, Date startDate, Date endDate) {
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

    public Date getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(Date paidDate) {
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
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
        return "SubscriptionProgramPurchaseDto{" +
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
