# Logistics App

This repository contains a Kotlin-based Android application developed for managing logistics operations. The app employs modern Android development architecture, utilizing Kotlin Flow, ViewModels, Dagger Hilt for dependency injection, and follows the Clean MVVM (Model-View-ViewModel) architecture.

## Features

- **Search Shipment Data**: Allows users to search and retrieve shipment data efficiently.
- **Clean MVVM Architecture**: Implements a well-organized architecture for better maintainability and scalability.
- **Kotlin Flow**: Utilizes Kotlin Flow for handling asynchronous operations in a concise and reactive manner.
- **ViewModels**: Utilizes Android ViewModel to manage UI-related data in a lifecycle-conscious way.
- **Dependency Injection with Dagger Hilt**: Uses Dagger Hilt for dependency injection, promoting a modular and scalable codebase.

## Getting Started

These instructions will help you get a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

- Android Studio 4.2 or higher
- Kotlin plugin for Android Studio

### Installation

1. Clone the repository to your local machine:

    ```bash
    git clone https://github.com/your-username/logistics-app.git
    ```

2. Open the project in Android Studio.

3. Build and run the project on an emulator or a physical device.

## Architecture Overview

The app follows the Clean MVVM architecture to separate concerns and maintain a clear code structure.

- **Data**: Manages the data layer responsible for handling data from various sources.
- **Domain**: Contains the business logic and use cases of the application.
- **Presentation**: Manages the UI-related components, including ViewModels and UI models.
- **Di**: Handles dependency injection using Dagger Hilt.

## Dependencies

- Kotlin Flow
- ViewModel
- Dagger Hilt

For a complete list of dependencies, please 
