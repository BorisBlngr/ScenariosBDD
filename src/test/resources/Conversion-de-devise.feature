Feature: Conversion de devise
    Scenario: Conversion vers une même devise pour un montant entier
    When Je convertis 1 "EUR" en "EUR"
    Then Je dois avoir 1 "EUR"

    Scenario: Conversion vers une même devise pour un montant avec décimales
    When Je convertis 2.5 "USD" en "USD"
    Then Je dois avoir 2.5 "USD"