# Mcon.Agnum ProGuard Rules

# Kotlin Serialization
-keepattributes *Annotation*, InnerClasses
-dontnote kotlinx.serialization.AnnotationsKt
-keepclassmembers class kotlinx.serialization.json.** {
    *** Companion;
}
-keepclasseswithmembers class kotlinx.serialization.json.** {
    kotlinx.serialization.KSerializer serializer(...);
}

# Keep data classes for serialization
-keep @kotlinx.serialization.Serializable class ** { *; }

# Ktor
-keep class io.ktor.** { *; }
-dontwarn io.ktor.**

# SQLDelight
-keep class app.cash.sqldelight.** { *; }

# Koin
-keep class org.koin.** { *; }
-dontwarn org.koin.**
