# Firebase Authentication Android App

A simple Android application demonstrating Firebase Authentication with email/password login and registration functionality.

## 📱 Features

- **User Registration**: Create new accounts with email verification
- **User Login**: Secure authentication with Firebase Auth
- **Email Verification**: Ensures users verify their email before login
- **Session Management**: Automatic login state persistence
- **Clean UI**: Material Design components with custom color scheme

## 🛠️ Tech Stack

- **Language**: Java
- **Framework**: Android SDK
- **Authentication**: Firebase Authentication
- **UI**: Material Components
- **Architecture**: Single Activity Pattern

## 🎨 Color Scheme

- Primary: `#1E88E5` (Blue)
- Primary Dark: `#1565C0` (Dark Blue)
- Accent: `#42A5F5` (Light Blue)
- Background: `#F5F7FA` (Light Gray)

## 🔧 Setup Instructions

1. **Clone the repository**
   ```bash
   git clone https://github.com/rayanelhabib/Connection-firebase-java.git
   ```

2. **Open in Android Studio**
   - Open the project in Android Studio
   - Wait for Gradle sync to complete

3. **Firebase Configuration**
   - The `google-services.json` file is already included
   - Project ID: `connectionfirebase-ce4ac`
   - Package name: `com.example.connectionfirebase`

4. **Build and Run**
   ```bash
   ./gradlew build
   ```

## 📁 Project Structure

```
app/
├── src/main/
│   ├── java/com/example/connectionfirebase/
│   │   ├── LoginActivity.java      # Login screen
│   │   ├── RegisterActivity.java   # Registration screen
│   │   └── MainActivity.java       # Main dashboard
│   ├── res/
│   │   ├── layout/                 # XML layout files
│   │   ├── values/                 # Colors, strings, themes
│   │   └── drawable/               # App icons
│   └── AndroidManifest.xml
└── google-services.json            # Firebase config
```

## 🚀 Screens

### 1. Login Screen
- Email and password fields
- Login button
- Navigation to registration

### 2. Registration Screen
- Email and password input
- Firebase user creation
- Email verification required

### 3. Main Screen
- Success message
- Logout functionality

## 🔐 Firebase Integration

- **Authentication**: Email/Password provider
- **Security**: Email verification required
- **Real-time**: Instant login state updates

## 📞 Author

**Rayan El Habib**
- Instagram: [@skz_rayan23](https://www.instagram.com/skz_rayan23/)
- GitHub: [rayanelhabib](https://github.com/rayanelhabib/)
- LinkedIn: [Rayan El Habib](https://www.linkedin.com/in/rayan-el-habib/)

## 📄 License

This project is for educational purposes.

---
*Built with love using Firebase and Android*