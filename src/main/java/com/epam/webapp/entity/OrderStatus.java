package com.epam.webapp.entity;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum OrderStatus {
    PROCESSED("Processed", "Обработана"), DECLINED("Declined", "Отменена");

    private String orderStatusEn;
    private String orderStatusRu;
    public static final Map<String, OrderStatus> ORDER_STATUS_MAP_EN;
    public static final Map<String, OrderStatus> ORDER_STATUS_MAP_RU;
    OrderStatus(String orderStatusEn, String orderStatusRu) {
        this.orderStatusEn = orderStatusEn;
        this.orderStatusRu = orderStatusRu;
    }
    private String getOrderStatusNameEn() {
        return this.orderStatusEn;
    }
    private String getOrderStatusNameRu() {
        return this.orderStatusRu;
    }

    static {
        Map<String, OrderStatus> map = new HashMap<>();
        for (OrderStatus instance : OrderStatus.values()) {
            map.put(instance.getOrderStatusNameEn(), instance);
        }
        ORDER_STATUS_MAP_EN = Collections.unmodifiableMap(map);
    }
    static {
        Map<String, OrderStatus> map = new HashMap<>();
        for (OrderStatus instance : OrderStatus.values()) {
            map.put(instance.getOrderStatusNameRu(), instance);
        }
        ORDER_STATUS_MAP_RU = Collections.unmodifiableMap(map);
    }
}
