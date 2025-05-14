Feature: Verification the Requirements of the capital website

  Background:
    When show Modal Dialog on Home Page Screen
    Then click on the "closeModalButton"

  Scenario: verify the home page load successfully
    Given user should redirect to "https://www.capitalbank.jo/en/personal"
    And contains as text "personalBanking" on the top header

    Scenario: verify the burger menu is clickable
      Given click on the "burgerMenu"
      Then the navigation sidebar is shown

    Scenario: verify the capital online service is not available on the website
        Given click on the "capitalOnline"
        Then redirect to page explains no available for Capital Online service

      Scenario: verify the "Branches & ATMs  " button is clickable
        Given click on the "branchesAndAtm"
        Then user should redirect to "https://www.capitalbank.jo/en/personal/branches"