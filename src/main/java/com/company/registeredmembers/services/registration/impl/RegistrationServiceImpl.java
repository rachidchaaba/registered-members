package com.company.registeredmembers.services.registration.impl;

import com.company.registeredmembers.model.PartialConfig;
import com.company.registeredmembers.model.RegisteredMember;
import com.company.registeredmembers.model.RegistrationConfig;
import com.company.registeredmembers.services.formatting.impl.FormattingResolver;
import com.company.registeredmembers.services.registration.ConfigService;
import com.company.registeredmembers.services.registration.RegistrationService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

@Service
public class RegistrationServiceImpl implements RegistrationService {
  private static final String COUNTER_FORMAT = "%s%s%s%s";
  private ConfigService configService;
  private FormattingResolver formattingResolver;

  public RegistrationServiceImpl(ConfigService configService, FormattingResolver formattingResolver) {
    this.configService = configService;
    this.formattingResolver = formattingResolver;
  }

  @Override
  public String generateNumber(RegisteredMember registeredMember) {
    final RegistrationConfig registrationConfig = configService.getConfig();
    final Map<Integer, String> valuesByIndex = new HashMap<>();
    addFormattedValue(registeredMember.getFirstName(), registrationConfig.getFirstNameConfig(), valuesByIndex);
    addFormattedValue(registeredMember.getLastName(), registrationConfig.getLastNameConfig(), valuesByIndex);
    addFormattedValue(registeredMember.getBirthDate(), registrationConfig.getBirthDateConfig(), valuesByIndex);
    addFormattedValue(registrationConfig.getCounterConfig().getIncrementedValue(), registrationConfig.getCounterConfig(), valuesByIndex);
    return valuesByIndex.entrySet()
                        .stream()
                        .sorted(Entry.comparingByKey())
                        .map(Entry::getValue)
                        .collect(Collectors.joining());
  }

  private void addFormattedValue(Object value, PartialConfig registrationConfig, Map<Integer, String> valuesByIndex) {
    final String formattedValue = formattingResolver.resolve(registrationConfig)
                                                    .format(value, registrationConfig);
    valuesByIndex.put(registrationConfig.getIndex(), formattedValue);
  }

}
