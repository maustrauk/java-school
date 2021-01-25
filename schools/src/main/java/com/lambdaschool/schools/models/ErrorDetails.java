package com.lambdaschool.schools.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class ErrorDetails {
    private String title;
    private int status;
    private String detail;
    private Date timestamp;
    private String devMessage;
    private List<ValidationError> errors = new ArrayList<>();


    public ErrorDetails() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getDevMessage() {
        return devMessage;
    }

    public void setDevMessage(String devMessage) {
        this.devMessage = devMessage;
    }

    public List<ValidationError> getErrors() {
        return errors;
    }

    public void setErrors(List<ValidationError> error) {
        this.errors = error;
    }
}
