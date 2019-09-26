package com.rajesh.springboot.gateway;


import com.rajesh.springboot.model.Customer;
import org.springframework.http.ResponseEntity;

public interface ClientService {

  ResponseEntity clientCreation(String ClientId);

    ResponseEntity insertAddress(Customer address);
}
