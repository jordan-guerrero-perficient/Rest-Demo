package com.wsfg.caseui.xml.objects;

import org.springframework.beans.factory.annotation.Value;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;

@XmlRootElement(name = "xmlConfig")
public class XmlConfig {

    @XmlElement(name = "templates", type = Templates.class)
    private Templates templates;
    @XmlElement(name = "dataSources", type = DataSources.class)
    private DataSources dataSources;

    public Templates getTemplates() {
        return templates;
    }

    public DataSources getDataSources() {
        return dataSources;
    }
}
