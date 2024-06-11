package com.company.registeredmembers.services.formatting.impl;

import com.company.registeredmembers.model.CounterConfig;
import com.company.registeredmembers.services.formatting.FormattingStrategy;
import org.springframework.stereotype.Service;

@Service
public class FormattingCounterStrategy implements FormattingStrategy<Integer, CounterConfig> {
  private String COUNTER_FORMAT = "%s%s%s";

  @Override
  public String format(Integer value, CounterConfig counterConfig) {
    return String.format(
            COUNTER_FORMAT,
            getNullableValue(counterConfig.getPrefix()),
            String.format("%0" + counterConfig.getNumberOfDigits() + "d", value),
            getNullableValue(counterConfig.getSuffix())
    );
  }
}
