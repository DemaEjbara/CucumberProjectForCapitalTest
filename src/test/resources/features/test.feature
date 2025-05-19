Feature: Verification the Requirements of the capital website

  Background:
    When show Modal Dialog on Home Page Screen
    Then click on the "closeModalButton"
    And wait for the accept cookies pop up to appear
    And click on the "Accept"

  Scenario: verify the home page load successfully
    Given user should redirect to "https://www.capitalbank.jo/en/personal"
    And contains as text "personalBanking" on the top header

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
      Examples:
      | homePageButton | expectedUrl |
      | homePageBranchesAndAtmButton | https://www.capitalbank.jo/en/personal/branches |
      | homePageIbanGeneratorButton  | https://www.capitalbank.jo/en/personal/iban     |
      | homePageWaysToBankButton     | https://www.capitalbank.jo/en/personal/ways-to-bank |
      | homePageCustomerSupportButton | https://www.capitalbank.jo/en/personal/knowledge-hub |
      | homePageCalculatorsButton     | https://www.capitalbank.jo/en/personal/calculators   |
      | homePageProductFinderButton    | https://www.capitalbank.jo/en/personal/product-finder |
      
      Scenario: verify that the "Get App" button is clickable
        Given click on the "getTheAppButton"
        Then user should redirect to "https://www.capitalbank.jo/en/personal/get-the-app"
        And contains as text "getTheAppTitlePage" on the top header



