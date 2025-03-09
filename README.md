# 🎯 Codice Fiscale API
A modern Spring Boot REST API that extracts demographic information from Italian Fiscal Codes (Codice Fiscale), calculating age and birth date.

## 🚀 Features
- 📅 Extract birth date from Codice Fiscale
- 🎂 Calculate current age
- 🚻 Handle gender-specific date formats
- ✅ Validate Codice Fiscale format
- 📖 OpenAPI documentation
- 🌐 Cross-Origin Resource Sharing (CORS) enabled
- 🚀 Live deployment on Render.com
- 🔍 Health checks and metrics
- 📊 HTTP compression and HTTP/2 support

## 🛠 Tech Stack
- Java 21
- Spring Boot 3.2.3
- Gradle 8.5
- Lombok
- Swagger UI
- OpenAPI 3.0
- Spring Actuator

## 🔍 API Endpoints
### Get Demographics from Codice Fiscale
GET /api/codicefiscale?codiceFiscale={codiceFiscale}

Response Example:
{
  "dataDiNascita": "1990-01-01",
  "eta": 34
}

## 🌍 Live API Access
- API Base URL: `https://codice-fiscale-api.onrender.com`
- Swagger UI: `https://codice-fiscale-api.onrender.com/swagger-ui.html`
- Health Check: `https://codice-fiscale-api.onrender.com/actuator/health`

## 🔧 How It Works
The API analyzes the Codice Fiscale structure as follows:

📌 Characters 7-8 → Year of birth
🔤 Character 9 → Month letter code
🔢 Characters 10-11 → Day of birth (adding 40 for females)

## 📝 Installation
Clone the repository:

git clone https://github.com/yourusername/codice-fiscale-api.git
cd codice-fiscale-api

Build with Gradle:

./gradlew build

Run the application:

./gradlew bootRun

## 📚 API Documentation
Access the OpenAPI documentation at:

➡️ Local: `http://localhost:8080/swagger-ui.html`
➡️ Live: `https://codice-fiscale-api.onrender.com/swagger-ui.html`

## 🔒 Error Handling
The API includes robust error handling for:

❌ Invalid Codice Fiscale length
❌ Invalid month letters
❌ Invalid date formats
❌ Invalid number formats
❌ CORS related issues

## 📦 Latest Changes
✅ Implemented CodiceFiscaleInfo model with birth date and age fields
✅ Created CodiceFiscaleService for demographic info extraction
✅ Added month conversion and age calculation logic
✅ Defined OpenAPI specification
✅ Set up error handling and validation
✅ Added CORS support for cross-origin requests
✅ Configured production environment on Render.com
✅ Implemented health checks and metrics
✅ Added HTTP compression and HTTP/2 support
✅ Configured logging for production

## 🤝 Contributing
Contributions, issues, and feature requests are welcome!

Fork the repository
Create a new branch (git checkout -b feature-branch)
Commit your changes (git commit -m 'Add new feature')
Push to the branch (git push origin feature-branch)
Open a Pull Request

## 🎯 Happy Coding! 🚀
