package com.company.registeredmembers.services.formatting.impl;

import com.company.registeredmembers.model.NameConfig;
import com.company.registeredmembers.services.formatting.FormattingStrategy;
import org.springframework.stereotype.Service;

@Service
public class FormattingNameStrategy implements FormattingStrategy<String, NameConfig> {
  private String NAME_FORMAT = "%s%s%s";

  @Override
  public String format(String value, NameConfig nameConfig) {
    return String.format(
            NAME_FORMAT,
            getNullableValue(nameConfig.getPrefix()),
            getNullableValue(value).toUpperCase().substring(0, nameConfig.getLength()),
            getNullableValue(nameConfig.getSuffix())
    );
  }
}
