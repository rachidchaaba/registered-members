package com.company.registeredmembers.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class NameConfig extends PartialConfig {
  private int length;
}
