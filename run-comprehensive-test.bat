@echo off
echo Compiling and running the ComprehensiveTest program...
javac -cp "lib/*" -d target/classes src/main/java/com/realestate/model/*.java src/main/java/com/realestate/dao/*.java src/main/java/com/realestate/util/*.java src/main/java/com/realestate/main/ComprehensiveTest.java
java -cp "target/classes;lib/*" com.realestate.main.ComprehensiveTest
pause