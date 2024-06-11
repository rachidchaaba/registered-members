package com.company.registeredmembers.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class PartialConfig {
  protected String prefix;
  protected int index;
  protected String suffix;
}
