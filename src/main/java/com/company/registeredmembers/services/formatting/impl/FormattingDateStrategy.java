package com.company.registeredmembers.services.formatting.impl;

import com.company.registeredmembers.model.DateConfig;
import com.company.registeredmembers.services.formatting.FormattingStrategy;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class FormattingDateStrategy implements FormattingStrategy<Date, DateConfig> {
  private static final String DEFAULT_DATE_PATTERN = "YYYY";
  private static final String DATE_FORMAT = "%s%s%s";

  @Override
  public String format(Date value, DateConfig dateConfig) {
    return String.format(
            DATE_FORMAT,
            getNullableValue(dateConfig.getPrefix()),
            new SimpleDateFormat(getNullableValue(dateConfig.getPattern(), DEFAULT_DATE_PATTERN)).format(value),
            getNullableValue(dateConfig.getSuffix())
    );
  }
}
