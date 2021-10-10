Feature: Echoing a message

  As a user
  I want an echo service
  So I can play with Spring

  Scenario: Receive an echo of a message sent through the API
    Given application is up
    When I send a message "Hello"
    Then API replies "echo <Hello>"
