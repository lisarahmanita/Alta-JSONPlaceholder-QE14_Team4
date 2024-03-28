Feature: Put Albums
  @Project
  Scenario Outline: Update albums with valid id and json
    Given Update albums with valid id <id> and valid json "<json>"
    When Send request update albums
    Then Status code should be 200
    And Response body id should <id> and title should "<title>"
    And Validate json schema "UpdateAlbumsJsonSchema.json"
    Examples:
      | id | json               | title                         |
      | 1  | UpdateAlbums1.json | quidem molestiae enim update1 |
      | 2  | UpdateAlbums2.json | quidem molestiae enim update2 |

  @Project
  Scenario Outline: Update albums with invalid id and valid json
    Given Update albums with invalid id "<id>" and valid json "<json>"
    When Send request update albums
    Then Status code should be 404
    Examples:
      | id   | json               |
      | satu | UpdateAlbums1.json |
      | $thv | UpdateAlbums2.json |

  @Project
  Scenario Outline: Update albums with valid id and invalid json
    Given Update albums with valid id <id> and invalid json "<json>"
    When Send request update albums
    Then Status code should be 400
    Examples:
      | id | json                      |
      | 1  | UpdateAlbumsInvalid1.json |
      | 2  | UpdateAlbumsInvalid2.json |
