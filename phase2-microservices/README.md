# Phase 2 – Microservices Architecture

## 📌 Overview
This phase represents the evolution of the application from a **monolithic architecture** (Phase 1)
to a **microservices-based architecture** using **Spring Cloud**.

Each business domain is extracted into an **independent microservice**, allowing:
- Better scalability
- Independent deployment
- Clear separation of responsibilities

---

## 🏗 Architecture Style
**Microservices Architecture**

The system is composed of:
- A centralized configuration service
- A service discovery mechanism
- An API Gateway
- Multiple domain-based microservices

---

## 🧩 Services Overview

### 1️⃣ Config Server
- Centralized configuration management
- Stores shared configuration for all microservices
- Uses `application.yml` files per service

📌 Port: `8888`

---

### 2️⃣ Eureka Server (Discovery Service)
- Service registry
- Allows services to discover each other dynamically
- Removes hardcoded service URLs

📌 Port: `8761`

---

### 3️⃣ API Gateway
- Single entry point for all client requests
- Routes requests to the appropriate microservice
- Integrates with Eureka for dynamic routing

📌 Port: `8080`

---

### 4️⃣ Dreamer Service
- Manages Dreamer-related operations
- CRUD functionality
- Own database schema

📌 Port: `8083`

---

### 5️⃣ Dream Service
- Manages Dreams
- Linked to Dreamer service via Dreamer ID
- Own database schema

📌 Port: `8081`

---

### 6️⃣ Symbol Service
- Manages Symbols related to Dreams
- Independent service
- Own database schema

📌 Port: `8082`

---

## 🗄 Database Strategy
- **Database per service**
- Each microservice has:
  - Its own datasource
  - Its own schema
- No shared database between services

---

## ▶ How to Run the System

### Start services in the following order:

1. **Config Server**
   ```bash
   mvn spring-boot:run
