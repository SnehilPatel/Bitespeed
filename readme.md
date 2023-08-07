

```markdown
# Bitespeed Contact Management System

The Bitespeed Contact Management System is a Spring Boot application designed to manage customer contact information and relationships. It provides an endpoint for identifying and tracking customers' contacts across multiple purchases.

## Table of Contents

- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Usage](#usage)
  - [Running the Application](#running-the-application)
  - [API Endpoint](#api-endpoint)
  - [Accessing H2 Database Console](#accessing-h2-database-console)
- [Sample Data](#sample-data)
- [Contributing](#contributing)
- [License](#license)

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Maven (for building the project)
- An IDE of your choice (IntelliJ IDEA, Eclipse, etc.)

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/bitespeed-contact-management.git
   ```

2. Open the project in your preferred IDE.

3. Build the project using Maven:

   ```bash
   mvn clean install
   ```

## Usage

### Running the Application

1. Run the Spring Boot application using Maven:

   ```bash
   mvn spring-boot:run
   ```

2. The application will start, and you can access it at http://localhost:8080.

### API Endpoint

The application exposes an endpoint for identifying and consolidating customer contacts:

- Endpoint: POST http://localhost:8080/identify
- Request Body (JSON):
  ```json
  {
    "email": "sample@example.com",
    "phoneNumber": "1234567890"
  }
  ```

  This endpoint will return a JSON response with consolidated contact information.

### Accessing H2 Database Console

The H2 Database Console is accessible for development and testing purposes. Follow these steps to access it:

1. Open a web browser and go to http://localhost:8080/h2-console.
2. Enter the following details:
   - Driver Class: org.h2.Driver
   - JDBC URL: jdbc:h2:mem:testdb
   - User Name: sa
   - Password: (Leave it blank)
3. Click "Connect" to access the H2 Database Console.

## Sample Data

The application automatically inserts sample data into the database during startup for demonstration purposes.

## Contributing

Contributions are welcome! If you find a bug or want to add a new feature, please submit an issue or a pull request.
