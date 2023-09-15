#Author: Haider Fabian Tique
#Date: 14 - 09 - 2023

@APISTEST
Feature: Se requiere validar la automatizacion de una de las apis Get pet

  @GetFindByStatus
  Scenario Outline: Se realiza la prueba exitosa al api get pet
    Given Se ingresa a la url de la api SWAGGER
    When Se ejecuta el api find by status <status>
    Then Se valida el esquema json path: apisPet/getFindByStatusSold.json
    Examples:
      | status    |
      | available |
      | pending   |
      | sold      |