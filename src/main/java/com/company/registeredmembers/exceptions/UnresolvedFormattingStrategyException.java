package com.company.registeredmembers.exceptions;

import static java.lang.String.format;

public class UnresolvedFormattingStrategyException extends RuntimeException {

  public UnresolvedFormattingStrategyException(String typeName) {
    super(format("No formatting strategy is resolved for the type '%s'", typeName));
  }

}
