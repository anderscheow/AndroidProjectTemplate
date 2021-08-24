package com.example.template_v2.gradle.plugins.configs

import com.android.build.gradle.BaseExtension
import com.example.template_v2.gradle.plugins.Constants
import com.example.template_v2.gradle.plugins.kotlinOptions
import org.gradle.api.JavaVersion
import org.gradle.api.plugins.PluginContainer

@Suppress("UnstableApiUsage")
object AndroidConfig {

    object Module {
        fun setAndroidConfig(baseExtension: BaseExtension) {
            baseExtension.apply {
                compileSdkVersion(Constants.App.COMPILE_SDK)
                buildToolsVersion(Constants.App.BUILD_TOOLS)

                defaultConfig {
                    minSdk = Constants.App.MIN_SDK
                    targetSdk = Constants.App.TARGET_SDK
                    versionCode = Constants.App.VERSION_CODE
                    versionName = Constants.App.VERSION_NAME

                    testInstrumentationRunner("androidx.test.runner.AndroidJUnitRunner")
                }

                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_1_8
                    targetCompatibility = JavaVersion.VERSION_1_8
                }

                kotlinOptions {
                    jvmTarget = "1.8"
                }
            }
        }

        fun addApplicationConfig(baseExtension: BaseExtension, subApplicationId: String = "") {
            baseExtension.defaultConfig {
                this.applicationId = Constants.App.APPLICATION_ID
                if (subApplicationId.isNotBlank()) {
                    this.applicationIdSuffix = ".$subApplicationId"
                }
            }
            setAndroidConfig(baseExtension)
        }

        fun addModuleConfig(baseExtension: BaseExtension, subApplicationId: String = "") {
            if (Constants.IS_BUILD_MODULE) {
                addApplicationConfig(baseExtension, subApplicationId)
            } else {
                setAndroidConfig(baseExtension)
            }
        }
    }

    object BuildType {
        fun addModuleBuildType(baseExtension: BaseExtension) {
            baseExtension.buildTypes {
                named("release") {
                    isMinifyEnabled = false
                    proguardFiles(
                        baseExtension.getDefaultProguardFile("proguard-android-optimize.txt"),
                        "proguard-rules.pro"
                    )
                    buildConfigField(
                        "Boolean",
                        "isBuildModule",
                        "Boolean.parseBoolean(\"${Constants.IS_BUILD_MODULE}\")"
                    )
                }
            }
        }

        fun addApiBuildType(baseExtension: BaseExtension) {
            baseExtension.buildTypes {
                named("release") {
                    isMinifyEnabled = true
                    proguardFiles(
                        baseExtension.getDefaultProguardFile("proguard-android-optimize.txt"),
                        "proguard-rules.pro"
                    )
                }
            }
        }
    }

    object ProductFlavors {
        fun addBasicProductFlavor(baseExtension: BaseExtension, pluginContainer: PluginContainer) {
        }
    }

    object SourceSet {
        fun addExtNativeLibSource(baseExtension: BaseExtension) {
            baseExtension.sourceSets {
                named("main") {
                    jniLibs.srcDir("jniLibs")
                }
            }
        }

        fun addModuleSourceSet(baseExtension: BaseExtension) {
            baseExtension.sourceSets {
                named("main") {
                    if (Constants.IS_BUILD_MODULE) {
                        manifest.srcFile("src/main/debug/AndroidManifest.xml")
                    } else {
                        manifest.srcFile("src/main/AndroidManifest.xml")
                    }
                }
            }
        }
    }

    object Extra {
        fun addViewBinding(
            baseExtension: BaseExtension,
            isBuildModule: Boolean = Constants.IS_BUILD_MODULE
        ) {
            baseExtension.buildFeatures.viewBinding = true
        }
    }
}