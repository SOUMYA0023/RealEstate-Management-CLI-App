@echo off
setlocal

REM Run the Real Estate Management System

REM Check if MySQL connector JAR exists
if not exist "lib\mysql-connector-j-9.5.0.jar" (
    echo MySQL connector JAR not found. Please download it and place it in the lib directory.
    echo You can download it from: https://dev.mysql.com/downloads/connector/j/
    pause
    exit /b 1
)

REM Compile the Java files if not already compiled
if not exist "target\classes" (
    echo Compiling Java files...
    mkdir target\classes
    javac -d target\classes -cp "lib\mysql-connector-j-9.5.0.jar;." src\main\java\com\realestate\model\Property.java src\main\java\com\realestate\util\DBConnection.java src\main\java\com\realestate\dao\PropertyDAO.java src\main\java\com\realestate\main\RealEstateApp.java
)

REM Run the application
echo Starting Real Estate Management System...
java -cp "target\classes;lib\mysql-connector-j-9.5.0.jar;." com.realestate.main.RealEstateApp

pause