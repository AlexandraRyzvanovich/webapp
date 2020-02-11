package com.epam.webapp.entity;

public enum ProgramStatus {
    NEW("NEW"), IN_PROGRESS("IN PROGRESS"), DONE("DONE"), DECLINED("DECLINED");

    private String statusValue;

    ProgramStatus(String statusValue) {
        this.statusValue = statusValue;
    }
    public String getName() {
        return this.statusValue;
    }

    public static ProgramStatus getFromValue(String value) {
        ProgramStatus resp = null;
        ProgramStatus[] nodes = values();
        for (ProgramStatus node : nodes) {
            if (node.statusValue.equals(value)) {
                resp = node;
                break;
            }
        }
        return resp;
    }
}
