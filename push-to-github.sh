#!/bin/bash
echo "Pushing changes to GitHub repository..."
echo "======================================"

echo "Changing to project directory..."
cd "c:\Users\thars\Downloads\RealEstate-Management-CLI-App-main\RealEstate-Management-CLI-App-main"

echo "Current directory:"
pwd

echo "Checking Git status..."
git status

echo "Adding all files..."
git add .

echo "Committing changes..."
git commit -m "Add appointment and payment DAOs with full CRUD operations for Real Estate Management System"

echo "Checking current branch..."
git branch

echo "Setting remote origin..."
git remote set-url origin https://github.com/SOUMYA0023/RealEstate-Management-CLI-App.git

echo "Pushing to GitHub..."
git push -u origin main

echo "If the above failed due to branch name, trying master..."
git push -u origin master

echo "Done!"