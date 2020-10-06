package com.codeup.blog.models;
public class Ad{
    String title;
    String description;

    public Ad(){
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Ad(String title, String description) {
        this.title = title;
        this.description = description;
    }
}