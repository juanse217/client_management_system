package com.client_management.model;

public class ActionHistory {
    private String description;
    private Long timeOfAction;

    public ActionHistory(String description, Long timeOfAction) {
        this.description = description;
        this.timeOfAction = timeOfAction;
    }

    public String getDescription() {
        return description;
    }

    public Long getTimeOfAction() {
        return timeOfAction;
    }
    
}
