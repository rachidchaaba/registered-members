package com.company.registeredmembers.services.registration;

import com.company.registeredmembers.model.RegisteredMember;

public interface RegistrationService {
  String generateNumber(RegisteredMember registeredMember);
}
