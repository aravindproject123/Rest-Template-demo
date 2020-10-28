package com.example.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PostController
{
	@RequestMapping(value="/")
	public String getAll() 
	{
		RestTemplate restTemplate=new RestTemplate();
		HttpHeaders headers=new HttpHeaders();

		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity=new HttpEntity<>(headers);
		
		return restTemplate.exchange("https://jsonplaceholder.typicode.com/posts", HttpMethod.GET,entity,String.class).getBody();	
	}
	
	@RequestMapping(value="/{id}")
	public String getById(@PathVariable("id") String id )
	{
		RestTemplate restTemplate=new RestTemplate();
		HttpHeaders headers=new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity=new HttpEntity<String>(headers);
		return restTemplate.exchange("https://jsonplaceholder.typicode.com/posts/"+id, HttpMethod.GET,entity,String.class).getBody();
		
		
	}
	
	
}
