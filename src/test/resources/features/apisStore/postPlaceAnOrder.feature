#Author: Haider Fabian Tique
#Date: 14 - 09 - 2023

@APISTEST
Feature: Se requiere validar la automatizacion de dos apis post store

  @PostPlaceOrder
  Scenario: Se realiza la prueba exitosa al api post store
    Given Se ingresa a la url de la api SWAGGER
    When Se ejecuta el api post place an order
    Then Se valida el esquema json path: apisStore/PostPlaceOrder.json
