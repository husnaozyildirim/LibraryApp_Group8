@db
Feature: As a data consumer, I want the user information to be stored in mySql DB correctly on users table.

  Scenario: verify users has unique IDs
    When Execute query to get all IDs from users
    Then verify all users has a unique ID

  Scenario: verify users table columns
    When Execute query to get all columns
    Then verify the below columns are listed in the result
      | id            |
      | full_name     |
      | email         |
      | password      |
      | user_group_id |
      | image         |
      | extra_data    |
      | status        |
      | is_admin      |
      | start_date    |
      | end_date      |
      | address       |