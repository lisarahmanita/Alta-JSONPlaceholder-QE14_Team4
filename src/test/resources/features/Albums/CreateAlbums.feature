Feature: Post Albums
  @Project
  Scenario Outline: Post Create albums with valid data json
    Given Create albums with valid json "<json>"
    When Send request create new albums
    Then Status code should be 201
    And Response body userId should <userId> and title should "<title>"
    And Validate json schema "CreateAlbumsJsonSchema.json"
    Examples:
      | json               | userId | title                   |
      | CreateAlbums1.json | 1      | quidem molestiae enim   |
      | CreateAlbums2.json | 3      | id non nostrum expedita |

  @Project
  Scenario Outline: Post Create albums with invalid data json
    Given Create albums with invalid json "<json>"
    When Send request create new albums
    Then Status code should be 400
    Examples:
      | json                      |
      | CreateAlbumsInvalid1.json |
      | CreateAlbumsInvalid2.json |