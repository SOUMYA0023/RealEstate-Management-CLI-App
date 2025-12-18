@echo off
echo Setting up Git and pushing changes to GitHub repository...
echo ========================================================

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

echo Checking current branch...
git branch

echo If no branch exists, creating main branch...
git branch -M main

echo Setting remote origin...
git remote set-url origin https://github.com/SOUMYA0023/RealEstate-Management-CLI-App.git

echo Pushing to GitHub...
git push -u origin main

echo Done!
pause