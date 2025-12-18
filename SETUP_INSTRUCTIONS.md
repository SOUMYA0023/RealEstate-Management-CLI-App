# Real Estate Management System - Setup Instructions

## Project Overview

This is a console-based Java application for managing real estate properties with MySQL database integration. The application provides a complete CRUD interface for property management through a command-line interface.

## Project Structure

```
RealEstate Management/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── realestate/
│                   ├── model/
│                   │   └── Property.java
│                   ├── dao/
│                   │   └── PropertyDAO.java
│                   ├── util/
│                   │   └── DBConnection.java
│                   └── main/
│                       ├── RealEstateApp.java
│                       ├── TestConnection.java
├── lib/
├── target/
│   └── classes/
├── pom.xml
├── README.md
├── run.sh
├── run.bat
└── SETUP_INSTRUCTIONS.md
```

## Prerequisites

1. Java JDK 8 or higher installed
2. MySQL Server installed and running
3. MySQL Connector/J (JDBC Driver)

## Database Setup

Since you've already created the database and table, ensure your database has the following structure:

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

Replace `your_mysql_username` and `your_mysql_password` with your actual MySQL credentials.

## MySQL Connector Installation

To run this application, you need the MySQL Connector/J JDBC driver:

1. Download the MySQL Connector/J from: https://dev.mysql.com/downloads/connector/j/
2. Choose the "Platform Independent" option
3. Download the ZIP archive
4. Extract the `mysql-connector-j-9.5.0.jar` file
5. Place it in the `lib/` directory of this project

## Running the Application

### Option 1: Using the provided scripts

#### On macOS/Linux:
```bash
./run.sh
```

#### On Windows:
```cmd
run.bat
```

### Option 2: Manual compilation and execution

1. Compile the Java files:
   ```bash
   javac -d target/classes -cp "lib/mysql-connector-java-8.0.33.jar:." src/main/java/com/realestate/model/Property.java src/main/java/com/realestate/util/DBConnection.java src/main/java/com/realestate/dao/PropertyDAO.java src/main/java/com/realestate/main/RealEstateApp.java
   ```

2. Run the application:
   ```bash
   java -cp "target/classes:lib/mysql-connector-java-8.0.33.jar:." com.realestate.main.RealEstateApp
   ```

## Features

Once the application is running, you can:

1. Add new properties
2. View all properties
3. Search properties by location
4. Search properties by status (Available, Sold, Rented)
5. Update property price
6. Update property status
7. Delete properties
8. Exit the application

## Troubleshooting

### ClassNotFoundException: com.mysql.cj.jdbc.Driver

This error occurs when the MySQL Connector/J is not in the classpath. Ensure you have downloaded the MySQL Connector/J and placed it in the `lib/` directory.

### Connection Refused

This error occurs when the application cannot connect to the MySQL server. Check that:
1. MySQL server is running
2. The database credentials in `DBConnection.java` are correct
3. The database name is "RealEstate" and the table "properties" exists

## License

This project is for educational purposes only.