package com.wsfg.caseui.xml.objects;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "RestDataSource")
public class RestDataSource {

    @XmlElement(name = "UserName")
    private String userName;
    @XmlElement(name = "Password")
    private String password;
    @XmlElement(name = "url")
    private String url;
    @XmlElement(name = "Host")
    private String host;
    @XmlElement(name = "Port")
    private String port;

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getUrl() {
        return url;
    }

    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }

    @Override
    public String toString(){
        return "RestDataSource = ["+userName+ ", " +password + ", " + url + ", " + host + ", " + port +"]";
    }
}
