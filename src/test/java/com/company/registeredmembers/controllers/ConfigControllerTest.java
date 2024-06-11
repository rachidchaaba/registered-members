package com.company.registeredmembers.controllers;

import com.company.registeredmembers.model.NameConfig;
import com.company.registeredmembers.model.RegistrationConfig;
import com.company.registeredmembers.services.registration.ConfigService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ConfigControllerTest {

  @InjectMocks
  private ConfigController beanUnderTest;

  @Mock
  private ConfigService configService;

  @Test
  void getConfig_should_return_registration_config() {
    // Given
    final RegistrationConfig expectedConfig = RegistrationConfig.builder()
                                                                .firstNameConfig(
                                                                        NameConfig.builder()
                                                                                  .length(4)
                                                                                  .index(1)
                                                                                  .build()
                                                                )
                                                                .build();
    when(configService.getConfig()).thenReturn(expectedConfig);

    // When
    final RegistrationConfig registrationConfig = beanUnderTest.getConfig();

    // Then
    assertThat(registrationConfig).isEqualTo(expectedConfig);
  }

  @Test
  void updateConfig_should_update_registration_config() {
    // Given
    final RegistrationConfig config = RegistrationConfig.builder()
                                                        .firstNameConfig(
                                                                NameConfig.builder()
                                                                          .length(4)
                                                                          .index(1)
                                                                          .build()
                                                        )
                                                        .build();

    // When
    beanUnderTest.updateConfig(config);

    // Then
    verify(configService).setConfig(config);
  }

}