Feature: Ticket List

  As a user
  I want to be see the search results page with filters
  So that I can easily choose my desired flight


  Scenario Outline: User asks for Flights
    Given the "<name>" is signed in with "<email>" and "<password>" parameters to see ticket
    When  the user asks "<flight_id>" metrics from flights table
    Then  the user sees the desired flights with "<src_city>" and "<dst_city>" and "<date>"
    Examples:
      |    name    |           email            |    password    |  flight_id  |   src_city   |    dst_city  |     date     |
      |  Mohammad  |    mohammad331@gmail.com   |    mrunix1998  |      5      |   1          |       3      |   01-15-2022 |
      |    nika    |    nika293@gmail.com       |    nibaka1999  |      2      |   3          |       1      |   01-15-2022 |
      |   Fateme   |    fateme@email.com        |       1111     |      1      |   1          |       1      |   01-14-2022 |