package com.dipanshu.news_api;

public class Source {

    private String id,name;

    public Source(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
