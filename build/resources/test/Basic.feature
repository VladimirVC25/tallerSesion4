Feature: When Do
  Scenario: Validar funcionabilidad de la aplicacion

    Given la aplicacion WhenDo esta abierta
    When presiono el boton +
    And agregar titulo "Tarea1"
    And agregar notas  "Nota1"
    And presiono confirmar
    Then el resultado deberia ser: "Tarea1"