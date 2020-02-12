package com.epam.webapp.entity;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum ProgramStatus {
    NEW("NEW"), IN_PROGRESS("IN PROGRESS"), DONE("DONE"), DECLINED("DECLINED");

    private String statusValue;
    public static final Map<String, ProgramStatus> PROGRAM_STATUS_MAP;

    ProgramStatus(String statusValue) {
        this.statusValue = statusValue;
    }

    public String getName() {
        return this.statusValue;
    }

    static {
        Map<String, ProgramStatus> map = new HashMap<>();
        for (ProgramStatus instance : ProgramStatus.values()) {
            map.put(instance.getName(), instance);
        }
        PROGRAM_STATUS_MAP = Collections.unmodifiableMap(map);
    }
    public static ProgramStatus get (String name) {
        return PROGRAM_STATUS_MAP.get(name);
    }
}
