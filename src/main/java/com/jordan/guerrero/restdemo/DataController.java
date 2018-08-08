package com.jordan.guerrero.restdemo;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DataController {

    private String searchUrl;

    private String searchID;

    private String searchKey;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/sports")
    public List<Items> items(@RequestParam(value="query",
                            defaultValue = "New York") String search,
                             @Value("${customUrl}") String searchUrl,
                             @Value("${customID}") String searchID,
                             @Value("${customKey}") String searchKey) throws Exception {

        this.searchID = searchID;
        this.searchKey = searchKey;
        this.searchUrl = searchUrl;

        logger.info(searchUrl);
        logger.info(searchID);
        logger.info(searchKey);

        RestTemplateBuilder builder = new RestTemplateBuilder();
        RestTemplate restTemplate = builder.build();

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = restTemplate.getForObject(searchUrl +
                        "?key=" + searchKey +
                        "&cx=" + searchID +
                        "&q=" + search + "&safe=medium",
                String.class);

        Wrapper itemsList = mapper.readValue(jsonString, new TypeReference<Wrapper>() {
        });

        return itemsList.items;
    }
}
