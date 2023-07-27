Hostel Management System 

The Hostel Management System is a Java-based application developed using IntelliJ IDEA. It is designed to streamline hostel operations, enabling staff to manage reservations, room availability, students details, and other essential hostel tasks efficiently. 

## Table of Contents 

- [Installation](#installation)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Dependencies](#dependencies)
- [Contributing](#contributing)
- [Acknowledgments](#acknowledgments) 

## Installation 

Before running the Hostel Management System, ensure you have the following prerequisites: 

- Java Development Kit (JDK) 19 or above installed on your system.
- IntelliJ IDEA IDE (or any Java IDE of your choice) with appropriate plugins. 

Clone the project repository from GitHub using the following command: 

```bash
git clone https://github.com/hanzalanouman/hostel-management-system.git
``` 

## Getting Started 

1. Launch IntelliJ IDEA and open the `hostel-management-system` project.
2. Ensure that the project SDK is set to JDK 19 or above.
3. Build the project using the IDE's build tools or by pressing `Ctrl + F9` (Windows/Linux) or `Cmd + F9` (macOS). 


## Usage 

To run the Hostel Management System, execute the following steps: 

Before running the application, you will need to setup the database.
### Database Setup
You have an option to either use Oracle or MySQL as database clients.
For MySQL, use the overloaded method in DatabaseConnection.java
For Oracle, use default method.

Default parameters for Database setup:
```
dbname: hmspdb
username: hmsdba
password: hms123
```

for MySQL: 

```
dbname: hmsdb
username: hmsdba
password: hms123
```

The JAR files for connecting either database are included in the Code folder. The DDL is also available there.

1. Open the `HMSApplication.java` class in IntelliJ IDEA.
2. Right-click on the `HMSApplication.java` class and choose "Run Main.main()" from the context menu.
3. The application will start, and you will be prompted with a menu to perform various operations. 

## Dependencies 

The Hostel Management System project relies on the following external libraries: 

- JavaFX (for GUI components)
- MySQL Connector/J (for connecting to the database)

or 

- OracleJDBC Driver (for connecting to oracle Database

All dependencies are managed using Maven. They will be automatically downloaded when building the project.


Contributing 

Contributions to the Hostel Management System project are welcome! If you find any issues or have suggestions for improvements, feel free to open an issue or submit a pull request. 

Before making significant changes, please discuss them via issues to ensure they align with the project's goals and standards.




## Acknowledgments 

- [JavaFX Documentation](https://openjfx.io/)
- [MySQL Connector/J Documentation](https://dev.mysql.com/doc/connector-j/en/)
- [JUnit Documentation](https://junit.org/junit5/docs/current/user-guide/)
