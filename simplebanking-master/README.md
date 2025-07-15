# 💳 Simple Banking API

A lightweight banking application developed as part of the Eteration Backend Developer Assessment. The system allows users to create accounts, deposit and withdraw funds, and retrieve account details.

---

## 🧰 Technologies Used

- Java 11
- Spring Boot 2.5.6
- Mockito (Unit testing)
- Gradle
- Jakarta Validation API

---

## 🚀 Getting Started

### ✅ Requirements

- Java 11+
- Gradle
- IDE (IntelliJ, VSCode, etc.)
- Postman (optional, for API testing)

---

### 🔧 How to Run the Project

```bash
# Navigate to the project directory
cd simplebanking-master

# Build the project (includes tests)
./gradlew clean build

# Start the application
./gradlew bootRun


# Simple Banking Application – Eteration Java Assignment

A simple Java Spring Boot project simulating core banking functionalities such as creating accounts, depositing, withdrawing, and querying transaction history. Built as part of a backend engineering assignment.

---

## ✨ Features

* In-memory account storage (no database dependency)
* Create new accounts
* Credit (deposit) to an account
* Debit (withdraw) from an account with insufficient balance handling
* Query account details including transaction history
* API-based architecture with clean separation of controller-service-model layers

---

## 🚀 Getting Started

### Requirements:

* Java 11+
* Gradle
* Postman (for testing REST endpoints)

### 1. Clone the Project

```bash
git clone https://github.com/your-repo/simple-banking.git
cd simple-banking
```

### 2. Build & Run

```bash
./gradlew clean build
./gradlew bootRun
```

Spring Boot will start the application on: `http://localhost:8080`

---

## 🔧 API Endpoints

### Create a New Account

```http
POST /account/v1/create?owner={ownerName}&accountNumber={accountNumber}
```

### Get Account Details

```http
GET /account/v1/{accountNumber}
```

### Credit (Deposit) to Account

```http
POST /account/v1/credit/{accountNumber}
Content-Type: application/json
Body: { "amount": 1000.0 }
```

### Debit (Withdraw) from Account

```http
POST /account/v1/debit/{accountNumber}
Content-Type: application/json
Body: { "amount": 500.0 }
```

---

## 🔹 Project Architecture

* `controller/` : Exposes REST APIs
* `services/`   : Core logic for credit, debit, and account handling
* `model/`      : Account and transaction domain models
* `dto/`        : DTOs for data transfer
* `test/`       : JUnit 5 + Mockito based unit tests

---

## 🔍 Why No Repository or JPA?

To keep the project lightweight, fast to build, and simple to evaluate, all data is stored **in-memory using a `HashMap`**.

This avoids the complexity of database configuration, Hibernate/JPA setup, and allows easy testability. In a production setting, the `AccountService` would delegate persistence to a proper `AccountRepository` interface backed by JPA or another data access layer.

---

## 🌐 Postman Test Screenshots

### 1. Create New Account

![Create Account](/images/createNewAccountAPI.png)

### 2. Credit to Account

![Credit](/images/creditToAccount.png)

### 3. Debit from Account

![Debit](/images/debitFromAccount.png)

### 4. Account Details (via Browser)

![Details - Browser](/images/detailsWithBrowser.png)

### 5. Get Account Details

![Details - Postman](/images/getDetailsOfAccount.png)

---

## 🌟 Author

**Mehmet Veysel Işıktaş**
[LinkedIn](https://www.linkedin.com/in/veyselskts/)


