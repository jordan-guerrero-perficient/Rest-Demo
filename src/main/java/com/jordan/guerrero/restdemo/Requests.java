package com.jordan.guerrero.restdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component

public class Requests {


    private String searchUrl;


    private String searchID;


    private String searchKey;


    public Requests(){
    }

    @PostConstruct
    public String getSearchUrl() {
        return searchUrl;
    }

    @PostConstruct
    public String getSearchID() {
        return searchID;
    }

    @PostConstruct
    public String getSearchKey() {
        return searchKey;
    }
}