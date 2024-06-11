package com.company.registeredmembers.services.registration;

import com.company.registeredmembers.model.RegistrationConfig;

public interface ConfigService {
  void setConfig(RegistrationConfig registrationConfig);

  RegistrationConfig getConfig();
}
