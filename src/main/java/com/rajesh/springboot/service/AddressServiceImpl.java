package com.rajesh.springboot.service;

import com.rajesh.springboot.gateway.AddressService;
import com.rajesh.springboot.helper.IntegrationHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

  @Autowired private IntegrationHelper integrationHelper;

  @Override
  public String createAddress() {
    return integrationHelper.getAddress();
  }
}
