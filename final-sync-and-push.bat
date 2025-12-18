@echo off
echo Final sync and push to GitHub repository...
echo ==========================================

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

echo Fetching changes from remote repository...
git fetch origin

echo Pulling changes from remote repository...
git pull --allow-unrelated-histories origin main

echo If there were conflicts, please resolve them manually, then run:
echo git add .
echo git commit -m "Merge changes"
echo git push -u origin main

echo If there were no conflicts, pushing to GitHub...
git push -u origin main

echo Done!
pause