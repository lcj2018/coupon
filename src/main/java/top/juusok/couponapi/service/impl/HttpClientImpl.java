package top.juusok.couponapi.service.impl;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class HttpClientImpl implements top.juusok.couponapi.service.HttpClient {

	@Override
	public String work(String url, HttpMethod method, String params) {
		
		params = params.replace("$Class", "$class");
		RestTemplate template = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		HttpEntity<String> entity = new HttpEntity<String>(params, headers);
		ResponseEntity<String> resp = template.exchange(url, method, entity, String.class);
		return resp.getBody();
		
	}

}
