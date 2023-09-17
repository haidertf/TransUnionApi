#Author: Haider Fabian Tique
#Date: 14 - 09 - 2023

@APISTEST
@APISTESTPET
@APISTESTGETPET
Feature: Se requiere validar la automatizacion de una de las apis Get pet

  @GetFindByStatus
  Scenario Outline: Se realiza la prueba exitosa al api get pet
    Given Se ingresa a la url de la api SWAGGER
    When Se ejecuta el api find by status <status>
    Then Se valida el esquema json path: apisPet/getFindByStatusAvailableAndSold.json
    Examples:
      | status    |
      | available |
      | pending   |
      | sold      |

#  @GetFindByStatusPending
#  Scenario Outline: Se realiza la prueba exitosa al api get pet pending
#    Given Se ingresa a la url de la api SWAGGER
#    When Se ejecuta el api find by status <status>
#    Then Se valida el esquema json path: apisPet/getFindByStatusPending.json
#    Examples:
#      | status  |
#      | pending |
