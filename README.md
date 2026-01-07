# Receipt UI Library

A Jetpack Compose library for creating beautiful receipt-style UI components.

## Installation

Add JitPack repository in `settings.gradle.kts`:

```kotlin
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}
```

Add dependency:

```kotlin
dependencies {
    implementation("com.github.YOURUSERNAME:Workshop:1.0.0")
}
```

## Usage

```kotlin
import com.receiptui.components.Receipt
import androidx.compose.ui.graphics.Color

Receipt(shapeColor = Color(0xFFD0D0D0))
```

## Components

- **Receipt**: Complete receipt UI composable
- **TicketShape**: Custom shape with configurable top edge (Flat, Rounded, Inward)
- **ReceiptFooter**: Custom shape with scalloped bottom edge
- **DashedLine**: Dashed separator line composable
- **ReceiptUITheme**: Optional theme for consistent styling

## License

MIT License
