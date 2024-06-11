package com.company.registeredmembers.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationConfig {
  private NameConfig firstNameConfig;
  private NameConfig lastNameConfig;
  private DateConfig birthDateConfig;
  private CounterConfig counterConfig;
}
