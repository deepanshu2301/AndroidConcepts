package com.dipanshu.solarsystem;

public class data {

    private String title,intro,url;

    public data(String name,String intro,String url){
        this.title=name;
        this.intro=intro;
        this.url=url;
    }



    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getName() {
        return title;
    }

    public void setName(String name) {
        this.title = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
