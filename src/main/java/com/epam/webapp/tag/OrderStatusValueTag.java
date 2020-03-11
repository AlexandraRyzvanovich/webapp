package com.epam.webapp.tag;

import com.epam.webapp.entity.OrderStatus;

import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class OrderStatusValueTag extends TagSupport {
    private OrderStatus orderStatus;

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public int doStartTag() {
        Object sessionLocale = pageContext.getSession().getAttribute("language");
        Set<Map.Entry<String, OrderStatus>> entrySet;
        if (sessionLocale.equals("ru")) {
            entrySet = OrderStatus.ORDER_STATUS_MAP_RU.entrySet();
        } else {
            entrySet =  OrderStatus.ORDER_STATUS_MAP_EN.entrySet();
        }
        Optional<String> result = entrySet
                .stream()
                .filter(entry -> orderStatus.equals(entry.getValue()))
                .map(Map.Entry::getKey)
                .findFirst();

        if (result.isPresent()) {
            try {
                pageContext.getOut().write(result.get());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return SKIP_BODY;
    }
}
