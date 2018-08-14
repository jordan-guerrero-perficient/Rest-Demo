package com.jordan.guerrero.restdemo;

import com.jordan.guerrero.restdemo.Field;

public class Template
{
    private String id;

    private Field[] field;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public Field[] getField ()
    {
        return field;
    }

    public void setField (Field[] field)
    {
        this.field = field;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", field = "+field+"]";
    }
}