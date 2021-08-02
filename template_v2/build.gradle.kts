plugins {
    id("module-config-plugin")
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:4.2.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.10")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.35")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        jcenter()
        maven {
            setUrl("https://jitpack.io")
        }
    }

    plugins.apply("module-config-plugin")

    tasks.withType(org.jetbrains.kotlin.gradle.tasks.KotlinCompile::class.java).all {
        kotlinOptions {
            freeCompilerArgs = mutableListOf<String>().apply {
                this.addAll(freeCompilerArgs)
                this.add("-Xopt-in=kotlin.RequiresOptIn")
            }
        }
    }
}

tasks.register("clean", Delete::class.java) {
    delete(rootProject.buildDir)
}