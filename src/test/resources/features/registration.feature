# Created by Rachid at 11/06/2024
Feature: Generate registered members numbers
  Test registered members numbers

  Scenario: Case 1
    # pour les critères de numérotation
    #- Les 3 premières lettres du prénom avec un suffixe - et ordre 1
    #- Le 4 premières lettres du nom avec un suffixe _ et ordre 2
    #- la date de naissance formatée en YYYY et ordre 3
    #- le compteur avec la valeur initiale 10, le préfixe C et formaté sur 5 chiffres et ordre 4
    #le résultat de la génération avec Marc PASSAU né le 24/04/1974 sera MAR-PASS_1974C00011
    Given the first name configuration is
      | suffix | length | index |
      | -      | 3      | 1     |
    And the last name configuration is
      | suffix | length | index |
      | _      | 4      | 2     |
    And the birth date configuration is
      | pattern | index |
      | YYYY    | 3     |
    And the counter configuration is
      | prefix | numberOfDigits | value | index |
      | C      | 5              | 10    | 4     |
    When we generate the number for the member
      | firstName | lastName | birthDate  |
      | Marc      | PASSAU   | 24/04/1974 |
    Then the generated number is "MAR-PASS_1974C00011"

  Scenario: Case 2
    # pour le critères de numérotation
    #- Les 3 premières lettres du prénom avec un suffixe - et ordre 2
    #- Le 4 premières lettres du nom avec un suffixe _ et ordre 1
    #- la date de naissance formatée en YYYY,le préfixe N et ordre 4
    #- le compteur avec la valeur initiale 7, le préfixe C et formaté sur 5 chiffres et ordre 3
    Given the first name configuration is
      | suffix | length | index |
      | -      | 3      | 2     |
    And the last name configuration is
      | suffix | length | index |
      | _      | 4      | 1     |
    And the birth date configuration is
      | prefix | pattern | index |
      | N      | YYYY    | 4     |
    And the counter configuration is
      | prefix | numberOfDigits | value | index |
      | C      | 5              | 7     | 3     |
    When we generate the number for the member
      | firstName | lastName | birthDate  |
      | Isaac     | ANTOINE  | 24/04/1992 |
    Then the generated number is "ANTO_ISA-C00008N1992"