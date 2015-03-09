![REST](https://github.com/reshetnev/RestFull/blob/master/logo/RESTful.jpg)

Representational State Transfer (REST) is a style of software architecture
for distributed systems such as the World Wide Web.
RESTful Web services is great way to achieve this architecture.


![Jax-RS](https://github.com/reshetnev/RestFull/blob/master/logo/Jax-RS.jpg)


Java API for RESTful Web Services (JAX-RS) is a Java programming language API
that provides support in creating web services according to the
Representational State Transfer (REST) architectural pattern.


![Jersey](https://github.com/reshetnev/RestFull/blob/master/logo/Jersey.jpg)

Jersey RESTful Web Services framework is an open source, production quality,
framework for developing RESTful Web Services in Java that provides support for
JAX-RS APIs.


![Spring](https://github.com/reshetnev/RestFull/blob/master/logo/spring.jpg)

The Spring Framework is an open source application framework
and inversion of control container for the Java platform.

## RESTful API HTTP Methods

GET /users - Get the collection (list the users).

GET /users/{userId} - Retrieve a representation of the user of the collection (list the users).

POST /users - Create a new entry (user) in the collection (list the users).

PUT /users/{userId} - Update the user of the collection (list the users).

DELETE /users/{userId} - Delete the user of the collection (list the users).

### Response Code Status

200 — Successful;
201 - Successful created;
400 - Not validated;
401 — Not Authorized;
403 — Forbidden;
404 — Not Found;
500 — Server error during operation.