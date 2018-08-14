package com.jordan.guerrero.restdemo.pojo;

import javax.annotation.PostConstruct;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@XmlRootElement(name = "templates")
public class Templates
{
    @XmlElement(name="template", type = Template.class)
    private List<Template> template;

    public List<Template> getTemplate ()
    {
        return template;
    }

    public void setTemplate ()
    {
        this.template = template;
    }

    @PostConstruct
    public Template getTemplateById(String id){
        for (Template template : this.getTemplate()) {
            if (template.getId().equals(id)){
                return template;
            }
        }
        return null;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [template = "+template+"]";
    }
}
