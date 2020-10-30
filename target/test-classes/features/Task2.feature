Feature: Persons

  @debug
  Scenario Outline: Add person
    When Navigate to url "https://kristinek.github.io/site/tasks/list_of_people.html"
    And Click on the Add person button
    And Enter name: "<name>"
    And Enter surname: "<surname>"
    And Enter job: "<job>"
    And Enter Date of Birth: "<date>"
    Then Click on the Add button


    @working
    Examples:
      | name  | surname | job | date |
      | Marry | Jane  | Reporter | 06.08.1983 |
      | Henry | Jackson | Actor  | 03.05.1967 |


  Scenario: Edit person
    When Navigate to url "https://kristinek.github.io/site/tasks/list_of_people.html"
    And Click Edit button
    And Enter job: "Actor"
    Then Click on the Edit button

    Scenario: Delete person
      When Navigate to url "https://kristinek.github.io/site/tasks/list_of_people.html"
      Then Click Delete button

      Scenario: Actions with person
        When Navigate to url "https://kristinek.github.io/site/tasks/list_of_people.html"
        And Click on the Add person button
        And Enter name: "Alisa"
        And Enter surname: "Chudesnaya"
        And Enter job: "Singer"
        And Enter Date of Birth: "06.08.1995"
        And Click on the Add button
        And Click Edit button
        And Enter job: "Actor"
        And Click on the Edit button
        And Click Delete button
        Then Click Reset list button


