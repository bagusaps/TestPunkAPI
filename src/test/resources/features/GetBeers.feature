@GetBeersFeature
Feature: Get Beers Feature

  @VerifyAmount
  Scenario Outline: Verify amount data get beers with per page <perPage>
    Given prepare data to get beers with page <page>
    And prepare data to get beers with per page <perPage>
    When get beers with paramater page and per page
    Then get beers response data is <perPage>
    Examples:
      | page | perPage |
      | 2    | 1       |
      | 2    | 5       |
      | 2    | 20      |

  @VerifyJsonSchema
  Scenario: Verify json schema get beers
    Given get beers json schema is correct
