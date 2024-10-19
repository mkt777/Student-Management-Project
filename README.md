# Student Management System

This is a Spring Boot application for managing student data using JPA (Java Persistence API) and MySQL. The system supports CRUD (Create, Read, Update, Delete) operations for student information, such as adding new students, fetching student details, updating student data, and deleting student records.

## Features
- **Create**: Add new students to the system.
- **Read**: Fetch all students or filter students by their enrolled course.
- **Update**: Modify existing student data.
- **Delete**: Remove student records .

## Technologies Used
- **Java**: Primary programming language.
- **Spring Boot**: Framework used for building the application.
- **Spring Data JPA**: For interacting with the database using JPA.
- **MySQL**: The relational database used to store student data.
- **REST APIs**: To interact with the system via HTTP methods (GET, POST, PUT, DELETE).
  
**1. Controller Layer:**
The `StudentController` class handles HTTP requests related to student operations. It defines several endpoints:
- `/std/get/{courseName}`: Retrieves a list of students enrolled in a specific course.
- `/std/save`: Saves a new student based on data provided in the request body.
- `/std/delete/{id}`: Deletes a student by their ID.
- `/std/get`: Fetches all students.
- `/std/update/{id}`: Updates student data based on the provided ID.

**2. Request Data Object (DTO):**
The `StudentRequest` class is a simple Data Transfer Object (DTO) used to collect student data from the request. It includes:
- `id`
- `name`
- `course`
- `address`
- `DOB` (Date of Birth)
- `enrolmentNum`

**3. Entity Layer:**
The `Student` class represents the `students` table in the database. Each field is mapped to a column:
- The primary key is `id`, generated automatically.
- Other fields are:
  - `name`
  - `course`
  - `address`
  - `DOB`
  - `enrolmentNum`

**4. Repository Layer:**
The `StudentRepo` interface extends `JpaRepository`, which provides built-in methods for common operations such as saving, deleting, and finding entities. It also includes a custom query method:
- `findByCourse(String course)`: Fetches all students enrolled in a particular course.
- `getAllStudentData()`: A native query to fetch all student data.

**5. Service Layer:**
The `StdService` interface and its implementation `StdServiceImpl` provide the business logic:
- `getAllStudentByCourse`: Fetches students by course.
- `saveStdData`: Converts `StudentRequest` to `Student` using a utility method and saves it.
- `deleteStudent`: Deletes a student by ID.
- `getAllStudent`: Fetches all students.
- `updateStudent`: Updates an existing student's data if found by ID.

**6. Application Setup:**
The `JpaDemoApplication` class initializes the Spring Boot application.

**7. Configuration:**
In `application.properties`, database connection details are specified:
- Connection to MySQL database on localhost with the username and password `root`.
  
## Project Structure

```plaintext
src/
├── main/
│   ├── java/
│   │   └── com/genie/JPADemo/
│   │       ├── controller/            # Handles HTTP requests
│   │       ├── dao/                   # Data Transfer Objects (DTO)
│   │       ├── entity/                # Student entity class
│   │       ├── repo/                  # Repository interface for database operations
│   │       ├── service/               # Service layer for business logic
│   │       └── util/                  # Utility methods (e.g., Mapper)
│   └── resources/
│       └── application.properties     # Application configuration (DB connection, etc.)
└── test/                              # Unit tests


This code represents a Spring Boot application for managing student data using JPA (Java Persistence API) with a MySQL database. Here's a breakdown of the key components:
