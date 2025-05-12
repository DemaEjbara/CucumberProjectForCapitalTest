Feature: Verification the Requirements of the capital website
  Scenario: check for user on home page after open the website
    Given user should redirect to "https://www.capitalbank.jo/en/personal"
    And contains as text " PERSONAL BANKING" on the top header