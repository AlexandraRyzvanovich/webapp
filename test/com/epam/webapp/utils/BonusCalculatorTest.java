package com.epam.webapp.utils;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class BonusCalculatorTest {
    private BonusCalculator bonusCalculator;

    @BeforeClass
    public void setUp() {
        bonusCalculator = new BonusCalculator();
    }

    @DataProvider
    public Object[][] validDataForBonusCalculator() {
        return new Object[][]{
                {50, BigDecimal.valueOf(100), BigDecimal.valueOf(50)},
                {10, BigDecimal.valueOf(200), BigDecimal.valueOf(180)},
                {null, BigDecimal.valueOf(100), BigDecimal.valueOf(100)},
        };
    }

    @Test(dataProvider = "validDataForBonusCalculator")
    public void calculateSubscriptionPriceUseValidDataTest(Integer bonus, BigDecimal price, BigDecimal finalPrice) {
        BigDecimal finalActualPrice = bonusCalculator.calculateSubscriptionPrice(bonus, price);
        Assert.assertEquals(finalActualPrice, finalPrice);
    }
}
