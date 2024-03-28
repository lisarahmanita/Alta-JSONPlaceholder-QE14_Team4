Feature: Put Todos
  Put todos with valid body json and invalid body json

#  Positive
  @Project
  Scenario Outline: Update todos with valid json and valid user id
    Given Update todos with valid json "<json>" and user userId <id>
    When Send request update user
    Then Status code todos should be 200
    And Response body name should be <userId> and title is "<title>"
    And Validate todos json schema "<jsonSchema>"
    Examples:
      | json                          | id | userId | title              | jsonSchema                          |
      | PutUpdateTodosValidJson1.json | 1  | 1      | delectus aut autem | PutUpdateTodosValidJsonSchema1.json |
      | PutUpdateTodosValidJson2.json | 2  | 1      | Ok Semua           | PutUpdateTodosValidJsonSchema2.json |

#   Negative
  @Project
  Scenario Outline: :Update todos with invalid id and valid json
  Given Update todos with invalid id "<id>" and valid json "<json>"
  When Send request update todos
  Then Status code todos should be 404
    Examples:
      | id   | json                          |
      | satu | PutUpdateTodosValidJson1.json |


#   Negative
  @Project
  Scenario Outline: Update todos with valid id and invalid json
    Given Update todos with valid id <id> and invalid json "<json>"
    When Send request update todos
    Then Status code todos should be 400
    Examples:
      | json                            | id |
      | PutUpdateTodosInvalidJson1.json | 1  |