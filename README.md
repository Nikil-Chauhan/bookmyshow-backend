# BookMyShow – Movie Ticket Booking Backend

A backend-focused movie ticket booking system built with **Java and Spring Boot**.

The application provides REST APIs for managing movies, cities, theaters, screens, seats, shows, users, and bookings.

The project demonstrates a layered backend architecture using **Spring Boot, Spring Data JPA, Hibernate, and MySQL**.

---

## 🚀 Features

- Movie management
- City management
- Theater management
- Screen management
- Seat management
- Show management
- User management
- Booking management
- Seat availability checking
- CRUD operations through REST APIs
- Database persistence using MySQL

---

## 🛠️ Tech Stack

| Technology | Usage |
|---|---|
| Java | Backend development |
| Spring Boot | Application framework |
| Spring MVC | REST API development |
| Spring Data JPA | Data access |
| Hibernate | ORM |
| MySQL | Relational database |
| Maven | Build and dependency management |
| Postman | API testing |
| Git & GitHub | Version control |

---

## 🏗️ Architecture

The application follows a layered backend architecture:

```text
Client
  │
  ▼
Controller Layer
  │
  ▼
Service Layer
  │
  ▼
Repository Layer
  │
  ▼
MySQL Database

📁 Project Structure
src/
└── main/
    ├── java/
    │   └── com/cfs/bms/
    │       ├── controller/
    │       ├── service/
    │       ├── repository/
    │       ├── entity/
    │       └── dto/
    │
    └── resources/
        └── application.properties

📌 API Endpoints

Movies
Method	Endpoint	Description
POST	/api/movies	Create a movie
GET	/api/movies	Get all movies
GET	/api/movies/{id}	Get movie by ID
PUT	/api/movies/{id}	Update a movie
DELETE	/api/movies/{id}	Delete a movie

Bookings
Method	Endpoint	Description
POST	/api/bookings	Create a booking
GET	/api/bookings	Get all bookings
GET	/api/bookings/{id}	Get booking by ID

Additional REST APIs are available for cities, theaters, screens, seats, shows, and users.

🗄️ Database

The application uses MySQL for persistent data storage.

Main Entities
Movie
City
Theater
Screen
Seat
Show
User
Booking

Spring Data JPA and Hibernate are used for database interaction and object-relational mapping.

⚙️ How to Run
Prerequisites

Make sure the following are installed:

Java JDK
Maven
MySQL
Git
Postman

1. Clone the Repository
git clone https://github.com/Nikil-Chauhan/bookmyshow-backend.git

2. Navigate to the Project
cd bookmyshow-backend

3. Create the Database

Create a MySQL database:

CREATE DATABASE bookmyshow;

4. Configure Database Connection

Update the following file:

src/main/resources/application.properties

Example configuration:

spring.datasource.url=jdbc:mysql://localhost:3306/bookmyshow
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

5. Build the Project
mvn clean install

6. Run the Application
mvn spring-boot:run

The application will run on:

http://localhost:8080
🧪 API Testing

The REST APIs can be tested using Postman.

Example:

GET http://localhost:8080/api/movies

The API supports standard HTTP operations:

GET
POST
PUT
DELETE

📚 Key Learning Outcomes

Through this project, I practiced:

REST API development with Spring Boot
CRUD operations
Spring Data JPA
Hibernate ORM
MySQL integration
Layered backend architecture
DTO-based API communication
API testing with Postman
Maven dependency management
Git and GitHub

🔮 Future Improvements

Spring Security
JWT-based authentication
Role-based authorization
Global exception handling
Input validation
Swagger / OpenAPI documentation
Payment integration
Docker support

👨‍💻 Author

Nikil Chauhan

Java Backend Developer

GitHub: https://github.com/Nikil-Chauhan/Nikil-Chauhan
LinkedIn: https://www.linkedin.com/in/nikil-chauhan-5972b625b/
