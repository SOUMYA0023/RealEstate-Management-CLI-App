@echo off
setlocal

REM Run the Real Estate Management System

<<<<<<< HEAD
REM Check if MySQL connector JAR exists
if not exist "lib\mysql-connector-j-9.5.0.jar" (
    echo MySQL connector JAR not found. Please download it and place it in the lib directory.
    echo You can download it from: https://dev.mysql.com/downloads/connector/j/
=======
REM Check if MySQL connector JAR exists (check for any version)
set MYSQL_JAR=
for %%f in (lib\mysql-connector-*.jar) do set MYSQL_JAR=%%f

if "%MYSQL_JAR%"=="" (
    echo MySQL connector JAR not found in lib directory.
    echo Please download it from: https://dev.mysql.com/downloads/connector/j/
    echo Or run: mvn clean compile (to use Maven dependencies)
>>>>>>> 0007f3b875f7bb1a984c811527c73b9ac1106477
    pause
    exit /b 1
)

REM Compile the Java files if not already compiled
if not exist "target\classes" (
    echo Compiling Java files...
    mkdir target\classes
<<<<<<< HEAD
    javac -d target\classes -cp "lib\mysql-connector-j-9.5.0.jar;." src\main\java\com\realestate\model\Property.java src\main\java\com\realestate\util\DBConnection.java src\main\java\com\realestate\dao\PropertyDAO.java src\main\java\com\realestate\main\RealEstateApp.java
=======
    javac -d target\classes -cp "%MYSQL_JAR%;." src\main\java\com\realestate\model\*.java src\main\java\com\realestate\util\*.java src\main\java\com\realestate\dao\*.java src\main\java\com\realestate\main\*.java
>>>>>>> 0007f3b875f7bb1a984c811527c73b9ac1106477
)

REM Run the application
echo Starting Real Estate Management System...
<<<<<<< HEAD
java -cp "target\classes;lib\mysql-connector-j-9.5.0.jar;." com.realestate.main.RealEstateApp
=======
java -cp "target\classes;%MYSQL_JAR%;." com.realestate.main.RealEstateApp
>>>>>>> 0007f3b875f7bb1a984c811527c73b9ac1106477

pause