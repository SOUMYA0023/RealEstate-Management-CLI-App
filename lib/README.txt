MySQL JDBC Driver Setup
========================

This directory is for storing the MySQL JDBC driver JAR file.

DOWNLOAD INSTRUCTIONS:
----------------------
1. Download the MySQL Connector/J JAR file from:
   https://dev.mysql.com/downloads/connector/j/

2. Choose "Platform Independent" version

3. Download the ZIP archive

4. Extract the JAR file (mysql-connector-j-X.X.X.jar) from the archive

5. Copy the JAR file to this directory (lib/)

ALTERNATIVE - Using Maven:
--------------------------
The project is already configured with Maven to automatically download 
the MySQL driver. Simply run:

   mvn clean compile

Maven will download all dependencies including the MySQL driver.

CLASSPATH SETUP (If using lib directory):
------------------------------------------
When compiling manually, include the JAR in your classpath:

   javac -cp "lib/*;src" -d target src/main/java/com/realestate/**/*.java

When running:

   java -cp "target;lib/*" com.realestate.main.RealEstateApp

Note: The run.bat script is already configured to use the lib directory.
