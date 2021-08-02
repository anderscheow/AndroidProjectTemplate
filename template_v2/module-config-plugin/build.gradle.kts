plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
    jcenter()
    maven {
        setUrl("https://jitpack.io")
    }
}

dependencies {
    implementation(gradleApi())
    implementation("com.android.tools.build:gradle:4.2.2")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.10")
}

gradlePlugin {
    plugins.register("module-config-plugin") {
        id = "module-config-plugin"
        implementationClass = "com.example.template_v2.gradle.plugins.ModuleConfigPlugin"
    }
}