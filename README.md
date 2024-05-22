# Simple LLD Voting System

This project is a simple Voting System implemented using Spring Boot. The application allows users to save persons, check their voting eligibility, display all persons, vote, delete persons, and exit the system.

## Features

1. Save Person
2. Check Voting Eligibility
3. Display All Persons
4. Vote
5. Delete Person
6. Exit

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven
- A database (e.g., H2, MySQL, PostgreSQL)

### Installing

1. **Clone the repository:**
    ```bash
    git clone https://github.com/yourusername/simple-voting-system.git
    cd simple-voting-system
    ```

2. **Configure the database:**

    Update the `application.properties` file with your database configurations.

    ```properties
    spring.datasource.url=jdbc:h2:mem:testdb
    spring.datasource.driverClassName=org.h2.Driver
    spring.datasource.username=sa
    spring.datasource.password=password
    spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
    spring.h2.console.enabled=true
    ```

3. **Build the project:**
    ```bash
    mvn clean install
    ```

4. **Run the application:**
    ```bash
    mvn spring-boot:run
    ```

## Usage

Once the application is running, you can interact with it using the console. The following options are available:

```text
[1] for save person
[2] for checking eligibility
[3] for display
[4] for Voting
[5] to delete
[6] for exit
