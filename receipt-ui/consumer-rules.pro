# Consumer ProGuard rules for receipt-ui library
# These rules are applied to projects that use this library

# Keep all public classes and methods in the library
-keep public class com.receiptui.** { *; }
-keepclassmembers class com.receiptui.** { *; }
