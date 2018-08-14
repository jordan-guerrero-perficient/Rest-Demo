package com.jordan.guerrero.restdemo.pojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="templates")
@XmlAccessorType(XmlAccessType.FIELD)
public class TemplateMap {


    private Map<Integer, Template> templateMap = new HashMap<Integer, Template>();

    public Map<Integer, Template> getTemplateMap() {
        return templateMap;
    }
    public void setTemplateMap(Map<Integer, Template> templateMap) {
        this.templateMap = templateMap;
    }
}