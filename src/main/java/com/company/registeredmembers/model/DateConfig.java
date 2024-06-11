package com.company.registeredmembers.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class DateConfig extends PartialConfig {
  private String pattern;
}
