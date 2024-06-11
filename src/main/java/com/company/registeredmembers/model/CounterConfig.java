package com.company.registeredmembers.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class CounterConfig extends PartialConfig {
  private int value;

  private int numberOfDigits;

  public int getIncrementedValue() {
    return ++value;
  }
}
