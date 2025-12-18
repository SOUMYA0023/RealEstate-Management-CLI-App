@echo off
echo Force pushing to main branch...
echo ===========================

echo Changing to project directory...
cd /d "c:\Users\thars\Downloads\RealEstate-Management-CLI-App-main\RealEstate-Management-CLI-App-main"

echo Current directory:
cd

echo Setting up Git identity...
git config --global user.email "tharshanrs00@gmail.com"
git config --global user.name "THARSHAN719"

echo Adding all files...
git add .

echo Committing changes...
git commit -m "Add appointment and payment DAOs with full CRUD operations for Real Estate Management System"

echo Setting remote origin to SOUMYA0023 repository...
git remote set-url origin https://github.com/SOUMYA0023/RealEstate-Management-CLI-App.git

echo Force pushing to main branch...
git push --force-with-lease origin main

echo Done! Changes have been pushed to the main branch.
pause