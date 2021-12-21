Feature:  Items

  @WhenDo
  Scenario:  Create Item

    Given i have the whenDo app opened
    And i create an item using
      | title | Tarea1 |
      | note  | description |
    Then the item "Tarea1" should be displayed
