package com.rajesh.springboot.controller;

import com.rajesh.springboot.gateway.ClientService;
import com.rajesh.springboot.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {

  private final Logger LOGGER = LoggerFactory.getLogger(ClientController.class);

  @Autowired private ClientService clientService;

  @GetMapping(value = "/{clientId}")
  public Object clientCreation(@PathVariable String clientId) {
    LOGGER.info("checking clientId::::" + clientId);

    return clientService.clientCreation(clientId);
  }

  @PostMapping
  public ResponseEntity insertAddress(Customer address) {
    return clientService.insertAddress(address);
  }
}
