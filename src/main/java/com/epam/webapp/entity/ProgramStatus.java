package com.epam.webapp.entity;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum ProgramStatus {
    NEW("NEW", "Новая"), IN_PROGRESS("IN PROGRESS", "В процессе"), DONE("DONE", "Сделано"), DECLINED("DECLINED", "Отменено");

    private String programStatusNameEn;
    private String programStatusNameRu;
    public static final Map<String, ProgramStatus> PROGRAM_STATUS_MAP_EN;
    public static final Map<String, ProgramStatus> PROGRAM_STATUS_MAP_RU;

    ProgramStatus(String programStatusNameEn, String programStatusNameRu) {
        this.programStatusNameEn = programStatusNameEn;
        this.programStatusNameRu = programStatusNameRu;
    }

    private String getProgramStatusNameEn() {
        return this.programStatusNameEn;
    }
    private String getProgramStatusNameRu() {
        return this.programStatusNameRu;
    }

    static {
        Map<String, ProgramStatus> map = new HashMap<>();
        for (ProgramStatus instance : ProgramStatus.values()) {
            map.put(instance.getProgramStatusNameEn(), instance);
        }
        PROGRAM_STATUS_MAP_EN = Collections.unmodifiableMap(map);
    }
    static {
        Map<String, ProgramStatus> map = new HashMap<>();
        for (ProgramStatus instance : ProgramStatus.values()) {
            map.put(instance.getProgramStatusNameRu(), instance);
        }
        PROGRAM_STATUS_MAP_RU = Collections.unmodifiableMap(map);
    }

    public static ProgramStatus getValue (String name) {
        return PROGRAM_STATUS_MAP_EN.get(name) != null ? PROGRAM_STATUS_MAP_EN.get(name) : PROGRAM_STATUS_MAP_RU.get(name);
    }
}
