plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "mada.alain.mobiliari"
    compileSdk = 34

    defaultConfig {
        applicationId = "mada.alain.mobiliari"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // Material Design (composants tels que les boutons, icônes, etc.)
    implementation("androidx.compose.material:material:1.7.0")
    implementation("androidx.compose.material:material-icons-core:1.7.0")
    implementation("androidx.compose.material:material-icons-extended:1.7.0")

    // Outils de prévisualisation Compose
    implementation("androidx.compose.ui:ui-tooling-preview:1.7.0")

    // Activity Compose (pour intégrer Compose dans une Activity)
    implementation("androidx.activity:activity-compose:1.9.2")

    // Core KTX
    implementation("androidx.core:core-ktx:1.13.1")

    // Compose BOM (Gestion des versions des dépendances Compose)
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))

    // Graphics et autres outils Compose
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.material3:material3")

    // ConstraintLayout avec Compose
    implementation("androidx.constraintlayout:constraintlayout-compose:1.0.1")


    // Tests unitaires
    testImplementation("junit:junit:4.13.2")

    // Tests instrumentés
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")

    // Dépendances de débogage
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    // Navigation Compose
    implementation("androidx.navigation:navigation-compose:2.8.0")

    // DB
    implementation("androidx.room:room-ktx:2.6.1")
    implementation("androidx.room:room-runtime:2.6.1")
    kapt("androidx.room:room-compiler:2.6.1")
    annotationProcessor("androidx.room:room-compiler:2.6.1")

    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.4")
    implementation("androidx.activity:activity-compose:1.9.1")

    implementation("androidx.compose.ui:ui:1.7.0")

// Optionnel : Pour afficher les aperçus de l'UI pendant le développement
    debugImplementation("androidx.compose.ui:ui-tooling:1.7.0")

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.8.0")


    // ARSceneview
    implementation("io.github.sceneview:arsceneview:2.2.1")
}