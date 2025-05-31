plugins {
    id("org.jetbrains.intellij") version "1.17.3"
    kotlin("jvm") version "1.9.23"



}

group = "org.hussain"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

// Configure Java and Kotlin compatibility
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17)) // or 21 if you prefer
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "17" // Match the Java version above
    }
}

//+++++++++++++++++++++++++++
tasks {
    runIde {
        jvmArgs = listOf(
            "-Djava.version=17",
            "-Xmx2048m"
        )
    }
}

//+++++++++++++++++++++++++++

// Configure IntelliJ plugin
intellij {
    version.set("2023.2") // Use a specific version
    type.set("IC") // IntelliJ IDEA Community Edition
    plugins.set(listOf("org.jetbrains.kotlin"))
}


//plugins {
//    id("org.jetbrains.intellij") version "1.17.3" // ← safer known version
//
//    kotlin("jvm") version "1.9.23"
//}
/////Configure Java and Kotlin compatibility
////java {
////    toolchain {
////        languageVersion.set(JavaLanguageVersion.of(17))
////    }
////    sourceCompatibility = JavaVersion.VERSION_17
////    targetCompatibility = JavaVersion.VERSION_17
////}
////
////tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
////    kotlinOptions {
////        jvmTarget = "17"
////    }
////}
//
//
//
//group = "org.hussain"
//version = "1.0-SNAPSHOT"
//
//repositories {
//    mavenCentral()
//}
//
////intellij {
////    // target IntelliJ IDEA version
////    version.set("2022.3")
////    // Community Edition
////    type.set("IC")
////    // no additional platform plugins
////    plugins.set(emptyList())
////}
//
//intellij {
//    version.set("2022.3.3") // Make sure this matches your IDE version
//    type.set("IC") // Community edition
//    plugins.set(listOf("Kotlin")) // Add Kotlin plugin if needed
//}
//
//dependencies {
//    implementation(kotlin("stdlib"))
//    testImplementation(kotlin("test"))
//}
//
//tasks.test {
//    useJUnitPlatform()
//}




//plugins {
//    kotlin("jvm") version "2.1.20"
//}
//
//group = "org.hussain"
//version = "1.0-SNAPSHOT"
//
//repositories {
//    mavenCentral()
//}
//
//dependencies {
//    testImplementation(kotlin("test"))
//    implementation(kotlin("stdlib"))
//
//
//}
//
//tasks.test {
//    useJUnitPlatform()
//}
//
//intellij {
//    version.set("2022.3") // Use the IntelliJ version you want to target
//    type.set("IC") // IntelliJ Community Edition
//    plugins.set(listOf()) // Add platform plugins here if needed
//}