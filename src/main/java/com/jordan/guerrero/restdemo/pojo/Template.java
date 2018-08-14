package com.jordan.guerrero.restdemo.pojo;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "template")
public class Template
{
    @XmlAttribute(name = "id")
    private String id;

    @XmlElement(name="field", type = Field.class)
    private List<Field> field;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }


    public List<Field> getField ()
    {
        return field;
    }

    public void setField ()
    {
        this.field = field;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", field = "+field+"]";
    }
}