package com.jordan.guerrero.restdemo;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jordan.guerrero.restdemo.pojo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

@RestController
public class DataController {

//    private String searchUrl;
//
//    private String searchID;
//
//    private String searchKey;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public Templates createTemplateData(String path) throws JAXBException {
        try {

            File file = new File(path);
            JAXBContext jaxbContext = JAXBContext.newInstance(Templates.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Templates templateList = (Templates) jaxbUnmarshaller.unmarshal(file);
            return templateList;

        } catch (JAXBException e) {
            e.printStackTrace();
            throw new JAXBException("Error failed to Marshall XML");
        }
    }

    @CrossOrigin
    @RequestMapping("/loadData")
    public Map<String, String> items(@RequestParam(value="id") String templateId, @Value("${xmlPath}") String path) throws Exception {
//        this.searchID = searchID;
//        this.searchKey = searchKey;
//        this.searchUrl = searchUrl;
//
//        logger.info(searchUrl);
//        logger.info(searchID);
//        logger.info(searchKey);
        Templates templateList = createTemplateData(path);

        Template template = templateList.getTemplateById(templateId);

        Map<String, String> fieldData = new HashMap<String, String>();
        for(Field field : template.getField()){
            fieldData.put(field.getId(), field.getFieldData(field.getDataSource(), field.getId()));
        }

        return  fieldData;
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
