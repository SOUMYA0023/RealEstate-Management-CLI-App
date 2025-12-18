# Real Estate Management System

A console-based Java application for managing real estate properties with MySQL database integration.

## Features

- Add new properties
- View all properties
- Search properties by location
- Search properties by status
- Update property price
- Update property status
- Delete properties

## Tech Stack

- Java (Core Java)
- JDBC
- MySQL

## Project Structure

```
src/
├── main/
│   └── java/
│       └── com/
│           └── realestate/
│               ├── model/
│               │   └── Property.java
│               ├── dao/
│               │   └── PropertyDAO.java
│               ├── util/
│               │   └── DBConnection.java
│               └── main/
│                   └── RealEstateApp.java
```

## Database Setup

1. Create a MySQL database named `RealEstate`
2. Ensure there is a table named `properties` with the following structure:

```sql
CREATE TABLE properties (
    property_id INT AUTO_INCREMENT PRIMARY KEY,
    property_name VARCHAR(255) NOT NULL,
    location VARCHAR(255) NOT NULL,
    area DOUBLE NOT NULL,
    price DOUBLE NOT NULL,
    status VARCHAR(50) NOT NULL
);
```

## Configuration

The database credentials have already been configured in `src/main/java/com/realestate/util/DBConnection.java` as:

```java
private static final String URL = "jdbc:mysql://localhost:3306/RealEstate?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
private static final String USERNAME = "root";
private static final String PASSWORD = "Root@1234";
```

## Build and Run

1. Compile the project:
   ```
   mvn compile
   ```

2. Run the application:
   ```
   mvn exec:java -Dexec.mainClass="com.realestate.main.RealEstateApp"
   ```

   Or run directly with Java:
   ```
   java -cp target/classes:target/dependency/* com.realestate.main.RealEstateApp
   ```

## Usage

The application provides a menu-driven interface for all property management operations. Simply run the application and follow the on-screen prompts.

## License

This project is for educational purposes only.