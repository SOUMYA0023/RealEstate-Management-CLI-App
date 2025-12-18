#!/bin/bash

# Run the Real Estate Management System

# Check if MySQL connector JAR exists (check for any version)
MYSQL_JAR=$(ls lib/mysql-connector-*.jar 2>/dev/null | head -n 1)

if [ -z "$MYSQL_JAR" ]; then
    echo "MySQL connector JAR not found in lib directory."
    echo "Please download it from: https://dev.mysql.com/downloads/connector/j/"
    echo "Or run: mvn clean compile (to use Maven dependencies)"
    exit 1
fi

# Compile the Java files if not already compiled
if [ ! -d "target/classes" ] || [ -z "$(ls -A target/classes)" ]; then
    echo "Compiling Java files..."
    mkdir -p target/classes
    javac -d target/classes -cp "$MYSQL_JAR:." src/main/java/com/realestate/model/*.java src/main/java/com/realestate/util/*.java src/main/java/com/realestate/dao/*.java src/main/java/com/realestate/main/*.java
fi

# Run the application
echo "Starting Real Estate Management System..."
java -cp "target/classes:$MYSQL_JAR:." com.realestate.main.RealEstateApp