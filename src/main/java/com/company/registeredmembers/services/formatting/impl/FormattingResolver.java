package com.company.registeredmembers.services.formatting.impl;

import com.company.registeredmembers.exceptions.UnresolvedFormattingStrategyException;
import com.company.registeredmembers.model.DateConfig;
import com.company.registeredmembers.model.NameConfig;
import com.company.registeredmembers.model.CounterConfig;
import com.company.registeredmembers.model.PartialConfig;
import com.company.registeredmembers.services.formatting.FormattingStrategy;
import org.springframework.stereotype.Service;

@Service
public class FormattingResolver {
  private FormattingNameStrategy formattingNameStrategy;
  private FormattingDateStrategy formattingDateStrategy;
  private FormattingCounterStrategy formattingCounterStrategy;

  public FormattingResolver(
          FormattingNameStrategy formattingNameStrategy,
          FormattingDateStrategy formattingDateStrategy,
          FormattingCounterStrategy formattingCounterStrategy
  ) {
    this.formattingNameStrategy = formattingNameStrategy;
    this.formattingDateStrategy = formattingDateStrategy;
    this.formattingCounterStrategy = formattingCounterStrategy;
  }

  public FormattingStrategy resolve(PartialConfig partialConfig) {
    if (partialConfig instanceof NameConfig) {
      return formattingNameStrategy;
    } else if (partialConfig instanceof DateConfig) {
      return formattingDateStrategy;
    } else if (partialConfig instanceof CounterConfig) {
      return formattingCounterStrategy;
    }
    throw new UnresolvedFormattingStrategyException(partialConfig.getClass().getSimpleName());
  }
}
