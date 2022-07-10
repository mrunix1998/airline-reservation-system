$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("bookingdetails.feature");
formatter.feature({
  "line": 1,
  "name": "Booking Details",
  "description": "\r\nAs a user\r\nI want to review my booking\r\nSo that I can view details before the final confirmation",
  "id": "booking-details",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 9,
  "name": "User asks for Flights",
  "description": "",
  "id": "booking-details;user-asks-for-flights",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 10,
  "name": "the \"\u003cname\u003e\" is signed in with \"\u003cemail\u003e\" and \"\u003cpassword\u003e\" parameters",
  "keyword": "Given "
});
formatter.step({
  "line": 11,
  "name": "the user asks metrics from booking table",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "the user view details before confirmation with \"\u003cdate\u003e\"",
  "keyword": "Then "
});
formatter.examples({
  "line": 13,
  "name": "",
  "description": "",
  "id": "booking-details;user-asks-for-flights;",
  "rows": [
    {
      "cells": [
        "name",
        "email",
        "password",
        "date"
      ],
      "line": 14,
      "id": "booking-details;user-asks-for-flights;;1"
    },
    {
      "cells": [
        "Mohammad",
        "h.mammad@email.com",
        "1111",
        "01-14-2022"
      ],
      "line": 15,
      "id": "booking-details;user-asks-for-flights;;2"
    },
    {
      "cells": [
        "Fateme",
        "fateme@email.com",
        "1111",
        "01-14-2022"
      ],
      "line": 16,
      "id": "booking-details;user-asks-for-flights;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 43516000,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "User asks for Flights",
  "description": "",
  "id": "booking-details;user-asks-for-flights;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 10,
  "name": "the \"Mohammad\" is signed in with \"h.mammad@email.com\" and \"1111\" parameters",
  "matchedColumns": [
    0,
    1,
    2
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 11,
  "name": "the user asks metrics from booking table",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "the user view details before confirmation with \"01-14-2022\"",
  "matchedColumns": [
    3
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Mohammad",
      "offset": 5
    },
    {
      "val": "h.mammad@email.com",
      "offset": 34
    },
    {
      "val": "1111",
      "offset": 59
    }
  ],
  "location": "BookingDetailsStep.theIsSignedInWithAndParameters(String,String,String)"
});
formatter.result({
  "duration": 4573247800,
  "status": "passed"
});
formatter.match({
  "location": "BookingDetailsStep.theUserAsksMetricsFromBookingTable()"
});
formatter.result({
  "duration": 118703700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "01-14-2022",
      "offset": 48
    }
  ],
  "location": "BookingDetailsStep.theUserViewDetailsBeforeConfirmationWith(String)"
});
formatter.result({
  "duration": 55845400,
  "status": "passed"
});
formatter.after({
  "duration": 196300,
  "status": "passed"
});
formatter.before({
  "duration": 246900,
  "status": "passed"
});
formatter.scenario({
  "line": 16,
  "name": "User asks for Flights",
  "description": "",
  "id": "booking-details;user-asks-for-flights;;3",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 10,
  "name": "the \"Fateme\" is signed in with \"fateme@email.com\" and \"1111\" parameters",
  "matchedColumns": [
    0,
    1,
    2
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 11,
  "name": "the user asks metrics from booking table",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "the user view details before confirmation with \"01-14-2022\"",
  "matchedColumns": [
    3
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Fateme",
      "offset": 5
    },
    {
      "val": "fateme@email.com",
      "offset": 32
    },
    {
      "val": "1111",
      "offset": 55
    }
  ],
  "location": "BookingDetailsStep.theIsSignedInWithAndParameters(String,String,String)"
});
formatter.result({
  "duration": 124210200,
  "status": "passed"
});
formatter.match({
  "location": "BookingDetailsStep.theUserAsksMetricsFromBookingTable()"
});
formatter.result({
  "duration": 42526100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "01-14-2022",
      "offset": 48
    }
  ],
  "location": "BookingDetailsStep.theUserViewDetailsBeforeConfirmationWith(String)"
});
formatter.result({
  "duration": 46110200,
  "status": "passed"
});
formatter.after({
  "duration": 152000,
  "status": "passed"
});
formatter.uri("ticketlist.feature");
formatter.feature({
  "line": 1,
  "name": "Ticket List",
  "description": "\r\nAs a user\r\nI want to be see the search results page with filters\r\nSo that I can easily choose my desired flight",
  "id": "ticket-list",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 8,
  "name": "User asks for Flights",
  "description": "",
  "id": "ticket-list;user-asks-for-flights",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 9,
  "name": "the \"\u003cname\u003e\" is signed in with \"\u003cemail\u003e\" and \"\u003cpassword\u003e\" parameters to see ticket",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "the user asks \"\u003cflight_id\u003e\" metrics from flights table",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "the user sees the desired flights with \"\u003csrc_city\u003e\" and \"\u003cdst_city\u003e\" and \"\u003cdate\u003e\"",
  "keyword": "Then "
});
formatter.examples({
  "line": 12,
  "name": "",
  "description": "",
  "id": "ticket-list;user-asks-for-flights;",
  "rows": [
    {
      "cells": [
        "name",
        "email",
        "password",
        "flight_id",
        "src_city",
        "dst_city",
        "date"
      ],
      "line": 13,
      "id": "ticket-list;user-asks-for-flights;;1"
    },
    {
      "cells": [
        "Fateme",
        "fateme@email.com",
        "1111",
        "1",
        "1",
        "1",
        "01-14-2022"
      ],
      "line": 14,
      "id": "ticket-list;user-asks-for-flights;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 246900,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "User asks for Flights",
  "description": "",
  "id": "ticket-list;user-asks-for-flights;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 9,
  "name": "the \"Fateme\" is signed in with \"fateme@email.com\" and \"1111\" parameters to see ticket",
  "matchedColumns": [
    0,
    1,
    2
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "the user asks \"1\" metrics from flights table",
  "matchedColumns": [
    3
  ],
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "the user sees the desired flights with \"1\" and \"1\" and \"01-14-2022\"",
  "matchedColumns": [
    4,
    5,
    6
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Fateme",
      "offset": 5
    },
    {
      "val": "fateme@email.com",
      "offset": 32
    },
    {
      "val": "1111",
      "offset": 55
    }
  ],
  "location": "TicketListSteps.theIsSignedInWithAndParameters(String,String,String)"
});
formatter.result({
  "duration": 126312400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 15
    }
  ],
  "location": "TicketListSteps.theUserAsksMetricsFromFlightsTable(String)"
});
formatter.result({
  "duration": 125413600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 40
    },
    {
      "val": "1",
      "offset": 48
    },
    {
      "val": "01-14-2022",
      "offset": 56
    }
  ],
  "location": "TicketListSteps.theUserSeesTheDesiredFlightsWithAndAnd(Integer,Integer,String)"
});
formatter.result({
  "duration": 146578300,
  "status": "passed"
});
formatter.after({
  "duration": 131600,
  "status": "passed"
});
});