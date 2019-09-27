package com.rajesh.springboot;

import com.rajesh.springboot.model.Customer;
import com.rajesh.springboot.model.Personal;
import com.rajesh.springboot.service.ClientServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringbootApplicationTests {
  @Autowired private TestRestTemplate testRestTemplate;

  @MockBean RestTemplate restTemplate;

  @Test
  public void clientCreationTest() {

    Personal c = new Personal();
    c.setAge("27");
    c.setEmail("rajeshketha");

    Mockito.when(restTemplate.getForEntity("http://localhost:8080/12345", Personal.class))
        .thenReturn(new ResponseEntity(c, HttpStatus.OK));

    ResponseEntity<Personal> rm = testRestTemplate.getForEntity("/client/12345", Personal.class);

    System.out.println("inside junit" + rm);

    Assert.assertEquals("rjeshketha", rm.getBody().getEmail());
  }

  @Test
  public void clientCreation() {

    Mockito.when(
            restTemplate.getForObject("http://localhost:8080/client-service/12345", String.class))
        .thenReturn("Helloworld");

    ResponseEntity<String> rm = testRestTemplate.getForEntity("/address/12345", String.class);
    System.out.println(rm.getBody());
  }
}
