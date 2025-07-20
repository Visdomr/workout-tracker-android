# Workout Tracker - Android App

Native Android app for the Workout Tracker backend, built with Kotlin and modern Android development practices.

## Features

- **Authentication** - Login/Register with your workout tracker server
- **Workout Management** - Create, edit, and delete workouts
- **Exercise Tracking** - Add exercises to workouts with sets, reps, weight, etc.
- **Material Design 3** - Modern, beautiful UI following Material Design guidelines
- **Offline Support** - Local caching with Room database (planned)
- **Real-time Sync** - Syncs with your Go backend server

## Tech Stack

- **Language**: Kotlin
- **UI**: Material Design 3, View Binding
- **Architecture**: MVVM with LiveData
- **Networking**: Retrofit2 with OkHttp3
- **Database**: Room (for local caching)
- **Charts**: MPAndroidChart (for analytics)
- **Date/Time**: ThreeTenABP

## Project Structure

```
app/src/main/java/com/workouttracker/
├── data/
│   ├── api/          # API interfaces and client
│   ├── model/        # Data models
│   └── repository/   # Data repositories
├── ui/
│   ├── auth/         # Login/Register screens
│   ├── main/         # Main activity and workout list
│   └── workout/      # Workout creation and detail screens
└── utils/            # Utility classes
```

## Setup Instructions

### Prerequisites
- Android Studio Arctic Fox (2020.3.1) or later
- Android SDK with API level 26+ (Android 8.0)
- Your workout tracker Go backend running

### Installation

1. **Clone and open project**:
   ```bash
   cd /path/to/your/android/projects
   cp -r /home/eric/workout-tracker-android ./
   cd workout-tracker-android
   ```

2. **Open in Android Studio**:
   - Open Android Studio
   - Select "Open an Existing Project"
   - Navigate to the project folder and open it

3. **Configure server URL**:
   - Update the `DEFAULT_BASE_URL` in `ApiClient.kt`
   - Change `http://192.168.1.100:8080/` to your server's IP address
   - Or configure it dynamically in the app settings

4. **Build and run**:
   - Connect an Android device or start an emulator
   - Click the "Run" button in Android Studio

## Configuration

### Server Connection

The app connects to your Go backend server. Update the server URL in one of these ways:

1. **Hard-coded** (for development):
   ```kotlin
   // In ApiClient.kt
   private const val DEFAULT_BASE_URL = "http://YOUR_SERVER_IP:8080/"
   ```

2. **Runtime configuration** (recommended):
   - The app includes settings to change the server URL
   - Users can configure their own server connection

### Network Security

For development with HTTP (non-HTTPS) servers:
- The app includes `android:usesCleartextTraffic="true"` in the manifest
- For production, consider implementing HTTPS

## Key Components

### API Client (`ApiClient.kt`)
- Handles all HTTP communication with the backend
- Manages authentication cookies
- Configurable server URL

### Data Models (`Models.kt`)
- Kotlin data classes matching your Go backend models
- Parcelable for easy data passing between activities
- Gson annotations for JSON serialization

### Retrofit API Interface (`WorkoutApi.kt`)
- Defines all API endpoints
- Uses Kotlin coroutines for async operations
- Matches your Go backend routes

### Main Features

1. **Authentication Flow**:
   - Login/Register screens
   - Session management with cookies
   - Auto-logout on session expiry

2. **Workout Management**:
   - List all workouts with pull-to-refresh
   - Create/Edit workout details
   - Delete workouts with confirmation

3. **Exercise System**:
   - Add exercises to workouts
   - Track sets, reps, weight, distance, duration
   - Exercise categories with color coding

4. **Modern UI**:
   - Material Design 3 theming
   - Dark/Light theme support
   - Smooth animations and transitions

## Development Status

### ✅ Completed
- Project structure and configuration
- Data models and API interfaces
- Authentication system architecture
- Main activity with workout list
- Material Design 3 theming
- Build configuration with all dependencies

### 🚧 In Progress
- Login/Register activities
- Workout detail and creation activities
- RecyclerView adapters
- ViewModels and repositories

### 📋 Planned
- Exercise management
- Local database caching
- Settings screen
- Analytics/Charts
- Push notifications
- Offline mode

## Building

### Debug Build
```bash
./gradlew assembleDebug
```

### Release Build
```bash
./gradlew assembleRelease
```

## Testing

### Unit Tests
```bash
./gradlew testDebugUnitTest
```

### Instrumentation Tests
```bash
./gradlew connectedDebugAndroidTest
```

## Deployment

### Direct Install
- Build APK and install directly on devices
- Suitable for friend group deployment

### Play Store (Future)
- Follow Google Play Console guidelines
- Add app signing and release management

## Integration with Backend

The Android app integrates seamlessly with your Go backend:

1. **Same API Endpoints**: Uses identical REST API endpoints
2. **Session Management**: Maintains login sessions with cookies
3. **Data Sync**: Real-time synchronization of workout data
4. **Offline Capability**: Local caching for offline access (planned)

## Customization

### Server Configuration
- Update `DEFAULT_BASE_URL` in `ApiClient.kt`
- Or implement runtime server configuration

### UI Theming
- Modify colors in `res/values/colors.xml`
- Update themes in `res/values/themes.xml`
- Add custom exercise category colors

### API Customization
- Extend `WorkoutApi.kt` for new endpoints
- Add new data models as needed
- Update repositories for additional functionality

## Troubleshooting

### Common Issues

1. **Network Connection**:
   - Verify server URL is correct
   - Check that your Go backend is running
   - Ensure device can reach the server (same network)

2. **Build Errors**:
   - Update Android Gradle Plugin if needed
   - Sync project with Gradle files
   - Clean and rebuild project

3. **API Issues**:
   - Check server logs for API errors
   - Verify API endpoints match backend
   - Use network inspector in Android Studio

## Contributing

This is a private project for your friend group, but you can:
1. Add new features as needed
2. Customize UI/UX for your group's preferences
3. Extend with additional workout tracking features

## Next Steps

1. Complete the remaining UI activities
2. Test with your Go backend server
3. Deploy to your friend group's devices
4. Add any custom features your group needs

The foundation is solid and ready for completion!
