Feature: Validating place API's
Scenario Outline: Add Place API
Given Add Place Payload with "<Name>" "<Language>" "<Address>"
When user calls "addPlaceAPI" with "Post" http request
Then the API call is success with status code 200
And "status" in response body is "OK"
And "scope" in response body is "APP"
Examples:
|Name|Language|Address|
|White House|English|Hyderabad|
|KV Heights|French|France|
