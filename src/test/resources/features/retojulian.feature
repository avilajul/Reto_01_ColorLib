#Author Julian Avila
@stories
  Feature: Verify the completion of the Block Validation screen.
    The user must be able to enter the form and fill in the required fields.
    Each field performs mandatory, length and format validations.
    The system must present the validations through an informative notice.

    @successful_scenario_completed_fields
    Scenario Outline: the form will be filled out
      Given julian enters go to the page to verify the completion of the validation block
      |userName|password|
      |<userName>|<password>|
      When julian enters the form validation option
      And  julian fills out the Block Validation form
      | required | email | formPassword | formConfirmPassword |date  | url | digitOnly | range |
      |<required>|<email>|<formPassword>|<formConfirmPassword>|<date>|<url>  |<digitOnly>|<range>|
      Then verify that julian successfully filled out the form
      Examples:
        |userName |password| required   | email            | formPassword | formConfirmPassword |date      | url                    | digitOnly | range |
        |demo     |demo    |prueba 1    |tester@gmail.com|contrasena123   |contrasena123        |26/03/1984|https://www.google.com  | 189703125 | 6     |
        |demo     |demo    |prueba 2    |correo@gmail.com|contrasena      |contrasena           |04/08/1991|https://www.hotmail.com | 45        | 15    |
        |demo     |demo    |prueba 3    |email123@gmail.com|c0ntr4as3n4     |c0ntr4as3n4        |03/09/2022|https://www.bbc.com/    | 222450111 | 16    |


    @failed_scenario_empty_fields
    Scenario Outline: without filling out the form
      Given julian enters go to the page to verify the completion of the validation block
        |userName|password|
        |<userName>|<password>|
      When julian enters the form validation option
      And  julian does not fills out the Block Validation form
        | required | email | formPassword | formConfirmPassword |date  | url | digitOnly | range |
        |<required>|<email>|<formPassword>|<formConfirmPassword>|<date>|<url>  |<digitOnly>|<range>|
      Then verify that julian failure to fill out the form
      Examples:
        |userName |password| required   | email            | formPassword | formConfirmPassword |date      | url                  | digitOnly | range |
        |         |        |            |                  |              |                     |          |                      |           |       |


    @failed_scenario_invalid_email
    Scenario Outline: wrong filling in the email field
      Given julian enters go to the page to verify the completion of the validation block
        |userName|password|
        |<userName>|<password>|
      When julian enters the form validation option
      And  julian fills out the Block Validation form
        | required | email | formPassword | formConfirmPassword |date  | url | digitOnly | range |
        |<required>|<email>|<formPassword>|<formConfirmPassword>|<date>|<url>  |<digitOnly>|<range>|
      Then verify that julian filled out the mail wrong
      Examples:
        |userName |password| required   | email            | formPassword | formConfirmPassword |date      | url                     | digitOnly | range |
        |demo     |demo    |prueba email|correo_sin_arroba |Ramdom        |Ramdom               |03/09/2022|https://www.google.com/  | 222450111 | 8     |
        |demo     |demo    |prueba email|correo@           |Ramdom        |Ramdom               |03/09/2022|https://www.bgoogle.com/ | 222450111 | 11    |


    @failed_scenario_password_length
    Scenario Outline: enter less than 5 characters in the password field
      Given julian enters go to the page to verify the completion of the validation block
        |userName|password|
        |<userName>|<password>|
      When julian enters the form validation option
      And  julian fills out the Block Validation form
        | required | email | formPassword | formConfirmPassword |date  | url | digitOnly | range |
        |<required>|<email>|<formPassword>|<formConfirmPassword>|<date>|<url>  |<digitOnly>|<range>|
      Then verify that julian filled out less than five characters in the password field
      Examples:
        |userName |password| required        | email            | formPassword | formConfirmPassword |date      | url                  | digitOnly | range |
        |demo     |demo    |password longitud|correo_sin_arroba |xa            |xa                   |03/09/2022|https://www.bbc.com/  | 222450111 | 9     |
        |demo     |demo    |password longitud|correo@           |hola          |hola                 |03/09/2022|https://www.bbc.com/  | 222450111 | 15    |

    @failed_scenario_different_password
    Scenario Outline: enter different passwords
      Given julian enters go to the page to verify the completion of the validation block
        |userName|password|
        |<userName>|<password>|
      When julian enters the form validation option
      And  julian fills out the Block Validation form
        | required | email | formPassword | formConfirmPassword |date  | url | digitOnly | range |
        |<required>|<email>|<formPassword>|<formConfirmPassword>|<date>|<url>  |<digitOnly>|<range>|
      Then verify that julian filled different passwords
      Examples:
        |userName |password| required   | email              | formPassword | formConfirmPassword |date      | url                  | digitOnly | range |
        |demo     |demo    |prueba error|example@testing.com |password123   |123password          |03/09/2022|https://www.bbc.com/  | 222450111 | 9     |


    @failed_scenario_invalid_url
    Scenario Outline: enter invalid url
      Given julian enters go to the page to verify the completion of the validation block
        |userName|password|
        |<userName>|<password>|
      When julian enters the form validation option
      And  julian fills out the Block Validation form
        | required | email | formPassword | formConfirmPassword |date  | url | digitOnly | range |
        |<required>|<email>|<formPassword>|<formConfirmPassword>|<date>|<url>  |<digitOnly>|<range>|
      Then verify that julian filled invalid url
      Examples:
        |userName |password| required   | email            | formPassword | formConfirmPassword |date      | url             | digitOnly | range |
        |demo     |demo    |prueba url|example@testing.com |password123     |password123            |03/09/2022|www.youtube.com  | 222450111 | 9     |
        |demo     |demo    |prueba url|example@testing.com |password123     |password123            |03/09/2022|esto no es url   | 222450111 | 9     |


    @failed_scenario_invalid_digits
    Scenario Outline: enter invalid digits
      Given julian enters go to the page to verify the completion of the validation block
        |userName|password|
        |<userName>|<password>|
      When julian enters the form validation option
      And  julian fills out the Block Validation form
        | required | email | formPassword | formConfirmPassword |date  | url | digitOnly | range |
        |<required>|<email>|<formPassword>|<formConfirmPassword>|<date>|<url>  |<digitOnly>|<range>|
      Then verify that julian filled invalid digits
      Examples:
        |userName |password| required   | email            | formPassword | formConfirmPassword |date      | url                      | digitOnly  | range |
        |demo     |demo    |prueba url|example@testing.com |password123   |password123          |03/09/2022|https://www.youtube.com/  | 222dfDBN11 | 9     |
        |demo     |demo    |prueba url|example@testing.com |password123   |password123          |03/09/2022|https://www.youtube.com/  | 8+43%*542  | 9     |


    @failed_scenario_invalid_range
    Scenario Outline: enter invalid range
      Given julian enters go to the page to verify the completion of the validation block
        |userName|password|
        |<userName>|<password>|
      When julian enters the form validation option
      And  julian fills out the Block Validation form
        | required | email | formPassword | formConfirmPassword |date  | url | digitOnly | range |
        |<required>|<email>|<formPassword>|<formConfirmPassword>|<date>|<url>  |<digitOnly>|<range>|
      Then verify that julian filled invalid range
      Examples:
        |userName |password| required   | email            | formPassword | formConfirmPassword |date      | url                      | digitOnly    | range |
        |demo     |demo    |prueba url|example@testing.com |password123   |password123          |03/09/2022|https://www.youtube.com/  | 123400056789 | 4     |
        |demo     |demo    |prueba url|example@testing.com |password123   |password123          |03/09/2022|https://www.youtube.com/  | 123400056789 | 17    |
