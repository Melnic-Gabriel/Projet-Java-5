## **Project Documentation**

### **1. API Endpoints Definition**

#### **Game Controller Endpoints** (`/games`)
- **GET** `/games/getGameById/{id}`
  - **Description**: Retrieves a game by its ID.
  - **Parameters**:
    - `id` (PathVariable): The unique ID of the game.
  - **Response**: Returns the `Game` object associated with the ID.
  - **Example Response**:
    ```json
    {
      "id": 1,
      "date": "2024-12-12",
      "gameType": "Strategy",
      "maximumScore": 100,
      "hostId": 2
    }
    ```

- **DELETE** `/games/deleteGame/{id}`
  - **Description**: Deletes a game by its ID.
  - **Parameters**:
    - `id` (PathVariable): The unique ID of the game.
  - **Response**: No content (HTTP 204).
  - **Example Response**: None.

- **POST** `/games/addGame`
  - **Description**: Adds a new game.
  - **Parameters**: The `Game` object to be added in the request body.
  - **Response**: Returns the newly created `Game` object.
  - **Example Request**:
    ```json
    {
      "date": "2024-12-12",
      "gameType": "Strategy",
      "maximumScore": 100,
      "hostId": 2
    }
    ```

- **POST** `/games/updateGame`
  - **Description**: Updates an existing game.
  - **Parameters**: The `Game` object to be updated in the request body.
  - **Response**: Returns the updated `Game` object.


#### **Player Controller Endpoints** (`/players`)
- **GET** `/players/getPlayerById/{id}`
  - **Description**: Retrieves a player by their ID.
  - **Parameters**:
    - `id` (PathVariable): The unique ID of the player.
  - **Response**: Returns the `Player` object associated with the ID.

- **POST** `/players/addPlayer`
  - **Description**: Adds a new player.
  - **Parameters**: The `Player` object to be added in the request body.
  - **Response**: Returns the newly created `Player` object.

- **POST** `/players/updatePlayer`
  - **Description**: Updates an existing player.
  - **Parameters**: The `Player` object to be updated in the request body.
  - **Response**: Returns the updated `Player` object.

- **DELETE** `/players/deletePlayer/{id}`
  - **Description**: Deletes a player by their ID.
  - **Parameters**:
    - `id` (PathVariable): The unique ID of the player.
  - **Response**: No content (HTTP 204).

- **GET** `/players/getPlayerStatisticsById/{id}`
  - **Description**: Retrieves a player's statistics.
  - **Parameters**:
    - `id` (PathVariable): The unique ID of the player.
  - **Response**: Returns a string with the player's statistics.
  - **Example Response**:
    ```json
    "Player JohnDoe has 120 points and is level 3"
    ```

- **POST** `/players/addFriend/{idPlayer}/{idFriend}`
  - **Description**: Adds a friend to a player.
  - **Parameters**:
    - `idPlayer` (PathVariable): The unique ID of the player.
    - `idFriend` (PathVariable): The unique ID of the friend.
  - **Response**: No content (HTTP 204).

- **DELETE** `/players/deleteFriend/{idPlayer}/{idFriend}`
  - **Description**: Removes a friend from a player.
  - **Parameters**:
    - `idPlayer` (PathVariable): The unique ID of the player.
    - `idFriend` (PathVariable): The unique ID of the friend.
  - **Response**: No content (HTTP 204).


### **2. Application Logic**

#### **Game Management Logic**
- The `GameController` handles incoming HTTP requests related to the game entities. 
  - The `GameService` is used to interact with the DAO layer (`GameDAO`), which performs CRUD operations on the `Game` entity.
  - A game can be created, updated, retrieved, or deleted by its unique ID.

#### **Player and Friend Management Logic**
- The `PlayerController` manages players and their relationships with friends.
  - Players can be created, updated, or deleted.
  - The service layer (`PlayerService`) manages the player logic, while the DAO layer (`PlayerDAO`) is responsible for interacting with the database.
  - The addition and removal of friends are handled via the `addFriend` and `deleteFriend` methods.

#### **Business Decisions**
- The structure uses the DAO pattern for data access, ensuring that all interactions with the database are abstracted through `GameDAO` and `PlayerDAO`. 
- The service layer provides the business logic and validation, ensuring that controllers are focused on handling HTTP requests and responses.


### **3. Database Design**

The database includes two main entities: `Game` and `Player`, each with corresponding relationships.

#### **Entities**

- **Game**
  - `id` (Long): The unique identifier for the game.
  - `date` (Date): The date the game is played.
  - `gameType` (String): Type of the game (e.g., "Strategy", "Action").
  - `maximumScore` (Integer): The maximum score a player can achieve in the game.
  - `hostId` (Long): The ID of the host player.

- **Player**
  - `id` (Long): The unique identifier for the player.
  - `name` (String): The player's name.
  - `nickname` (String): The player's nickname.
  - `email` (String): The player's email address.
  - `level` (Integer): The player's level.
  - `totalPoints` (Integer): The player's total points accumulated.

- **Friend**
  - `id` (Long): The unique identifier for the friendship.
  - `player` (Player): The player associated with the friendship.
  - `friend` (Player): The friend of the player in the friendship.

#### **Database Schema**
The relationships between the entities can be represented as follows:

- `Player` has a many-to-many relationship with `Player` through the `Friend` entity.
- The `Game` entity is independent, but it has a relationship to `Player` via the `hostId` field.

---

### **4. Workflow Explanation**

### Client Request:
The client sends a request to retrieve a player by ID (e.g., `GET /players/getPlayerById/1`).

---

### Controller:
- The controller's method (`getPlayerById`) handles the request and extracts the `id` parameter.
- It then calls the `findPlayerById` method in the service layer.

---

### Service:
- The service receives the request and calls the DAO's `getPlayerById` method, delegating the task of retrieving the player.

---

### DAO:
- The DAO calls the repository's `findById` method to fetch the player data from the database.
- If the player does not exist, it throws an exception.

---

### Repository:
- The repository uses Spring Data JPA to query the database and fetch the player record based on the provided ID.
- If a player is found, it is returned to the DAO layer.

---

### Response:
1. The DAO returns the player to the service layer.
2. The service sends the player to the controller.
3. The controller formats the player data and sends it as an HTTP response to the client.

---

## Why Use This Multi-Layer Architecture?

1. **Separation of Concerns**: Each layer has a specific role, making the codebase more modular and easier to maintain.
2. **Reusability**: Business logic in the service layer and database logic in the DAO layer can be reused across different controllers.
3. **Scalability**: Adding new features or endpoints is straightforward as the architecture is well-structured.
4. **Testability**: Each layer can be tested independently (e.g., unit tests for the service layer, integration tests for the DAO layer).
5. **Flexibility**: Changes in one layer (e.g., switching the database) do not directly impact other layers.
