# FieldVision – NFL Game Prediction Service

**FieldVision** is a backend service built with **Spring Boot** that powers the NFL Game Predictor platform.  
It communicates with the Python **GameAPI** microservice to fetch real-time NFL data and prediction analytics.

---

## Overview
FieldVision handles user management, game records, and integrates predictions provided by the FastAPI service `GameAPI`.  
It’s built as a scalable, modular Java application following clean architecture principles.

---

## Tech Stack
- **Language:** Java 17  
- **Framework:** Spring Boot  
- **Database:** PostgreSQL  
- **API Integration:** OpenFeign (for calling GameAPI)  
- **Containerization:** Docker  
- **Testing:** JUnit, Mockito  
- **Build Tool:** Maven  

---

## Modules & Endpoints

### Game Module  
**Base URL:** `/api/v1/games`

| Method | Endpoint | Description |
|---------|-----------|-------------|
| GET | `/all` | Retrieve all games |
| GET | `/{id}` | Retrieve a specific game by ID |
| PATCH | `/update/{id}` | Update game info |
| DELETE | `/delete/{id}` | Delete a game |

**Example Response:**  
```json
[
  {
    "id": 1,
    "week": 7,
    "season": 2025,
    "home_team": "JAX",
    "away_team": "LA",
    "home_score": 7,
    "away_score": 0,
    "gameday": "2025-10-19T00:00:00.000+00:00"
  }
]
```

---

### Prediction Module  
**Base URL:** `/api/v1/predictions`

| Method | Endpoint | Description |
|---------|-----------|-------------|
| GET | `/all` | Retrieve all predictions |
| GET | `/{id}` | Retrieve a prediction by ID |

**Example Response:**  
```json
[
  {
    "prediction_id": 1,
    "homeTeam": "LAC",
    "awayTeam": "MIN",
    "home_win_probability": 0.56,
    "away_win_probability": 0.44
  }
]
```

---

### User Module  
**Base URL:** `/api/v1/users`

| Method | Endpoint | Description |
|---------|-----------|-------------|
| GET | `/all` | Get all users |
| GET | `/{id}` | Get user by ID |
| POST | `/create` | Create new user |
| PATCH | `/update/{id}` | Update user |
| DELETE | `/delete/{id}` | Delete user |

**Example Response:**  
```json
[
  {
    "id": 1,
    "username": "footballfan123",
    "email": "fan@example.com",
  }
]
```

---

## Integration with GameAPI
FieldVision uses **OpenFeign** to make REST calls to `GameAPI` endpoints for:  
- Fetching the current week’s games  
- Fetching win probabilities between two teams  

Example Feign call configuration:  
```application.properties
gameapi.base-url: http://localhost:8000
```

---

## Setup & Run

### 1. Clone the repo  
```bash
git clone https://github.com/LoadingElii/fieldvision.git
cd fieldvision
```

### 2. Configure environment  
Edit `application.properties` with your database credentials and GameAPI base URL.

### 3. Run the app  
```bash
mvn spring-boot:run
```

---

## Testing  
```bash
mvn test
```

---

## Author  
**Delijhia Brown**  
- [GitHub](https://github.com/elicancode)  
- [LinkedIn](https://linkedin.com/in/delijhia-brown)  
- [YouTube](https://youtube.com/@elicancode)

---

## License  
MIT License
