package com.example.todoapplication.model;

public class Task {
    private String task;
    private String description;
    private long date_created;

    public Task() {
    }

    public Task(String task, String description, long date_created) {
        this.task = task;
        this.description = description;
        this.date_created = date_created;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getDate_created() {
        return date_created;
    }

    public void setDate_created(long date_created) {
        this.date_created = date_created;
    }
}
