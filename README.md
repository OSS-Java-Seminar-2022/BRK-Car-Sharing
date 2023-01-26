# **BRK-Car-Sharing**

This project demonstrates a simple car sharing web application.

<img width="1005" alt="image" src="https://user-images.githubusercontent.com/66143573/194909254-e7dfcbc3-6f2e-4005-bd94-1fbb23877168.png">


## Table of contents

  - [Project Information](#Project-information)
  - [Features](#Features)
  - [Database Model](Database-model)
  - [Tech stack](Tech-stack)
  - [Authors](Authors)

### Project information
This is a project made for the "Programming in Java" course on the University of Split. It attempts to demonstrate a simple car sharing application and the way it works. It was developed under the [Authors](Authors) mentioned below.
To start the application a docker container must be ran that contains the paramaters from the docker-compose file. To set it up, download Docker desktop for your system and run the container with:

    $ docker-compose up
    
For development purposes it can be ran from the command line in the root folder(CarShare)

    $ mvn spring-boot:run
 
### Features

- Account Management
  - User registration and login
  - User roles defined by account type (personal, business, admin)
  - User defined settings
        
- Car Reservation
  - Locate nearest available vehicles
  - Reserve vehicle
  - Navigate customer to vehicle

- Admin panel
  - Manage users
  - Manage vehicle availability (available, in service, in cleaning, etc.)

- Subscription model
  - Card payment
  - Tiered system (limited vehicles and services)
  - Down payment


## Database model

![Database model](https://user-images.githubusercontent.com/66143573/196203348-56621f9f-ae6e-4445-88d3-98d83fb44332.jpg)



## Tech stack

- Java
- Spring Boot
- Thymeleaf
- Vue.js
- Javascript
- HTML 5
- CSS 3
- Bootstrap
- Docker
- MongoDB
- RabbitMQ


### Authors
Bruno Bule [@bb00le](https://www.github.com/bb00le)

Roko Đugum [@reactst](https://www.github.com/reactst)

Karlo Rešetar [@karloresetar](https://github.com/karloresetar)
