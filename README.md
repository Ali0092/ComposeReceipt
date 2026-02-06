# ComposeReceipt - Receipt UI Library

A beautiful and flexible Jetpack Compose library for creating receipt-style UI components with multiple shape variations, customizable styling, and shadow effects.

## Screenshots
<img width="328" height="517" alt="Screenshot 2026-02-06 at 4 57 08 PM" src="https://github.com/user-attachments/assets/3cca42f7-2c0d-4166-8605-181b9236433a" />
<img width="329" height="624" alt="Screenshot 2026-02-06 at 4 57 22 PM" src="https://github.com/user-attachments/assets/53a42528-a32f-4545-8c5e-4fcf49cd5b74" />
<img width="302" height="529" alt="Screenshot 2026-02-06 at 5 00 15 PM" src="https://github.com/user-attachments/assets/27f5ac23-8990-495a-ac40-6747edc77b38" />

## Features

- Multiple receipt component styles (rounded, inward curved, flat, zigzag)
- Customizable colors, shadows, and elevations
- Pre-built data models for easy integration
- Scalloped footer shapes
- Dashed divider lines
- Support for custom content layouts
- Material 3 compatible

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
    implementation("com.github.Ali0092:ComposeReceipt:1.0.2")
}
```

**Minimum Requirements:**
- Min SDK: 26 (Android 8.0+)
- Jetpack Compose
- Kotlin

## Components

- **Receipt**: Complete receipt UI composable
- **TicketShape**: Custom shape with configurable top edge (Flat, Rounded, Inward)
- **ReceiptFooter**: Custom shape with scalloped bottom edge
- **DashedLine**: Dashed separator line composable
- **ReceiptUITheme**: Optional theme for consistent styling

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

Copyright (c) 2026 Ali0092
