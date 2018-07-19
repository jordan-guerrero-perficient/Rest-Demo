package com.jordan.guerrero.restdemo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Wrapper {
    public List<Items> items;

    public Wrapper(){
    }

    public List<Items> getItems(){
        return this.items;
    }

    public void setList(){
        this.items = items;
    }

}
