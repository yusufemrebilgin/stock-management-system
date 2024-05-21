# Stock Management System

This project is a Stock Management System developed using Spring MVC, Spring Security, Thymeleaf, MySQL, Java, and Maven. The system allows users to log in with role-based access, where both admins and regular users can exchange messages with each other. Additionally, the status of the stock is dynamically displayed to the user.

## Features

- **Role-Based Authentication:** Users can log in with different roles such as admin or regular user.

- **Messaging System:** Admins and users can send and receive messages to each other within the system.

- **Dynamic Stock Status:** The status of the stock is dynamically updated and displayed to the user on the login page.

## Technologies Used

- **Spring MVC:** Used for building the web application and handling HTTP requests.

- **Spring Security:** Implemented for securing the application and managing user authentication and authorization.

- **Thymeleaf:** Employed as the templating engine for server-side rendering of HTML templates.

- **MySQL:** Used as the database management system to store application data.

- **Java:** Programming language used for backend development.

- **Maven:** Utilized as the build automation tool and dependency management.

## How to Run

1.  **Clone the project** from GitHub or download it as a zip file and extract it to your computer.

2.  Open a terminal or command prompt and **navigate to the root directory** of the project.

3.  **Configure MySQL database settings** in `src/main/resources/application.properties`

4.  After configuring database, **use the Maven Wrapper to compile the project** and download dependencies. Use the following commands to compile the project:

    ```sh
    ./mvnw clean install
    ```

5.  After Maven compiles the project and downloads necessary dependencies, you can **start the application** by using the following command:

    ```sh
    ./mvnw spring-boot:run
    ```

6.  Once the app is running, open a web browser and navigate to `http://localhost:7070` to access the application.

## Database Initialization

The application uses `schema.sql` and `data.sql` scripts to initialize the database schema and load initial data. If the database already exists, it will drop the existing tables and recreate them.

## Sample Users

Here are some sample users that you can use to log in to the application:

| Username | Password |
|----------|----------|
| admin    | admin123 |
| user     | user123  |

## Images

<p align="center">
    <img src="https://github.com/yusufemrebilgin/stock-management-system/blob/main/images/login-page.png">
    <img src="https://github.com/yusufemrebilgin/stock-management-system/blob/main/images/index-page.png">
</p>