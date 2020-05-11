Feature: Registration

Background:
Given user navigates to webpage
When User provides neccessary details for login
Then User clicks submit button


@tag1
Scenario: To validate  add recipient
Given User clicks add recipient
When User verify add recipient page title
Then User provides neccessary details for add recipient
And click add button
