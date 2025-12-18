@echo off
echo Pushing to Main Branch
echo ====================

REM Fetch the latest changes from remote
echo Fetching latest changes from remote repository...
"C:\Program Files\Git\bin\git.exe" fetch origin

REM Reset local master to match remote main
echo Resetting local master to match remote main...
"C:\Program Files\Git\bin\git.exe" reset --hard origin/main

REM Add all files
echo Adding all files...
"C:\Program Files\Git\bin\git.exe" add .

REM Commit changes
echo Committing changes...
"C:\Program Files\Git\bin\git.exe" commit -m "Update Real Estate Management System with AmenityDAO and enhanced features"

REM Push to main branch
echo Pushing to main branch...
"C:\Program Files\Git\bin\git.exe" push origin HEAD:main

if %errorlevel% equ 0 (
    echo.
    echo SUCCESS! Your code has been pushed to the main branch.
    echo Visit https://github.com/SOUMYA0023/RealEstate-Management-CLI-App to see your updated repository.
) else (
    echo.
    echo FAILED to push to main branch.
    echo Please check your internet connection and GitHub credentials.
)

pause