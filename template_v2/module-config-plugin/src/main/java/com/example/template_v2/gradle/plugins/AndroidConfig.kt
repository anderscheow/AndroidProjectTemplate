package com.example.template_v2.gradle.plugins

import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion
import org.gradle.api.plugins.PluginContainer

@Suppress("UnstableApiUsage")
object AndroidConfig {

    object Module {
        fun setAndroidConfig(baseExtension: BaseExtension) {
            baseExtension.apply {
                compileSdkVersion(Constants.App.compile_sdk)
                buildToolsVersion(Constants.App.build_tools)

                defaultConfig {
                    minSdk = Constants.App.min_sdk
                    targetSdk = Constants.App.target_sdk
                    versionCode = Constants.App.version_code
                    versionName = Constants.App.version_name

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
                this.applicationId = Constants.App.applicationId
                if (subApplicationId.isNotBlank()) {
                    this.applicationIdSuffix = ".$subApplicationId"
                }
            }
            setAndroidConfig(baseExtension)
        }

        fun addModuleConfig(baseExtension: BaseExtension, subApplicationId: String = "") {
            if (Constants.isBuildModule) {
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
                        "Boolean.parseBoolean(\"${Constants.isBuildModule}\")"
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
                    if (Constants.isBuildModule) {
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
            isBuildModule: Boolean = Constants.isBuildModule
        ) {
            baseExtension.buildFeatures.viewBinding = true
        }
    }
}