# Product-Client API

This project implements a robust RESTful API using Java, meticulously designed with object-oriented programming (OOP) principles and a clean layered architecture. Leveraging modern Java capabilities and best practices, the API facilitates secure client registration and authentication, comprehensive product lifecycle management, and dynamic tax calculation based on product pricing. The architecture ensures maintainability, scalability, and separation of concerns by clearly delineating responsibilities across Controller, Service, and Repository layers.

---

## Features

- Client registration and authentication
- Create, list, update, and delete products
- Tax calculation based on product price
- Layered architecture (Controller, Service, Repository)
- Designed with Java OOP principles for maintainability and scalability

---

# API Endpoints

## Client Operations

### 1. Register Client

- **Method:** `POST`
- **URL:** `/api/v1/client/register`
- **Description:** Registers a new client.
- **Sample Request Body:**

```json
{
  "username": "lamborghini",
  "password": "lamborghini123"
}
```
### 2. Create Product

- **Method:** `POST`
- **URL:** `/api/v1/product/create`
- **Description:** Creates a new product.
- **Sample Request Body:**

```json
{
    "name": "Cell Phone",
    "price": 1200.0,
    "client": {
        "id": 6
    }
}
```

### 3. List All Products

- **Method:** `GET`
- **URL:** `/api/v1/product/all`
- **Description:** Lists all products in the system.
- **Sample Request Body:**

```json
[
    {
        "name": "Book",
        "price": 12.43
    },
    {
        "name": "Table",
        "price": 50.86
    }
] 
```

### 4. List Products by Client

- **Method:** `GET`
- **URL:** `/api/v1/product/all/{clientId}`
- **Description:** Lists all products that belong to the specified client ID.
- **Sample Request Body:**

```json
[
    {
        "name": "Ferruccio's Book",
        "price": 50.86
    }
]
```
### 5. Update Product

- **Method:** PUT  
- **Endpoint:** `/api/v1/product/update/{productId}`  

- **Description:**  Updates the product identified by `{productId}`. The request must be made by the client who owns the product.

- **Request Body:**

```json
{
  "client_id": 6,
  "productDto": {
    "name": "Sf90 Wheel",
    "price": 500.0
  }
}
```

### 6. Delete Product

- **Method:** DELETE  
- **Endpoint:** `/api/v1/product/delete/{productId}`  

- **Description:**  Deletes the product identified by `{productId}`. The request must be made by the client who owns the product.

- **Request Body:**

```json
{
  "client_id": 6
}
```

### 7. Calculate Product Tax

- **Method:** GET  
- **Endpoint:** `/api/v1/product/tax?productId={productId}`  

- **Description:**  
Calculates the tax amount for the product specified by `productId` based on its price.

- **Example:**  
`/api/v1/product/tax?productId=3`

- **Tax Calculation Rules:**  

| Price Range        | Tax Rate |
|--------------------|----------|
| Price ≤ 100        | 10%      |
| 100 < Price ≤ 500  | 15%      |
| 500 < Price ≤ 1000 | 18%      |
| Price > 1000       | 25%      |

### 8. Client Authentication

- **Method:** POST  
- **Endpoint:** `/api/v1/client/auth`

- **Description:**  
Authenticates a client using their username and password.

- **Request Body Example:**

```json
{
  "username": "ferrari",
  "password": "ferrari123"
}
```


## 🚀 Features

- Client registration and authentication
- Product CRUD operations
- Dynamic tax calculation
- Clean layered architecture (Controller, Service, Repository)
- PostgreSQL database integration
- Secure and scalable design

---

## 🛠️ Build & Run

### ✅ Requirements

- Java 17+  
- Maven 3.8+  
- PostgreSQL (for database connection)  
- Spring Tool Suite (STS) or any Java IDE (IntelliJ, Eclipse)

---

### ⚙️ Setup

#### 1. Clone the repository

```bash
git clone https://github.com/your-username/taxup.git
cd taxup
```


## ⚙️ Configuration

Before running the project, make sure to configure the database and any necessary environment variables.

### 🔧 `application.properties`

Located at:  
`src/main/resources/application.properties`

Update the following fields according to your PostgreSQL setup:

```properties
# Database Configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/taxup
spring.datasource.username=postgres
spring.datasource.password=test123

# JPA & Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# Optional: Custom Server Port
# server.port=8080
```
## ▶️ How to Run the Project

You can run this Spring Boot project either through **Spring Tool Suite (STS)** or the terminal.

---

### 🖥️ Option 1: Run with Spring Tool Suite (STS)

1. Open **Spring Tool Suite**
2. Go to **File > Import > Existing Maven Projects**
3. Select the cloned `taxup` project folder
4. Wait for dependencies to download and indexing to complete
5. In the `src/main/java` directory, locate `TaxupApplication.java`
6. Right-click on `TaxupApplication.java` → **Run As > Spring Boot App**

---

### 💻 Option 2: Run via Terminal

Make sure you have Java and Maven installed.

#### Build and Run:

```bash
./mvnw spring-boot:run


