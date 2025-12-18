# Database Structure Reference

This document provides a reference for the database tables used in the Real Estate Management System.

## Database: RealEstate

### Table: properties
```sql
CREATE TABLE properties (
    property_id INT PRIMARY KEY AUTO_INCREMENT,
    property_name VARCHAR(255),
    location VARCHAR(255),
    area_sqft INT,
    price DOUBLE,
    status VARCHAR(50),  -- Available, Sold, Rented
    property_type VARCHAR(100)
);
```

### Table: owners
```sql
CREATE TABLE owners (
    owner_id INT PRIMARY KEY AUTO_INCREMENT,
    owner_name VARCHAR(255),
    email VARCHAR(255),
    phone VARCHAR(20),
    address TEXT
);
```

### Table: customers
```sql
CREATE TABLE customers (
    customer_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_name VARCHAR(255),
    email VARCHAR(255),
    phone VARCHAR(20),
    address TEXT
);
```

### Table: agents
```sql
CREATE TABLE agents (
    agent_id INT PRIMARY KEY AUTO_INCREMENT,
    agent_name VARCHAR(255),
    email VARCHAR(255),
    phone VARCHAR(20),
    specialization VARCHAR(255)  -- Residential, Commercial, etc.
);
```

### Table: transactions
```sql
CREATE TABLE transactions (
    transaction_id INT PRIMARY KEY AUTO_INCREMENT,
    property_id INT,
    customer_id INT,
    agent_id INT,
    transaction_type VARCHAR(50),  -- Sale, Rent, Lease
    transaction_amount DOUBLE,
    transaction_date DATE,
    FOREIGN KEY (property_id) REFERENCES properties(property_id),
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id),
    FOREIGN KEY (agent_id) REFERENCES agents(agent_id)
);
```

## DAO Classes

Each table has a corresponding DAO (Data Access Object) class:

- **PropertyDAO.java** - Manages property records
- **OwnerDAO.java** - Manages owner records
- **CustomerDAO.java** - Manages customer records
- **AgentDAO.java** - Manages agent records
- **TransactionDAO.java** - Manages transaction records

## Common DAO Methods

Each DAO provides the following standard operations:

1. **add[Entity]()** - Insert a new record
2. **getAll[Entities]()** - Retrieve all records
3. **get[Entity]ById()** - Retrieve a specific record by ID
4. **update[Entity]()** - Update an existing record
5. **delete[Entity]()** - Delete a record
6. **searchBy...()** - Search records based on specific criteria

## Connection Details

- **Database:** RealEstate
- **Username:** root
- **Password:** Neh@2005
- **Host:** localhost
- **Port:** 3306
