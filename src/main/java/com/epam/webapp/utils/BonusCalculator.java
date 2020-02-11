package com.epam.webapp.utils;

import java.math.BigDecimal;

public class BonusCalculator {
    public BigDecimal calculateSubscriptionPrice(Integer bonus, BigDecimal price) {
        if(bonus != null) {
           BigDecimal bonusAmount = price.multiply(BigDecimal.valueOf(bonus));
           bonusAmount = bonusAmount.divide(BigDecimal.valueOf(100));
            return price.subtract(bonusAmount);
        }
        else return price;
    }
}
