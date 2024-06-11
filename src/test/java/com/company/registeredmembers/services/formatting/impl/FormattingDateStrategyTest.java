package com.company.registeredmembers.services.formatting.impl;

import com.company.registeredmembers.model.DateConfig;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.JUNE;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;
import static org.assertj.core.api.Assertions.assertThat;

class FormattingDateStrategyTest {

  private FormattingDateStrategy beanUnderTest = new FormattingDateStrategy();

  @Test
  void format_should_return_formatted_date_with_prefix() {
    // Given
    final Calendar calendar = Calendar.getInstance();
    calendar.set(YEAR, 2024);
    calendar.set(MONTH, JUNE);
    calendar.set(DAY_OF_MONTH, 10);
    final Date value = calendar.getTime();
    final DateConfig dateConfig = DateConfig.builder()
                                            .prefix("D")
                                            .pattern("ddMMyyyy")
                                            .build();

    // When
    final String formattedDate = beanUnderTest.format(value, dateConfig);

    // Then
    assertThat(formattedDate).isEqualTo("D10062024");
  }

  @Test
  void format_should_return_formatted_date_with_suffix() {
    // Given
    final Calendar calendar = Calendar.getInstance();
    calendar.set(YEAR, 2024);
    calendar.set(MONTH, JUNE);
    calendar.set(DAY_OF_MONTH, 10);
    final Date value = calendar.getTime();
    final DateConfig dateConfig = DateConfig.builder()
                                            .suffix("D")
                                            .pattern("yyyy")
                                            .build();

    // When
    final String formattedDate = beanUnderTest.format(value, dateConfig);

    // Then
    assertThat(formattedDate).isEqualTo("2024D");
  }

  @Test
  void format_should_return_formatted_date_with_prefix_and_suffix() {
    // Given
    final Calendar calendar = Calendar.getInstance();
    calendar.set(YEAR, 2024);
    calendar.set(MONTH, JUNE);
    calendar.set(DAY_OF_MONTH, 10);
    final Date value = calendar.getTime();
    final DateConfig dateConfig = DateConfig.builder()
                                            .prefix("D")
                                            .pattern("YYYY")
                                            .suffix("E")
                                            .build();

    // When
    final String formattedDate = beanUnderTest.format(value, dateConfig);

    // Then
    assertThat(formattedDate).isEqualTo("D2024E");
  }
}