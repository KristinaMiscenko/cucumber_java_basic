Feature: Verify numbers

  Scenario: Verify too small number error
    When Navigate to url "https://kristinek.github.io/site/tasks/enter_a_number"
    When Enter "12"
    And Click on the Submit button
    Then I see an error "Number is too small"

  Scenario: Verify too big number error
    When Navigate to url "https://kristinek.github.io/site/tasks/enter_a_number"
    When Enter "113"
    And Click on the Submit button
    Then I see an error "Number is too big"

  Scenario: Verify text error
    When Navigate to url "https://kristinek.github.io/site/tasks/enter_a_number"
    When Enter "text"
    And Click on the Submit button
    Then I see an error "Please enter a number"

  @debugs
  Scenario Outline: Verify errors
    When Navigate to url "https://kristinek.github.io/site/tasks/enter_a_number"
    When Enter "<number>"
    And Click on the Submit button
    Then I see an error "<error>"

    @working
    Examples:
      | number  | error |
      | 12   | Number is too small  |
      | 113 | Number is too big |
      | text  | Please enter a number |

  Scenario: Verify correct number
    When Navigate to url "https://kristinek.github.io/site/tasks/enter_a_number"
    When Enter "64"
    And Click on the Submit button
    Then I will see message "Square root of 64 is 8.00"

