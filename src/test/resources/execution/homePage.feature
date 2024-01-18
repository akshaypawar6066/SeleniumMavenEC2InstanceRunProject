Feature: Home page functionality

@Smoke
Scenario: validation of title
Given User is at landing page
Then Page title should contains "Shopping"

@Smoke
Scenario: verify cart icon
Given User is at landing page
Then Cart icon should get displayed

Scenario: Checkout the deals section
Given User is at landing page
When User click on smart phones deal
Then deal section should get open


Scenario: Login to application
Given User is at landing page
When User enters the username as "8369038453" and clicks on continue button
And User enters the password as "akshay6066" and clicks on signIn button
Then User should get SignedIn succesfully