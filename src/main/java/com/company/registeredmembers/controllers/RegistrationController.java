package com.company.registeredmembers.controllers;

import com.company.registeredmembers.model.RegisteredMember;
import com.company.registeredmembers.services.registration.RegistrationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

  private RegistrationService registrationService;

  public RegistrationController(RegistrationService registrationService) {
    this.registrationService = registrationService;
  }

  @PostMapping
  public String generateNumber(@RequestBody RegisteredMember registeredMember) {
    return registrationService.generateNumber(registeredMember);
  }
}
