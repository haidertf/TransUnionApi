#Author: Haider Fabian Tique
#Date: 14 - 09 - 2023

@APISTEST
@APISTESTPET
@APISTESTPOSTPET
Feature: Se requiere validar la automatizacion de una de las apis post pet

  @GetFindByStatus
  Scenario Outline: Se realiza la prueba exitosa al api post pet
    Given Se ingresa a la url de la api SWAGGER
    When Se ejecuta el api updates a pet <id> <updatename> <updatesold>
    Then Se valida el esquema json path: apisPet/postUpdatePet.json
    Examples:
      | id | updatename | updatesold |
      | 4  | prueba     | sold       |