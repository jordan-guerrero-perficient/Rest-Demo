package com.wsfg.caseui;

import com.wsfg.caseui.xml.objects.Field;
import com.wsfg.caseui.xml.objects.Template;
import com.wsfg.caseui.xml.objects.Templates;
import com.wsfg.caseui.xml.objects.XmlConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@RestController
public class DataController {
    @Value("${xmlPath}")
    private String path;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public XmlConfig createXmlConfig() throws JAXBException {
        try {

            File file = new File(path);
            JAXBContext jaxbContext = JAXBContext.newInstance(XmlConfig.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            XmlConfig xmlFile = (XmlConfig) jaxbUnmarshaller.unmarshal(file);
            return xmlFile;

        } catch (JAXBException e) {
            e.printStackTrace();
            throw new JAXBException("Error failed to Marshall XML");
        }
    }

    @CrossOrigin
    @RequestMapping("/loadData")
    public Map<String, String> items(@RequestParam(value = "id") String templateId) throws Exception {
//        this.searchID = searchID;
//        this.searchKey = searchKey;
//        this.searchUrl = searchUrl;
//
//        logger.info(searchUrl);
//        logger.info(searchID);
//        logger.info(searchKey);
        XmlConfig xmlConfig = createXmlConfig();
        logger.info(xmlConfig.getDataSources().getDataSourceList().get(0).getRestDataSource().getHost());
        Template template = xmlConfig.getTemplates().getTemplateById(templateId);

        Map<String, String> fieldData = new HashMap<String, String>();
        for (Field field : template.getField()) {
            fieldData.put(field.getId(), field.getFieldData(field.getDataSource(), field.getId()));
        }

        return fieldData;
//        RestTemplateBuilder builder = new RestTemplateBuilder();
//        RestTemplate restTemplate = builder.build();
//
//        ObjectMapper mapper = new ObjectMapper();
//        String jsonString = restTemplate.getForObject(call,
//                String.class);
//        JsonNode obj = mapper.readTree(jsonString);
//
//        String field = obj.get("items").get(0).get("link").toString();
//
//        logger.info(field);
//        return field;
//        Wrapper itemsList = mapper.readValue(jsonString, new TypeReference<Wrapper>() {
//        });

//        return itemsList.items;
    }
}
