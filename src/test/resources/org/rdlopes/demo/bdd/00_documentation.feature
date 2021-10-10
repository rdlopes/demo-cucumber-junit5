Feature: Open API Documentation

  As a developer,
  I want to access the Open API specification
  So I know how to use the application API

  Scenario: Open API specification is made available through default endpoints
    Given application is up
    When I request the Open API specifications
    Then I receive the specs for the application
