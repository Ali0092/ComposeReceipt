# Receipt UI Library

A Jetpack Compose library for creating beautiful receipt-style UI components.

## Installation

Add the JitPack repository to your root `settings.gradle.kts`:

```kotlin
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}
```

Add the dependency to your app's `build.gradle.kts`:

```kotlin
dependencies {
    implementation("com.github.ali0092:Workshop:1.0.1")
}
```

**Minimum Requirements:**
- Min SDK: 26 (Android 8.0+)
- Jetpack Compose

## Components

- **Receipt**: Complete receipt UI composable
- **TicketShape**: Custom shape with configurable top edge (Flat, Rounded, Inward)
- **ReceiptFooter**: Custom shape with scalloped bottom edge
- **DashedLine**: Dashed separator line composable
- **ReceiptUITheme**: Optional theme for consistent styling

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

Copyright (c) 2026 Ali0092
