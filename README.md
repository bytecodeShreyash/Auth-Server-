# Auth App - Vaadin Frontend

A modern authentication application built with **Vaadin Framework** featuring a beautiful dark theme UI.

## Features

✨ **Modern Dark Theme** - Premium dark UI with smooth gradients and animations
🔐 **Login Page** - Email/password authentication with OAuth options
📝 **Register Page** - User registration with form validation
🎨 **Beautiful Design** - Glassmorphism effects, smooth transitions, and micro-animations
📱 **Responsive** - Works seamlessly on desktop and mobile devices

## Tech Stack

- **Vaadin 24.3.5** - Java web framework
- **Spring Boot 3.5.10** - Backend framework
- **Java 17** - Programming language
- **Maven** - Build tool

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/example/
│   │       ├── config/
│   │       │   └── AppConfig.java          # Vaadin configuration
│   │       ├── views/
│   │       │   ├── LoginView.java          # Login page
│   │       │   └── RegisterView.java       # Register page
│   │       └── AuthServerApplication.java  # Main application
│   └── resources/
│       ├── static/
│       │   └── styles.css                  # Custom CSS styles
│       └── application.properties          # Configuration
└── frontend/
    └── themes/
        └── auth-app/
            ├── styles.css                   # Theme styles
            └── theme.json                   # Theme configuration
```

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6+
- Node.js 18+ (for Vaadin frontend build)

### Installation & Running

1. **Navigate to the project directory:**
   ```bash
   cd c:\Users\HP\Downloads\AuthServer\AuthServer
   ```

2. **Install dependencies and run:**
   ```bash
   mvnw clean install
   mvnw spring-boot:run
   ```

   Or if you have Maven installed globally:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

3. **Access the application:**
   - The application will automatically open in your browser at: `http://localhost:8080`
   - Login page: `http://localhost:8080/`
   - Register page: `http://localhost:8080/register`

## Pages

### Login Page
- Email and password fields
- "Continue with Google" button
- "Continue with GitHub" button
- "Create account" link
- "Forgot password?" link
- Error message display for invalid credentials

**Test Credentials:**
- Email: `durgesh@gmail.com`
- Password: Any password with 6+ characters

### Register Page
- Name field
- Email field
- Password field
- "Create account" button
- OAuth options (Google, GitHub)
- "Already have an account?" link

## Customization

### Changing Colors

Edit `src/main/resources/static/styles.css`:

```css
:root {
    --primary-gradient: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
    --background-dark: #0a0a0a;
    --surface-dark: #1a1a1a;
    /* ... more variables */
}
```

### Modifying Views

- **Login View:** `src/main/java/com/example/views/LoginView.java`
- **Register View:** `src/main/java/com/example/views/RegisterView.java`

## Development Notes

- **Frontend-only mode:** Spring Security is disabled for easier frontend development
- **Hot reload:** Vaadin supports hot reload during development
- **Production mode:** Set `vaadin.productionMode=true` in `application.properties` for production builds

## Building for Production

```bash
mvnw clean package -Pproduction
```

The production-ready JAR will be in the `target/` directory.

## Troubleshooting

### Port already in use
If port 8080 is already in use, change it in `application.properties`:
```properties
server.port=8081
```

### Frontend build issues
If you encounter frontend build issues, try:
```bash
mvnw clean vaadin:clean-frontend vaadin:prepare-frontend
```

## License

This project is open source and available under the MIT License.

## Screenshots

The application features:
- Dark theme with gradient accents
- Smooth animations and transitions
- Modern glassmorphism effects
- Responsive design for all screen sizes
- Premium UI components

---

**Built with ❤️ using Vaadin Framework**
