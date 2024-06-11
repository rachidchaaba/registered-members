package com.company.registeredmembers.services.formatting.impl;

import com.company.registeredmembers.model.CounterConfig;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FormattingCounterStrategyTest {

  private FormattingCounterStrategy beanUnderTest = new FormattingCounterStrategy();

  @Test
  void format_should_return_formatted_counter_with_prefix() {
    // Given
    final Integer value = 11;
    final CounterConfig counterConfig = CounterConfig.builder()
                                                     .prefix("C")
                                                     .numberOfDigits(5)
                                                     .index(4)
                                                     .build();

    // When
    final String formattedCounter = beanUnderTest.format(value, counterConfig);

    // Then
    assertThat(formattedCounter).isEqualTo("C00011");
  }

  @Test
  void format_should_return_formatted_counter_with_suffix() {
    // Given
    final Integer value = 11;
    final CounterConfig counterConfig = CounterConfig.builder()
                                                     .suffix("D")
                                                     .numberOfDigits(5)
                                                     .index(4)
                                                     .build();

    // When
    final String formattedCounter = beanUnderTest.format(value, counterConfig);

    // Then
    assertThat(formattedCounter).isEqualTo("00011D");
  }

  @Test
  void format_should_return_formatted_counter_with_prefix_and_suffix() {
    // Given
    final Integer value = 11;
    final CounterConfig counterConfig = CounterConfig.builder()
                                                     .prefix("C")
                                                     .suffix("D")
                                                     .numberOfDigits(5)
                                                     .index(4)
                                                     .build();

    // When
    final String formattedCounter = beanUnderTest.format(value, counterConfig);

    // Then
    assertThat(formattedCounter).isEqualTo("C00011D");
  }
}