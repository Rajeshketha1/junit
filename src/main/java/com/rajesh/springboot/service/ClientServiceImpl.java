package com.rajesh.springboot.service;

import com.rajesh.springboot.gateway.ClientService;
import com.rajesh.springboot.model.Customer;
import com.rajesh.springboot.model.Personal;
import com.rajesh.springboot.util.RestTemplateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClientServiceImpl implements ClientService {
  private final Logger LOGGER = LoggerFactory.getLogger(ClientServiceImpl.class);

  @Value("${endpoint.url}")
  String url;

  @Autowired private RestTemplate restTemplate;

  @Override
  public ResponseEntity clientCreation(String clientId) {

    ResponseEntity<Personal> rs =
        restTemplate.getForEntity("http://localhost:8080/12345", Personal.class);
    System.out.println("check" + rs.getBody());

    return rs;
  }

  @Override
  public ResponseEntity insertAddress(Customer customer) {
    return RestTemplateUtil.getRestTemplate(url, customer);
  }
}
