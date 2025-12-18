#!/bin/bash

# Run the Real Estate Management System

# Check if MySQL connector JAR exists
if [ ! -f "lib/mysql-connector-j-9.5.0.jar" ]; then
    echo "MySQL connector JAR not found. Please download it and place it in the lib directory."
    echo "You can download it from: https://dev.mysql.com/downloads/connector/j/"
    exit 1
fi

# Compile the Java files if not already compiled
if [ ! -d "target/classes" ] || [ -z "$(ls -A target/classes)" ]; then
    echo "Compiling Java files..."
    mkdir -p target/classes
    javac -d target/classes -cp "lib/mysql-connector-j-9.5.0.jar:." src/main/java/com/realestate/model/Property.java src/main/java/com/realestate/util/DBConnection.java src/main/java/com/realestate/dao/PropertyDAO.java src/main/java/com/realestate/main/RealEstateApp.java
fi

# Run the application
echo "Starting Real Estate Management System..."
java -cp "target/classes:lib/mysql-connector-j-9.5.0.jar:." com.realestate.main.RealEstateApp