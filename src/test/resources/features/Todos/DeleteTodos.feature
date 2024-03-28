Feature: Delete Todos
  Delete todos with valid parameter and invalid parameter


#  Positive
  @Project
  Scenario: Delete todos user with valid parameter id
    Given Delete todos with valid parameter id 1
    When Send request get user todos
    Then Status code todos should be 200

#    Negative
  @Project
  Scenario: Delete todos user with invalid parameter id
    Given Delete todos with invalid parameter id "satu"
    When Send request get user todos
    Then Status code todos should be 404





