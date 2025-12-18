@echo off
echo Setting up Git and pushing changes to GitHub repository...
echo ========================================================

echo Changing to project directory...
cd /d "c:\Users\thars\Downloads\RealEstate-Management-CLI-App-main\RealEstate-Management-CLI-App-main"

echo Current directory:
cd

echo Setting up Git identity...
echo Please enter your Git email (e.g., your-email@example.com):
set /p git_email=""
git config --global user.email "%git_email%"

echo Please enter your Git username (e.g., Your Name):
set /p git_username=""
git config --global user.name "%git_username%"

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