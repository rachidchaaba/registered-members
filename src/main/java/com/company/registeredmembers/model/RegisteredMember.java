package com.company.registeredmembers.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisteredMember {
  private String firstName;
  private String lastName;
  @JsonFormat(shape = STRING, pattern = "dd/MM/yyyy")
  private Date birthDate;
}
