Feature: GET: Automated Demo Tests
  Description: GET: purpose of this feature is to test some demo app.

  @get
   Scenario Outline: GETing  details in Google Map API and updating the Address and verifying new changed address
    Given User set the Query Parameters for the service API
    When User perform the GET operation for the given service URL
    Then the status code is "<StatusCode>"
    Examples:
      | StatusCode  |
      | 200 |


   #Posting the URL , POST and PUT the Place Name of the Google Map API Request
  @post 
  Scenario Outline: Posting New details in Google Map API and updating the Address and verifying new changed address
   Given User set the Query Parameters for the service API
    When User perform POST operation with a new set of address details
    And User perform GET with new set of details with address as "<AddressDetails>"
    Examples:
      | AddressDetails  |
      | 29, side layout, cohen 09 |


       #Updating the URL with the Place Name of the Google Map API Request
  
  @put
  Scenario Outline:  Updating by changing the address details in Google Map API and verifying new changed address
    Given User set the Query Parameters for the service API
    And User perform update of address in the existing data with new Address as "<NewAddressDetails>" with Status Message as "<StatusMessage>"
    And User verify the updated address as "<NewAddressDetails>"
Examples:
  | NewAddressDetails  |StatusMessage|
  | Summer Walk, Africa |Address successfully updated|







 