Feature: Validar API de usuarios

  Scenario: Obtener usuario por ID correctamente
    Given ejecuto el endpoint GET de usuario con id 1
    Then el status code debe ser 500
    And el campo name no debe ser null
