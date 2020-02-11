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
        ProgramStatus nodes[] = values();
        for(int i = 0; i < nodes.length; i++) {
            if(nodes[i].statusValue.equals(value)) {
                resp = nodes[i];
                break;
            }
        }
        return resp;
    }
}
