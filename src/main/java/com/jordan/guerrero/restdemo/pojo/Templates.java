package com.jordan.guerrero.restdemo.pojo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Data
{
    private List<Template> template;

    public List<Template> getTemplate ()
    {
        return template;
    }

    public void setTemplate ()
    {
        this.template = template;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [template = "+template+"]";
    }
}
