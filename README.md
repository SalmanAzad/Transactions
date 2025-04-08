# Transactions API
This project provides a RESTful API for creating transactions for given customer and retrieving all transaction for a given customer using a microservices architecture.

### ToDo
This service for now acts as supporting service for Accounts. It does not have full implementation.
It is supposed to create transaction and store it into a database table. 
Similarly, while retrieving transactions for a given customer it should read from database table.
It lacks following implementation due to limited time.
* Database
* Unit and Integration test

### API Endpoints
* POST /v1/transactions/create
* GET /v1/transactions/customerId/{customerId}

### Run Account API
    ./mvnw clean install
    ./mvnw spring-boot:run

### Swagger UI
    http://localhost:8091/swagger-ui.html
