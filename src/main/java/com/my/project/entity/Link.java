package com.my.project.entity;

public class Link {
    private String name;
    private String link;

    public Link(String name, String link) {
        this.name = name;
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public String getLink() {
        return link;
    }
}
