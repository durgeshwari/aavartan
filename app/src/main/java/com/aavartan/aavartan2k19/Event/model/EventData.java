package com.aavartan.aavartan2k19.Event.model;

import java.util.List;

public class EventData {

    private boolean success;
    private String message;
    private List<Model> eventList;

    public EventData(boolean success, String message, List<Model> eventList) {
        this.success = success;
        this.message = message;
        this.eventList = eventList;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public List<Model> getEventList() {
        return eventList;
    }

}
