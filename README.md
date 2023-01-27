# **BRK-Car-Sharing**

This project demonstrates a simple car sharing web application.

<img width="1277" alt="image" src="https://user-images.githubusercontent.com/66143573/215118541-db320361-8fc8-4f8b-a325-b7443d3e7d5a.png">



## Table of contents

  - [Project Information](#Project-information)
  - [Features](#Features)
  - [Database Model](Database-model)
  - [Tech stack](Tech-stack)
  - [Authors](Authors)

### Project information
This is a project made for the "Programming in Java" course on the University of Split. It attempts to demonstrate a simple car sharing application and the way it works. It was developed under the [Authors](Authors) mentioned below.
 
### Features

- Account Management
  - User registration and login
  - User roles defined by subscription tier (basic, standard, premium)
  - User defined settings
    - day/night mode
    - Account self management (through Keycloak)
        
- Car Reservation
  - Locate nearest available vehicles
  - Reserve vehicle
  - Unlock vehicle via NFC

- Admin panels
  - Manage users (through Keycloak)
  - Manage vehicle availability (available, in service, in cleaning, etc.)

- Subscription model
  - Tiered system (limited vehicles and services)


## Database model

![Database model](https://user-images.githubusercontent.com/66143573/215121307-e67fd36e-d955-4659-b39c-c12fb91a1bf0.png)


## Tech stack

- Java
- Spring Boot
- Thymeleaf
- Vue.js
- Javascript
- HTML 5
- CSS 3
- Vueitfy
- Docker
- MongoDB
- Keycloak


## Authors

Bruno Bule [@bb00le](https://www.github.com/bb00le)

Roko Đugum [@reactst](https://www.github.com/reactst)

Karlo Rešetar [@karloresetar](https://github.com/karloresetar)
