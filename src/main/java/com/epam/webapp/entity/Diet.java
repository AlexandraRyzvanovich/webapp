package com.epam.webapp.entity;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum Diet {
    VEGAN_DIET("Vegan"), LOW_CARBONATE_DIET("Low carbonate diet"),
    ULTRA_LOW_FAT_DIET("Ultra low fat diet"), HCG_DIET("HCG diet");

    private String dietName;
    public static final Map<String, Diet> DIET_MAP;

    Diet(String dietName) {
        this.dietName = dietName;
    }

    public String getName() {
        return this.dietName;
    }

    public static Diet getFromValue(String value) {
        Diet dietEnum = null;
        Diet[] names = values();
        for (Diet diet : names) {
            if (diet.dietName.equals(value)) {
                dietEnum = diet;
                break;
            }
        }
        return dietEnum;
    }

    static {
        Map<String, Diet> map = new HashMap<>();
        for (Diet instance : Diet.values()) {
            map.put(instance.getName(),instance);
        }
        DIET_MAP = Collections.unmodifiableMap(map);
    }
    public static Diet get (String name) {
        return DIET_MAP.get(name);
    }
}
