Feature: Get todos
  Get todos user

#  Positive
  @Project
  Scenario Outline: Get user todos with valid paramter id
    Given User todos with valid paramtere <id>
    When Send request get user todos
    Then Status code should be 200
    And Response body should be <id> and <title>
    And Validate todos json schema "GetTodosJsonSchema.json"
    Examples:
      | id | title                              |
      | 1  | delectus aut autem                 |
      | 2  | quis ut nam facilis et officia qui |
      | 3  | fugiat veniam minus                |


#    Negatif
 Scenario Outline: Get user todos with invalid parameter id
   Given User totos with  invalid parameter <id>
   When Send request get user todos
   Then Status code should be 404
   Examples:
     | id   |
     | satu |
     | $atu |
     | s@tu |

