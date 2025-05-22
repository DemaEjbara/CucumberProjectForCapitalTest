Feature: Verification the Requirements of the capital website

  Background:
    When show Modal Dialog on Home Page Screen
    Then click on the "closeModalButton"
    And wait for the accept cookies pop up to appear
    And click on the "Accept"

  Scenario: verify the home page load successfully
    Given user should redirect to "https://www.capitalbank.jo/en/personal"
    And should contains as text "personalBanking" on the top header

  Scenario: verify the burger menu is clickable
    Given click on the "burgerMenu"
    Then the navigation sidebar is shown
    And it should contain menu items in the top left side of sidebar
    And should contains the main menu items

  Scenario Outline: verify that the "<selectedButtonInTheTopBurgerMenu>" button in the top left sideBar of burger menu is clickable
    Given click on the "burgerMenu"
    When click on the "<selectedButtonInTheTopBurgerMenu>"
    Then user should redirect to "<expectedUrl>"
    Examples:
      | selectedButtonInTheTopBurgerMenu | expectedUrl |
      | burgerMenuCustomerSupportButton | https://www.capitalbank.jo/en/personal/knowledge-hub |
      | burgerMenuAtmAndBranchesButton  | https://www.capitalbank.jo/en/personal/branches     |
      | burgerMenuBankOffersButton     | https://www.capitalbank.jo/en/personal/bank-offers |
      | burgerMenuPrivateBankingButton | https://www.capitalbank.jo/en/personal/private-banking |

  Scenario: verify the "Capital Online Service" page is not available on the website
    Given click on the "capitalOnline"
    Then redirect to a page indicating that the Capital Online service is not available

  Scenario Outline: Verify that the "<homePageButton>" button on the home page is clickable and redirects correctly
    Given click on the "<homePageButton>"
    Then user should redirect to "<expectedUrl>"
    And should contains as text "<expected head title text>" on the top header
    Examples:
      | homePageButton               | expectedUrl |       expected head title text |
      | homePageBranchesAndAtmButton | https://www.capitalbank.jo/en/personal/branches | AtmAndBranchesTitlePage |
      | homePageIbanGeneratorButton  | https://www.capitalbank.jo/en/personal/iban     | IbanGeneratorTitlePage  |
      | homePageWaysToBankButton     | https://www.capitalbank.jo/en/personal/ways-to-bank | WaysToBankTitlePage |
      | homePageCustomerSupportButton | https://www.capitalbank.jo/en/personal/knowledge-hub | CustomerSupportTitlePage |
      | homePageCalculatorsButton     | https://www.capitalbank.jo/en/personal/calculators   | CalculatorsTitlePage     |
      | homePageProductFinderButton    | https://www.capitalbank.jo/en/personal/product-finder | ProductFinderTitlePage |

  Scenario: verify that the "Get App" button is clickable
    Given click on the "getTheAppButton"
    Then user should redirect to "https://www.capitalbank.jo/en/personal/get-the-app"
    And should contains as text "getTheAppTitlePage" on the top header

  Scenario Outline: Verify that the product finder recommends appropriate products based on user needs
    Given the user should be on the product finder section
    And click on the "IWant"
    When click on the "<userNeed>"
    And click on the "homePageStarNowButton"
    Then user should redirect to "<expected url>"
    And should contains as text "<expected head title text>" on the top header
    Examples:
    | userNeed     | expected url                                             | expected head title text |
    | cardSpending | https://www.capitalbank.jo/en/personal/cards             | cardsHeadTitleText       |
    | buyingCar    | https://www.capitalbank.jo/en/personal/loans/auto-loan   | carLoanTitleText         |
    |financingHome | https://www.capitalbank.jo/en/personal/loans/housing-loan    | financingHomeTitleText   |
    |fundsPersonal | https://www.capitalbank.jo/en/personal/loans/personal-loan   | fundsPersonalTitleText   |
    | saveMoney    | https://www.capitalbank.jo/en/personal/deposits/term-deposit |saveMoneyTitleText        |


