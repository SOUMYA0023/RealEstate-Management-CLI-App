@echo off
setlocal

REM Run the Real Estate Management System

REM Check if MySQL connector JAR exists (check for any version)
set MYSQL_JAR=
for %%f in (lib\mysql-connector-*.jar) do set MYSQL_JAR=%%f

if "%MYSQL_JAR%"=="" (
    echo MySQL connector JAR not found in lib directory.
    echo Please download it from: https://dev.mysql.com/downloads/connector/j/
    echo Or run: mvn clean compile (to use Maven dependencies)
    pause
    exit /b 1
)

REM Compile the Java files if not already compiled
if not exist "target\classes" (
    echo Compiling Java files...
    mkdir target\classes
    javac -d target\classes -cp "%MYSQL_JAR%;." src\main\java\com\realestate\model\*.java src\main\java\com\realestate\util\*.java src\main\java\com\realestate\dao\*.java src\main\java\com\realestate\main\*.java
)

REM Run the application
echo Starting Real Estate Management System...
java -cp "target\classes;%MYSQL_JAR%;." com.realestate.main.RealEstateApp

pause