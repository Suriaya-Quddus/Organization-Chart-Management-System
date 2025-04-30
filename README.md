# Organization Chart Management System

This Java-based command-line application allows users to create and manage a hierarchical organization chart using the Composite Design Pattern. The system supports building nested departments and managing employees with features like adding, removing, and visualizing the structure.

## 🔧 Features

- Hardcoded initial organization structure (Top Management + Departments)
- Add a new worker to any existing group
- Remove a worker (bosses cannot be removed)
- Clear CLI interface with validated input
- Proper formatting with indentation and spacing
- Exception handling with user-friendly error messages

## 🧠 Technologies Used

- Java (JDK 17+)
- Composite Design Pattern
- Custom Exceptions
- Command-Line Interface

## 🗂️ Folder Structure

```
OrganizationChartProject/
├── src/
│   ├── Main/
│   │   └── OrganizationApp.java
│   ├── model/
│   │   ├── Component.java
│   │   ├── Group.java
│   │   └── Worker.java
│   └── exceptions/
│       └── InvalidInputException.java
├── run.bat
├── report/
│   ├── thesis_report_2025.docx
│   ├── screenshots/
│   │   ├── initial_structure.png
│   │   ├── after_addition.png
│   │   └── after_removal.png
├── README.md
```

## 🚀 How to Run

1. Navigate to the `src` folder in terminal or PowerShell:
    ```
    cd src
    ```

2. Compile and run manually:
    ```
    javac Main\OrganizationApp.java model\*.java exceptions\*.java
    java Main.OrganizationApp
    ```

3. Or, simply double-click `run.bat` in the root folder to compile and launch.

## 📸 Screenshots

Screenshots showing:
- Initial structure
- After adding a worker
- After removing a worker

See the `/report/screenshots/` folder.

## 📋 Report

The detailed thesis report is available in:
```
/report/thesis_report_2025.docx
```

Includes:
- Architecture & UML
- Implementation details
- Testing evidence
- Work hours log

---

Made with ❤️ for TAMK Software Engineering final project