@echo off
cls
echo Compiling Java files...
javac Main\OrganizationApp.java model\*.java exceptions\*.java

if %errorlevel% neq 0 (
    echo Compilation failed. Please fix the errors.
    pause
    exit /b
)

echo.
echo Running program...
echo --------------------
java Main.OrganizationApp

echo.
pause
