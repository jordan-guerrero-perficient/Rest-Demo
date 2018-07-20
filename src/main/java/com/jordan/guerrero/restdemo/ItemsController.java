package com.jordan.guerrero.restdemo;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ItemsController {
//    private final String searchQuery = "";

    @RequestMapping("/search")
    public List<Items> items(@RequestParam(value="query", defaultValue = "New York") String search) throws Exception {

        RestTemplateBuilder builder = new RestTemplateBuilder();
        RestTemplate restTemplate = builder.build();

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = restTemplate.getForObject("https://www.googleapis.com/customsearch/v1?key=AIzaSyCcDmi3nTLcfyAlOWIpVGNmEYGf22HGBo8&cx=018100688330092027261:ln0j8vimdvw&q=" +
                        search + "&safe=medium",
                String.class);
        Wrapper itemsList = mapper.readValue(jsonString, new TypeReference<Wrapper>() {
        });

        return itemsList.items;
    }
}
