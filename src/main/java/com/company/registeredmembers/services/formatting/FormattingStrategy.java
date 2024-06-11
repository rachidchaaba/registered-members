package com.company.registeredmembers.services.formatting;

import com.company.registeredmembers.model.PartialConfig;

import static java.util.Optional.ofNullable;

public interface FormattingStrategy<T, U extends PartialConfig> {
  String EMPTY = "";

  String format(T value, U partConfig);

  default String getNullableValue(String value) {
    return getNullableValue(value, EMPTY);
  }

  default String getNullableValue(String value, String defaultValue) {
    return ofNullable(value).orElse(defaultValue);
  }
}
