Feature: Login en SauceDemo

  Scenario: Login exitoso
    Given el usuario abre la pagina de SauceDemo
    When inicia sesion con credenciales validas
    Then visualiza la pagina de productos
