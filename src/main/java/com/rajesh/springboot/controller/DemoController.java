package com.rajesh.springboot.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.rajesh.springboot.model.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/staticData")
public class DemoController {

  @GetMapping(value = "/all")
  public String demo() throws IOException {

    ObjectMapper objectMapper = new ObjectMapper();

    // read json file and convert to customer object
    Customer customer = objectMapper.readValue(new File("customer.json"), Customer.class);

    String jsonStr = objectMapper.writeValueAsString(customer);
    // File file = new File(getClass().getResource("customer.json").getFile());

    return jsonStr;

  }

  @GetMapping(value = "/address")
  public String address() throws IOException {

    ObjectMapper objectMapper = new ObjectMapper();

    // read json file and convert to customer object
    Customer customer = objectMapper.readValue(new File("customer.json"), Customer.class);

    String jsonStr = objectMapper.writeValueAsString(customer.getAddress());

    return jsonStr;
  }
}
