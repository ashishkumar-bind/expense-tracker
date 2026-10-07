# Expense Tracker

A RESTful API built with Spring Boot and MySQL to manage personal expenses.

## Tech Stack
- Java
- Spring Boot
- Spring Data JPA (Hibernate)
- MySQL
- Maven

## Features
- Add, view, update and delete expenses (CRUD)
- Each expense is linked to a user

## API Endpoints

| Method | URL | Description |
|--------|-----|-------------|
| POST | /api/expenses | Add a new expense |
| GET | /api/expenses | Get all expenses |
| GET | /api/expenses/{id} | Get one expense |
| PUT | /api/expenses/{id} | Update an expense |
| DELETE | /api/expenses/{id} | Delete an expense |

### Sample request (POST /api/expenses)

```json
{
  "userId": 1,
  "title": "Pizza",
  "amount": 300,
  "category": "Food",
  "date": "2026-10-07"
}
```

## How to Run
1. Clone the repo
```
   git clone https://github.com/ashishkumar-bind/expense-tracker.git
```
2. Create a MySQL database named `expense_db`
3. Open `src/main/resources/application.properties` and set your MySQL password
4. Insert a test user:
```sql
   INSERT INTO users (name, email, password) VALUES ('Test', 'test@gmail.com', '1234');
```
5. Run `ExpenseTrackerApplication.java`
6. Test APIs with Postman at `http://localhost:8080`

## Author
Ashish Kumar Bind
