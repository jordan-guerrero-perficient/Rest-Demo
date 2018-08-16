package com.wsfg.caseui;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Items {

    private String title;
    private String link;

    public Items() {
    }

    public Items(String title, String link) {
        this.title = title;
        this.link = link;
    }

    public String getTitle() {

        return this.title;
    }

    public String getLink() {

        return this.link;
    }

    public void setTitle() {
        this.title = title;
    }

    public void setLink() {

        this.link = link;
    }

    @Override
    public String toString() {
        return "Items{" +
                "title=" + title +
                ", link='" + link + "\'" +
                "}";
    }
}
