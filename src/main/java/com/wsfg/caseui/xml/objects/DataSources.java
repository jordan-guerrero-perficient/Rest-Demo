package com.wsfg.caseui.xml.objects;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "dataSources")
public class DataSources {

    @XmlElement(name = "dataSource", type = DataSource.class)
    private List<DataSource> dataSourceList;

    public List<DataSource> getDataSourceList() {
        return dataSourceList;
    }

    public String toString() {
        return "DataSource [dataSource = " + dataSourceList + "]";
    }
}
