package com.jordan.guerrero.restdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.net.URL;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class RestDemoApplication {

	private static final Logger log = LoggerFactory.getLogger(RestDemoApplication.class);

	private static String str = "placeHolder";

	public static void main(String args[]){

		SpringApplication.run(RestDemoApplication.class, args);
		str = args.toString();
	}

	//private String query;
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder){
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		String queryString = str;
		return args ->  {
			ObjectMapper mapper = new ObjectMapper();
			String jsonString = restTemplate.getForObject("https://www.googleapis.com/customsearch/v1?key=AIzaSyCcDmi3nTLcfyAlOWIpVGNmEYGf22HGBo8&cx=018100688330092027261:ln0j8vimdvw&q=" +
							queryString +"&safe=medium",
					String.class);
			Wrapper itemsList = mapper.readValue(jsonString, new TypeReference<Wrapper>(){});

			itemsList.items.forEach(i -> log.info(i.toString()));
		};
	}
}
