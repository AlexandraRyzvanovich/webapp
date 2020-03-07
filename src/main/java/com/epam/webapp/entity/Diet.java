package com.epam.webapp.entity;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum Diet {
    VEGAN_DIET("VEGAN", "Вегетарианская"), LOW_CARBONATE_DIET("LOW CARB", "Низкоуглеводная"),
    ULTRA_LOW_FAT_DIET("ULTRA LOW FAT", "Ультанизкоуглеводная"), HCG_DIET("HCG", "Низкоколорийная");

    private String dietNameEn;
    private String dietNameRu;
    public static final Map<String, Diet> DIET_MAP_EN;
    public static final Map<String, Diet> DIET_MAP_RU;


    Diet(String dietNameEn, String dietNameRu) {
        this.dietNameEn = dietNameEn;
        this.dietNameRu = dietNameRu;
    }

    public String getDietNameEn() {
        return this.dietNameEn;
    }
    public String getDietNameRu() {
        return this.dietNameRu;
    }

    static {
        Map<String, Diet> map = new HashMap<>();
        for (Diet instance : Diet.values()) {
            map.put(instance.getDietNameEn(), instance);
        }
        DIET_MAP_EN = Collections.unmodifiableMap(map);
    }

    static {
        Map<String, Diet> map = new HashMap<>();
        for (Diet instance : Diet.values()) {
            map.put(instance.getDietNameRu(), instance);
        }
        DIET_MAP_RU = Collections.unmodifiableMap(map);
    }

    public static Diet getValue (String name) {
        return DIET_MAP_EN.get(name) != null ? DIET_MAP_EN.get(name) : DIET_MAP_RU.get(name);
    }
}
