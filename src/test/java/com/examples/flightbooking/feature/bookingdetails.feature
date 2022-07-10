Feature: Booking Details

  As a user
  I want to review my booking
  So that I can view details before the final confirmation



  Scenario Outline: User asks for Flights
    Given the "<name>" is signed in with "<email>" and "<password>" parameters
    When  the user asks metrics from booking table
    Then  the user view details before confirmation with "<date>"
    Examples:
      |    name    |           email            |    password    |     date       |
      |  Mohammad  |    h.mammad@email.com      |       11113     |   01-14-2022   |
      |   Fateme   |    fateme@email.com        |       1111     |   01-14-2022   |