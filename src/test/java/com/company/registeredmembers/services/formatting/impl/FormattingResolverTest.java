package com.company.registeredmembers.services.formatting.impl;

import com.company.registeredmembers.exceptions.UnresolvedFormattingStrategyException;
import com.company.registeredmembers.model.CounterConfig;
import com.company.registeredmembers.model.DateConfig;
import com.company.registeredmembers.model.NameConfig;
import com.company.registeredmembers.model.PartialConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

@ExtendWith(MockitoExtension.class)
class FormattingResolverTest {

  @InjectMocks
  private FormattingResolver beanUnderTest;

  @Mock
  private FormattingNameStrategy formattingNameStrategy;

  @Mock
  private FormattingDateStrategy formattingDateStrategy;

  @Mock
  private FormattingCounterStrategy formattingCounterStrategy;

  @Test
  void resolve_should_return_formattingNameStrategy_when_config_is_nameConfig() {
    assertThat(beanUnderTest.resolve(new NameConfig()))
            .isEqualTo(formattingNameStrategy);
  }

  @Test
  void resolve_should_return_formattingDateStrategy_when_config_is_dateConfig() {
    assertThat(beanUnderTest.resolve(new DateConfig()))
            .isEqualTo(formattingDateStrategy);
  }

  @Test
  void resolve_should_return_formattingCounterStrategy_when_config_is_counterConfig() {
    assertThat(beanUnderTest.resolve(new CounterConfig()))
            .isEqualTo(formattingCounterStrategy);
  }

  @Test
  void resolve_should_throw_UnresolvedFormattingStrategyException_when_strategy_is_not_resolved() {
    final Throwable throwable = catchThrowable(() -> beanUnderTest.resolve(new PartialConfig()));

    assertThat(throwable)
            .isExactlyInstanceOf(UnresolvedFormattingStrategyException.class)
            .hasMessage("No formatting strategy is resolved for the type 'PartialConfig'");
  }
}