# Component Demos

This document provides an overview of all demo files available in the project. Each demo file showcases specific component types with various styling options and use cases.

## Demo Files Structure

All demo files are located in: `app/src/main/java/com/example/workshop/demos/`

### Navigation

**File:** `app/src/main/java/com/example/workshop/DemoNavigationScreen.kt`

Main navigation screen that allows users to browse different component demonstrations. Features:
- Clean navigation interface
- Back button support for each demo screen
- Organized by component type

---

## 1. Receipt Component Demos

**File:** `demos/ReceiptDemo.kt`

Demonstrates the complete Receipt component with multiple sections, dashed dividers, and scalloped footer.

### Examples Included:
- **Dark Theme Receipt**
  - Multiple contact and transaction sections
  - Custom styled total and footer sections
  - High shadow elevation (10.dp)

- **Light Theme Receipt**
  - Order details example
  - Lighter color scheme
  - Centered footer content

### Key Features Demonstrated:
- Multiple `ZapSectionData` sections
- Custom `ticketSectionContent` lambda
- Custom `totalSectionContent` lambda
- Custom `footerSectionContent` lambda
- Different color schemes (dark/light)
- Shadow and elevation effects

---

## 2. Ticket Component Demos

**File:** `demos/TicketDemo.kt`

Showcases all ticket component variations with different top edge styles.

### Examples Included:

#### Standard Tickets:
- **Inward Curved Top Edge**
  - Contact details example
  - Large padding (32.dp)
  - Shadow elevation (8.dp)

- **Rounded Top Edge**
  - Event details example
  - High shadow elevation (12.dp)

- **Flat Top Edge**
  - Booking information example
  - Custom color scheme

- **Large Padding Variant**
  - Premium ticket example
  - Extra large padding (40.dp)
  - Green color scheme

#### Custom Content Variants:
- **Simple Custom Content**
  - Centered text layout
  - Basic demonstration

- **Promotional Custom Content**
  - Special offer layout
  - Large display text
  - Red/orange color scheme

### Key Features Demonstrated:
- All three `TopEdgeStyle` options (Inward, Rounded, Flat)
- `ReceiptTicketComponent` with data
- `ReceiptTicketCustomComponent` with custom content
- Different padding values
- Various shadow elevations
- Color customization

---

## 3. Footer Component Demos

**File:** `demos/FooterDemo.kt`

Displays all footer component variations with scalloped bottom edges.

### Examples Included:

- **Footer with Content**
  - Description and text content
  - Standard styling

- **Decorative Footer (No Content)**
  - Empty footer for visual separation
  - Minimal implementation

- **Dark Themed Footer**
  - Thank you message
  - Centered content
  - Dark background

- **Colorful Footer**
  - Success message
  - Green background
  - Custom scallop gap (3.dp)

- **Large Scallops Footer**
  - Important notice layout
  - Orange background
  - Large scallop gap (5.dp)
  - High shadow elevation

- **Minimal Footer (No Shadow)**
  - Powered by message
  - Light blue background
  - No shadow effect

### Key Features Demonstrated:
- Footer with and without content
- Different scallop gap sizes
- Various shadow elevations (including 0.dp)
- Color customization
- Content alignment variations
- Corner radius customization

---

## 4. Sharp Cornered (Zigzag) Ticket Demos

**File:** `demos/SharpCorneredTicketDemo.kt`

Demonstrates sharp-cornered tickets with zigzag edges on top and bottom.

### Examples Included:

#### Standard Zigzag Tickets:
- **Default Symmetric Zigzag**
  - 8.dp depth, 16.dp width
  - Standard ticket information
  - Shadow and tonal elevation

- **Asymmetric Zigzag**
  - Different top (6dp) and bottom (14dp) sizes
  - Cyan background
  - Demonstrates flexibility

- **Large Zigzag Teeth**
  - 12.dp depth, 24.dp width
  - Event admission example
  - Red/orange color scheme

- **Fine/Small Zigzag**
  - 4.dp depth, 8.dp width
  - Premium pass example
  - Purple color scheme

- **Movie Ticket Style**
  - Classic movie ticket design
  - Blue background
  - Multiple information fields

#### Custom Content Variants:
- **Custom Layout Zigzag**
  - Centered content with description
  - Orange background
  - Demonstrates custom content control

- **Coupon/Voucher Style**
  - Large discount text
  - Green background
  - Promotional layout

### Key Features Demonstrated:
- `SharpCorneredTicket` with data
- `SharpCorneredTicketCustom` with custom content
- Symmetric and asymmetric zigzag patterns
- Various depth and width combinations
- Different use cases (tickets, coupons, passes)
- Shadow and tonal elevation
- Custom content layouts

---

## How to Use These Demos

### Viewing in Android Studio (Preview Mode)

**All demo files include `@Preview` annotations!** You can view components without running the app:

1. Open any demo file in Android Studio
2. Look for the `@Preview` functions at the bottom of the file
3. Click the **Preview** tab (or **Split** view) in Android Studio
4. See live previews of all components

**Available Previews:**
- **ReceiptDemo.kt**: 2 preview variants (full demo + dark receipt)
- **TicketDemo.kt**: 5 preview variants (full demo + inward, rounded, flat, custom)
- **FooterDemo.kt**: 5 preview variants (full demo + with content, dark, colorful, decorative)
- **SharpCorneredTicketDemo.kt**: 6 preview variants (full demo + default, asymmetric, movie, coupon, custom)
- **DemoNavigationScreen.kt**: Navigation menu preview

### Running in Your App

1. The demos are integrated into the app via `DemoNavigationScreen`
2. Launch the app to see the navigation menu
3. Select any component type to view examples
4. Use the back button to return to the main menu

### As Reference Code

Each demo file can serve as a reference for implementing components:

```kotlin
// Example: Using code from ReceiptDemo.kt
Receipt(
    backgroundColor = Color(0xFF2F2F2F),
    contentColor = Color(0xFFF5F4F4),
    dashesColor = Color(0xFFF5F4F4),
    shadowElevation = 10.dp,
    receiptData = ReceiptData(
        // ... your data
    ),
    ticketSectionContent = { /* ... */ },
    totalSectionContent = { /* ... */ },
    footerSectionContent = { /* ... */ }
)
```

### Modifying Demos

Feel free to modify these demo files to:
- Test different color schemes
- Experiment with sizing
- Try new layouts
- Add your own examples

---

## Demo File Locations

```
app/src/main/java/com/example/workshop/
├── DemoNavigationScreen.kt          # Main navigation
└── demos/
    ├── ReceiptDemo.kt               # Full receipt examples
    ├── TicketDemo.kt                # All ticket variations
    ├── FooterDemo.kt                # Footer variations
    └── SharpCorneredTicketDemo.kt   # Zigzag ticket examples
```

---

## Adding New Demos

To add a new demo:

1. Create a new file in `demos/` directory
2. Follow the existing structure with a scrollable Column
3. Add navigation button in `DemoNavigationScreen.kt`
4. Update this document

Example template:

```kotlin
@Composable
fun YourNewDemo(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text(
            text = "Your Demo Title",
            style = MaterialTheme.typography.headlineMedium
        )

        // Your component examples here
    }
}
```

---

## Related Documentation

- [README.md](README.md) - Library installation and usage guide
- [Library Components](receipt-ui/src/main/java/com/receiptui/components/) - Source code for all components

---

**Version:** 1.0.2
**Last Updated:** February 2026
