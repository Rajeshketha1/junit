package com.rajesh.springboot.util;

import com.rajesh.springboot.model.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestTemplateUtil {

  private RestTemplateUtil() {}

  public static ResponseEntity getRestTemplate(String url, Customer customer) {
    RestTemplate rs = new RestTemplate();
    return rs.postForEntity(url, customer, Customer.class);
  }

  public static RestTemplate restTemplate() {
    return new RestTemplate();
  }
}
