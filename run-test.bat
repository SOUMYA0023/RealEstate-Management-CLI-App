@echo off
echo Compiling and running the TestDAOs program...
mvn compile exec:java -Dexec.mainClass="com.realestate.main.TestDAOs"
pause