package com.epam.webapp.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class Subscription implements Identifiable {
    public static final String SUBSCRIPTION_TABLE_NAME = "subscription";
    public static final String SUBSCRIPTION_ID_COLUMN_NAME = "id";
    public static final String NAME_COLUMN_NAME = "name";
    public static final String PERIOD_COLUMN_NAME = "period_valid";
    public static final String PRICE_COLUMN_NAME = "price";

    private Long id;
    private String name;
    private Integer period;
    private BigDecimal price;

    public Subscription(long id, String name, Integer period, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.period = period;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscription that = (Subscription) o;
        return id.equals(that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(period, that.period) &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, period, price);
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", period=" + period +
                ", price=" + price +
                '}';
    }
}
