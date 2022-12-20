Feature: Automation Web UI on TickTick page
  @test
  Scenario: CRUD of a task list
    Given Load page ticktick
    When User log in
    And Verify user logged in the page
    When User create a new task
    Then The task is named "New task"
    And Verify the task was created
    When User update the task with "Update task"
    And Verify the task was updated
    When User delete the task
    And Verify the task was delete
    Then Close the session

