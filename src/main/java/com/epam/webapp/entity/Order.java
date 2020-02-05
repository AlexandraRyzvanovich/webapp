package com.epam.webapp.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class Order implements Identifiable {
    public static final String ORDER_TABLE_NAME = "order";
    public static final String ID_COLUMN_NAME = "id";
    public static final String USER_ID_COLUMN_NAME = "user_id";
    public static final String PAID_DATE_COLUMN_NAME = "paid_date";
    public static final String AMOUNT_COLUMN_NAME = "amount";
    public static final String STATUS_COLUMN_NAME = "status";
    public static final String SUBSCRIPTION_ID_COLUMN_NAME = "user_id";

    private Long id;
    private Long userId;
    private Date paidDate;
    private BigDecimal amount;
    private OrderStatus orderStatus;
    private Long subscriptionId;

    public Order(Long id, Long userId, Date paidDate, BigDecimal amount, OrderStatus orderStatus, Long subscriptionId) {
        this.id = id;
        this.userId = userId;
        this.paidDate = paidDate;
        this.amount = amount;
        this.orderStatus = orderStatus;
        this.subscriptionId = subscriptionId;
    }

    public Order(Long userId, Date paidDate, BigDecimal amount, OrderStatus orderStatus, Long subscriptionId) {
        this.userId = userId;
        this.paidDate = paidDate;
        this.amount = amount;
        this.orderStatus = orderStatus;
        this.subscriptionId = subscriptionId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) &&
                Objects.equals(userId, order.userId) &&
                Objects.equals(paidDate, order.paidDate) &&
                Objects.equals(amount, order.amount) &&
                orderStatus == order.orderStatus &&
                Objects.equals(subscriptionId, order.subscriptionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, paidDate, amount, orderStatus, subscriptionId);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", paidDate=" + paidDate +
                ", amount=" + amount +
                ", orderStatus=" + orderStatus +
                ", subscriptionId=" + subscriptionId +
                '}';
    }
}
