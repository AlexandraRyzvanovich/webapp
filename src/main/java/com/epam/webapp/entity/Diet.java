package com.epam.webapp.entity;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum Diet {
    VEGAN_DIET("VEGAN"), LOW_CARBONATE_DIET("LOW CARB"),
    ULTRA_LOW_FAT_DIET("ULTRA LOW FAT"), HCG_DIET("HCG");

    private String dietName;
    public static final Map<String, Diet> DIET_MAP;

    Diet(String dietName) {
        this.dietName = dietName;
    }

    public String getName() {
        return this.dietName;
    }

    static {
        Map<String, Diet> map = new HashMap<>();
        for (Diet instance : Diet.values()) {
            map.put(instance.getName(),instance);
        }
        DIET_MAP = Collections.unmodifiableMap(map);
    }

    public static Diet getValue (String name) {
        return DIET_MAP.get(name);
    }
}
