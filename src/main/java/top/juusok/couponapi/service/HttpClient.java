package top.juusok.couponapi.service;

import org.springframework.http.*;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public interface HttpClient {

	public String work(String url, HttpMethod method, String params);
	
}
