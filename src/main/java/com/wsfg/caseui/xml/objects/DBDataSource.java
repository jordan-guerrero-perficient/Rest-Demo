package com.wsfg.caseui.xml.objects;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "DBDataSource")
public class DBDataSource {
    @XmlElement(name = "UserName")
    private String userName;
    @XmlElement(name = "Password")
    private String password;
    @XmlElement(name = "DbDetails")
    private String dbDetails;
    @XmlElement(name = "SQL")
    private String sql;

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getDbDetails() {
        return dbDetails;
    }

    public String getSql() {
        return sql;
    }

    @Override
    public String toString(){
        return "DBDataSource = ["+userName+ ", " +password + ", " + dbDetails + ", " + sql + "]";
    }
}
