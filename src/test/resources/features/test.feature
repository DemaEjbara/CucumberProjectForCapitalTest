Feature: Verification the Requirements of the capital website

  Scenario: verify the home page load successfully
    Given user should redirect to "https://www.capitalbank.jo/en/personal"
    And contains as text "personalBanking" on the top header


    Scenario: verify the burger menu is clickable
      Given click on the "burgerMenu"
      Then the navigation sidebar is shown


      Scenario: verify the capital online service is not available on the website
        Given click on the "capitalOnline"