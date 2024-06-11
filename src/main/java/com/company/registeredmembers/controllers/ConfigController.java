package com.company.registeredmembers.controllers;

import com.company.registeredmembers.model.RegistrationConfig;
import com.company.registeredmembers.services.registration.ConfigService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class ConfigController {

  private ConfigService configService;

  public ConfigController(ConfigService configService) {
    this.configService = configService;
  }

  @GetMapping
  public RegistrationConfig getConfig() {
    return configService.getConfig();
  }

  @PutMapping
  public void updateConfig(@RequestBody RegistrationConfig registrationConfig) {
    configService.setConfig(registrationConfig);
  }
}
