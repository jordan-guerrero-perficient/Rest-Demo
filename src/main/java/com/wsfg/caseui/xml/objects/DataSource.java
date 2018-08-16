package com.wsfg.caseui.xml.objects;


import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "dataSource")
public class DataSource {

    @XmlAttribute(name = "id")
    private String id;

    @XmlAttribute(name = "class")
    private String cls;

    @XmlElement(name = "RestDataSource", type = RestDataSource.class)
    private RestDataSource restDataSource;

    @XmlElement(name = "DBDataSource", type = DBDataSource.class)
    private DBDataSource dbDataSource;

    public String getId() {
        return id;
    }

    public String getCls() {
        return cls;
    }
    public RestDataSource getRestDataSource() {
        return restDataSource;
    }

    public DBDataSource getDbDataSource() {
        return dbDataSource;
    }

    @Override
    public String toString(){
        return "DataSource = ["+id+ ", " +cls +"]";
    }
}
