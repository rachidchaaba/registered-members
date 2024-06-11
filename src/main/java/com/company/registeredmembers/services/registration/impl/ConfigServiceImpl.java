package com.company.registeredmembers.services.registration.impl;

import com.company.registeredmembers.model.RegistrationConfig;
import com.company.registeredmembers.services.registration.ConfigService;
import org.springframework.stereotype.Service;

@Service
public class ConfigServiceImpl implements ConfigService {
  private static RegistrationConfig registrationConfig = null;

  @Override
  public void setConfig(RegistrationConfig registrationConfig) {
    this.registrationConfig = registrationConfig;
  }

  @Override
  public RegistrationConfig getConfig() {
    return registrationConfig;
  }
}
