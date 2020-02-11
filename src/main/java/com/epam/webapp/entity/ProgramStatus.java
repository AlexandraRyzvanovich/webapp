package com.epam.webapp.entity;

public enum ProgramStatus {
    NEW("New"), IN_PROGRESS("In progress"), DONE("Done"), DECLINED("Declined");

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
