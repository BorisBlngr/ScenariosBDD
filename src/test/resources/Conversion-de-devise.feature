Feature: Conversion de devise

   Scenario: Conversion vers une même devise pour un montant entier
      When Je convertis 1 "EUR" en "EUR"
      Then Je dois avoir 1 "EUR"

   Scenario: Conversion vers une même devise pour un montant avec décimales
      When Je convertis 2.5 "USD" en "USD"
      Then Je dois avoir 2.5 "USD"

   Scenario: Si j'ai un montant négatif, je ne peux pas convertir
      When Je convertis -1 "EUR" en "EUR"
      Then Je ne peux pas convertir

   Scenario: J'ai un montant de -2.5, je ne peux pas convertir
      When Je convertis -2.5 "USD" en "USD"
      Then Je ne peux pas convertir

   Scenario: On ne peut pas mettre de lettre dans le montant
      When Je convertis "abc" "USD" en "USD"
      Then Je ne peux pas convertir

   Scenario: On ne peut pas mettre de caractère spécial dans le montant
      When Je convertis "!?:" "USD" en "USD"
      Then Je ne peux pas convertir