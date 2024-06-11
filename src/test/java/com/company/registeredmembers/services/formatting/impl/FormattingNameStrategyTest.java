package com.company.registeredmembers.services.formatting.impl;

import com.company.registeredmembers.model.NameConfig;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FormattingNameStrategyTest {

  private FormattingNameStrategy beanUnderTest = new FormattingNameStrategy();

  @Test
  void format_should_return_formatted_name_with_prefix() {
    // Given
    final String value = "Rachid";
    final NameConfig counterConfig = NameConfig.builder()
                                               .prefix("-")
                                               .length(3)
                                               .index(4)
                                               .build();

    // When
    final String formattedCounter = beanUnderTest.format(value, counterConfig);

    // Then
    assertThat(formattedCounter).isEqualTo("-RAC");
  }

  @Test
  void format_should_return_formatted_name_with_suffix() {
    // Given
    final String value = "Rachid";
    final NameConfig counterConfig = NameConfig.builder()
                                               .suffix("_")
                                               .length(3)
                                               .index(4)
                                               .build();

    // When
    final String formattedCounter = beanUnderTest.format(value, counterConfig);

    // Then
    assertThat(formattedCounter).isEqualTo("RAC_");
  }

  @Test
  void format_should_return_formatted_name_with_prefix_and_suffix() {
    // Given
    final String value = "Rachid";
    final NameConfig counterConfig = NameConfig.builder()
                                               .prefix("-")
                                               .suffix("_")
                                               .length(3)
                                               .index(4)
                                               .build();

    // When
    final String formattedCounter = beanUnderTest.format(value, counterConfig);

    // Then
    assertThat(formattedCounter).isEqualTo("-RAC_");
  }
}