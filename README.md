# 🎯 Codice Fiscale API

A modern Spring Boot REST API that extracts demographic information from Italian Fiscal Codes (Codice Fiscale), calculating age and birth date.

---

## 🚀 Features

- 📅 Extract birth date from Codice Fiscale
- 🎂 Calculate current age
- 🚻 Handle gender-specific date formats
- ✅ Validate Codice Fiscale format
- 📖 OpenAPI documentation

---

## 🛠 Tech Stack

- **Java 21**
- **Spring Boot**
- **Gradle**
- **Lombok**
- **Swagger UI**
- **OpenAPI 3.0**

---

## 🔍 API Endpoints

### Get Demographics from Codice Fiscale
**GET** `/api/codicefiscale?codiceFiscale={codiceFiscale}`

#### Response Example:
```json
{
  "dataDiNascita": "1990-01-01",
  "eta": 34
}
```

---

## 🔧 How It Works

The API analyzes the **Codice Fiscale** structure as follows:

- 📌 **Characters 7-8** → Year of birth
- 🔤 **Character 9** → Month letter code
- 🔢 **Characters 10-11** → Day of birth (adding 40 for females)

---

## 📝 Installation

1. **Clone the repository:**
   ```sh
   git clone https://github.com/yourusername/codice-fiscale-api.git
   cd codice-fiscale-api
   ```

2. **Build with Gradle:**
   ```sh
   ./gradlew build
   ```

3. **Run the application:**
   ```sh
   ./gradlew bootRun
   ```

---

## 📚 API Documentation

Access the OpenAPI documentation at:

➡️ `http://localhost:8080/swagger-ui.html`

---

## 🔒 Error Handling

The API includes robust error handling for:

- ❌ Invalid Codice Fiscale length
- ❌ Invalid month letters
- ❌ Invalid date formats
- ❌ Invalid number formats

---

## 📦 Latest Changes

- ✅ Implemented `CodiceFiscaleInfo` model with birth date and age fields
- ✅ Created `CodiceFiscaleService` for demographic info extraction
- ✅ Added month conversion and age calculation logic
- ✅ Defined OpenAPI specification
- ✅ Set up error handling and validation

---

## 🤝 Contributing

Contributions, issues, and feature requests are welcome!

1. Fork the repository
2. Create a new branch (`git checkout -b feature-branch`)
3. Commit your changes (`git commit -m 'Add new feature'`)
4. Push to the branch (`git push origin feature-branch`)
5. Open a Pull Request

---

### 🎯 Happy Coding! 🚀


