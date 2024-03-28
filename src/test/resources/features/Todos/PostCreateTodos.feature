Feature: Post todos
  Create new todos with valid body json and invalid body json

#  Positive
  @Project
    Scenario Outline: Post create new todos with valid body json
    Given Create new todos user with valid json "<json>"
    When Send request create new todos
    Then Status code todos should be 201
    And Response body name should be "<title>"
    And Validate todos json schema "<jsonSchema>"
    Examples:
      | json                           | title                              | jsonSchema                           |
      | PostCreateTodosValidJson1.json | delectus aut autem                 | PostCreateTodosValidJsonSchema1.json |
      | PostCreateTodosValidJson2.json | quis ut nam facilis et officia qui | PostCreateTodosValidJsonSchema2.json |
      | PostCreateTodosValidJson3.json | fugiat veniam minus                | PostCreateTodosValidJsonSchema3.json |


#    Negative
    @Project
    Scenario Outline: Post create new todos with invalid json
      Given Create new todos user with invalid json "<json>"
      When Send request create new todos
      Then Status code todos should be 400
      Examples:
        | json                             |
        | PostCreateTodosInvalidJson1.json |
        | PostCreateTodosInvalidJson2.json |






