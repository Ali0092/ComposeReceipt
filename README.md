# Receipt UI Library

A Jetpack Compose library for creating beautiful receipt-style UI components.

## Screenshot

<img width="321" height="536" alt="Screenshot 2026-01-11 at 1 53 49 PM" src="https://github.com/user-attachments/assets/1e4927bc-fbba-499a-bd4b-eb9ef70a65e8" />
<img width="304" height="627" alt="Screenshot 2026-01-11 at 1 54 30 PM" src="https://github.com/user-attachments/assets/88c6a6b2-5313-41ab-8b4d-ac483d62f3df" />
<img width="306" height="440" alt="Screenshot 2026-01-11 at 1 55 53 PM" src="https://github.com/user-attachments/assets/a25fdd47-7061-4ff1-9e8e-fafc3e7677b5" />


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
    implementation("com.github.Ali0092:ComposeReceipt:v1.0.1")
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
