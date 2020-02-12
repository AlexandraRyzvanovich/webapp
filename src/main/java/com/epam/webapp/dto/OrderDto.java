package com.epam.webapp.dto;

import com.epam.webapp.entity.Identifiable;
import com.epam.webapp.entity.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class OrderDto implements Identifiable {
    private Long orderId;
    private String SubscriptionName;
    private LocalDateTime paidDate;
    private BigDecimal amount;
    private OrderStatus orderStatus;

    public OrderDto(Long orderId, String subscriptionName, LocalDateTime paidDate, BigDecimal amount, OrderStatus orderStatus) {
        this.orderId = orderId;
        SubscriptionName = subscriptionName;
        this.paidDate = paidDate;
        this.amount = amount;
        this.orderStatus = orderStatus;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getSubscriptionName() {
        return SubscriptionName;
    }

    public void setSubscriptionName(String subscriptionName) {
        SubscriptionName = subscriptionName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDto orderDto = (OrderDto) o;
        return Objects.equals(orderId, orderDto.orderId) &&
                Objects.equals(SubscriptionName, orderDto.SubscriptionName) &&
                Objects.equals(paidDate, orderDto.paidDate) &&
                Objects.equals(amount, orderDto.amount) &&
                orderStatus == orderDto.orderStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, SubscriptionName, paidDate, amount, orderStatus);
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "orderId=" + orderId +
                ", SubscriptionName='" + SubscriptionName + '\'' +
                ", paidDate=" + paidDate +
                ", amount=" + amount +
                ", orderStatus=" + orderStatus +
                '}';
    }
}
