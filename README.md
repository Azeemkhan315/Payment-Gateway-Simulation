# 💳 Payment Gateway Simulation  

This project simulates a dealer subscription payment system using **Spring Boot** and **MySQL**.  
It provides APIs to initiate payments and automatically updates their status after 5 seconds.  

---

## 🚀 Features  
- REST API for initiating payments  
- Supports multiple payment methods (UPI / Card / NetBanking)  
- Saves payment with status = `PENDING`  
- Auto-updates payment status to `SUCCESS` after 5 seconds  
- Built with Spring Boot + JPA + MySQL  

---

## 🛠️ Tech Stack  
- **Backend**: Java, Spring Boot, Spring Data JPA  
- **Database**: MySQL  
- **Build Tool**: Maven  
- **API Testing**: Postman  

---

## 📂 Project Structure  
Payment-Gateway-Simulation/
├── src/
│ ├── main/java/com/Payment/Gateway/Simulation/
│ │ ├── Controller/ # REST Controllers
│ │ ├── Entity/ # JPA Entities
│ │ ├── Repository/ # Spring Data Repositories
│ │ └── Application # Main Spring Boot Class
├── pom.xml
└── README.md

---

## ⚡ API Endpoints  

### 1️⃣ Initiate Payment  
**Endpoint**:  
POST /api/payment/initiate

**Request Body**:
```json
{
  "amount": 500,
  "method": "UPI"
}
Initial Response (PENDING):

{
  "id": 1,
  "amount": 500,
  "method": "UPI",
  "status": "PENDING",
  "createdAt": "2025-10-03T10:00:00"
}
After 5 sec (Auto Update → SUCCESS)

{
  "id": 1,
  "amount": 500,
  "method": "UPI",
  "status": "SUCCESS",
  "createdAt": "2025-10-03T10:00:00"
}
🖼️ Screenshots
✅ API Test in Postman
![Postman Screenshot](screenshots/payment.jpg)

⚙️ Setup & Run
Clone repo:
git clone https://github.com/Azeemkhan315/Payment-Gateway-Simulation.git
cd Payment-Gateway-Simulation

Configure application.properties:
spring.datasource.url=jdbc:mysql://localhost:3306/akdatabase
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update

Run project:
mvn spring-boot:run
Test with Postman at:

http://localhost:8080/api/payment/initiate

👤 Author
Azeem Khan
Java Backend Developer | Spring Boot | MySQL

Thank You
