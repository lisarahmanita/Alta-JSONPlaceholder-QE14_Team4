Feature: Delete Todos
  Delete todos user


#  Positive
  @Project
  Scenario: Delete todos user with valid parameter id
    Given Delete todos with valid parameter id 1
    When Send request get user todos
    Then Status code should be 200

#    Negative
  Scenario: Delete todos user with invalid parameter id
    Given Delete todos with invalid parameter id "satu"
    When Send request get user todos
    Then Status code should be 404





