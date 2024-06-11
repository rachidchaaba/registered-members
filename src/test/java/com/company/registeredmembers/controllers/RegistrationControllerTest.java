package com.company.registeredmembers.controllers;

import com.company.registeredmembers.model.RegisteredMember;
import com.company.registeredmembers.services.registration.RegistrationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RegistrationControllerTest {

  @InjectMocks
  private RegistrationController beanUnderTest;

  @Mock
  private RegistrationService registrationService;

  @Test
  void generateNumber_should_generate_unique_number() {
    // Given
    final RegisteredMember registeredMember = RegisteredMember.builder()
                                                              .firstName("Isaac")
                                                              .lastName("ANTOINE")
                                                              .birthDate(new Date())
                                                              .build();
    final String expectedNumber = "ANTO_ISA-C00008N1992";
    when(registrationService.generateNumber(registeredMember)).thenReturn(expectedNumber);

    // When
    final String generatedNumber = beanUnderTest.generateNumber(registeredMember);

    // Then
    assertThat(generatedNumber).isEqualTo(generatedNumber);
  }

}