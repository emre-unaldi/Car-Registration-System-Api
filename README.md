# `Car Registration System Api`
This backend project was bootstrapped with [Java Spring Boot](https://spring.io)
> **Patika.dev** is a 6-month software training graduation project backend repository

## `Used Technologies`
- JDK 20
- Java 17
- Spring Framework
- Spring Core
- Spring Web
- Spring Data
- Spring Rest
- Spring Boot Dev Tools
- PostreSQL
- Lombok
- Model Mapper
- Swagger
---
## `User Endpoints`
| Route                                     | HTTP     | POST body	                                                                                     | Description	              |
|-------------------------------------------|----------|------------------------------------------------------------------------------------------------|---------------------------|
| /user/add                                 | `POST`   | {"firstName": "string","lastName": "string","username": "string","password": "string"}         | Create a new user.        |
| /user/register                            | `POST`   | {"firstName": "string","lastName": "string","username": "string","password": "string"}         | Create a new user.        |
| /user/update                              | `PUT`    | {"id": 0,"firstName": "string","lastName": "string","username": "string","password": "string"} | Update a user.            |
| /user/delete/{id}                         | `DELETE` | Empty                                                                                          | Delete a user.            |
| /user/login                               | `POST`   | {"username": "string","password": "string"}                                                    | User login.               |
| /user/changepassword                      | `POST`   | {"username": "string","oldPassword": "string","newPassword": "string"}                         | Changing user password.   |
---
## `Car Endpoints`
| Route                    | HTTP     | POST body	                                                                                               | Description	        |
|--------------------------|----------|----------------------------------------------------------------------------------------------------------|---------------------|
| /car/add                 | `POST`   | {"name": "string","plaque": "string","model": "string","brand": "string","year": 0,"userId": 0}          | Create a new car.   |
| /car/update              | `PUT`    | {"id": 0,"name": "string","plaque": "string","model": "string","brand": "string","year": 0,"userId": 0 } | Update a car.       |
| /car/delete/{id}         | `DELETE` | Empty                                                                                                    | Delete a car.       |
| /car/getAll              | `GET`    | Empty                                                                                                    | List cars.          |
| /car/getcarbyid/{id}     | `GET`    | Empty                                                                                                    | Get car by id.      |
| /car/getcarbyuserid/{id} | `GET`    | Empty                                                                                                    | Get car by user id. |


