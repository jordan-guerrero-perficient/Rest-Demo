package com.jordan.guerrero.restdemo.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "field")
public class Field
{
    @XmlAttribute(name = "id")
    private String id;

    @XmlAttribute(name = "dataType")
    private String dataType;

    @XmlAttribute(name = "dataSource")
    private String dataSource;


    public String getId(){
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getDataType ()
    {
        return dataType;
    }

    public void setDataType (String dataType)
    {
        this.dataType = dataType;
    }


    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }


    public String getFieldData(String dataSource, String id){
        String fieldValue = "";

        if(id.equals("first-name"))
            fieldValue = "John";

        if(id.equals("last-name"))
            fieldValue = "Smith";

        else if(id.equals("ssn"))
            fieldValue = "111111111";

        return fieldValue;
    }


    @Override
    public String toString()
    {
        return "ClassPojo [ type = "+dataType;
    }

}