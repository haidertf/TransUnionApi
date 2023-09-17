#Author: Haider Fabian Tique
#Date: 14 - 09 - 2023

@APISTEST
@APISTESTSTORE
@APISTESTGETSTORE
Feature: Se requiere validar la automatizacion de una de las apis Get store

  @GetfindPurchaseOrderbyId
  Scenario Outline: Se realiza la prueba exitosa al api get store
    Given Se ingresa a la url de la api SWAGGER
    When Se ejecuta el api find purchase order by <id>
    Then Se valida el esquema json path: apisStore/getfindPurchaseOrderbyId.json
    Examples:
      | id |
      | 2  |
