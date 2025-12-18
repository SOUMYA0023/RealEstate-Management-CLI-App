@echo off
echo Syncing with GitHub repository and pushing changes...
echo ==================================================

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
git pull origin main --allow-unrelated-histories -m "Merge remote tracking branch"

echo Pushing to GitHub...
git push -u origin main

echo Done!
pause