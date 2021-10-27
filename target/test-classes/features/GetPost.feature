Feature:
  Verify different GET operations using REST-assured

  Scenario: Verify one author of the post
    Given I perform GET operation for "/posts"
    Then I should see the author name "Mateus Valentim"

  Scenario: Verify collections of authors in the post
    Given I perform GET operation for "/post"
    Then I should see the author names

  Scenario: Verify Path Parameter of GET
    Given I perform GET operation for "/post"
    Then I should see verify GET path Parameter

  Scenario: Verify Query Parameter of GET
    Given I perform GET operation for "/post"
    Then I should see verify GET query Parameter