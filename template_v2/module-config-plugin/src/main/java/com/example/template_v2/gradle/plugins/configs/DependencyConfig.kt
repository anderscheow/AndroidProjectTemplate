package com.example.template_v2.gradle.plugins.configs

import com.example.template_v2.gradle.plugins.Constants
import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

object DependencyConfig {

    object AndroidX {
        const val ANNOTATION = "androidx.annotation:annotation:${Constants.Dependency.ANNOTATION}"
        const val APP_COMPAT = "androidx.appcompat:appcompat:${Constants.Dependency.APP_COMPAT}"
        const val CONSTRAINT_LAYOUT =
            "androidx.constraintlayout:constraintlayout:${Constants.Dependency.CONSTRAINT_LAYOUT}"
        const val CORE_KTX = "androidx.core:core-ktx:${Constants.Dependency.CORE_KTX}"
        const val FRAGMENT_KTX =
            "androidx.fragment:fragment-ktx:${Constants.Dependency.FRAGMENT_KTX}"
        const val LIFECYCLE_LIVEDATA_KTX =
            "androidx.lifecycle:lifecycle-livedata-ktx:${Constants.Dependency.LIFECYCLE}"
        const val LIFECYCLE_RUNTIME_KTX =
            "androidx.lifecycle:lifecycle-runtime-ktx:${Constants.Dependency.LIFECYCLE}"
        const val LIFECYCLE_VIEWMODEL_KTX =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:${Constants.Dependency.LIFECYCLE}"
        const val MATERIAL_DESIGN =
            "com.google.android.material:material:${Constants.Dependency.MATERIAL_DESIGN}"
        const val PAGING = "androidx.paging:paging-runtime-ktx:${Constants.Dependency.PAGING}"
        const val ROOM_COMPILER = "androidx.room:room-compiler:${Constants.Dependency.ROOM}"
        const val ROOM_KTX = "androidx.room:room-ktx:${Constants.Dependency.ROOM}"
        const val ROOM_RUNTIME = "androidx.room:room-runtime:${Constants.Dependency.ROOM}"
        const val WORK_MANAGER_KTX =
            "androidx.work:work-runtime-ktx:${Constants.Dependency.WORK_MANAGER}"
        const val SECURITY_CRYPTO =
            "androidx.security:security-crypto:${Constants.Dependency.SECURITY_CRYPTO}"
    }

    object Glide {
        const val GLIDE = "com.github.bumptech.glide:glide:${Constants.Dependency.GLIDE}"
        const val GLIDE_COMPILER =
            "com.github.bumptech.glide:compiler:${Constants.Dependency.GLIDE}"
    }

    object Hilt {
        const val HILT = "com.google.dagger:hilt-android:${Constants.Dependency.HILT}"
        const val HILT_COMPILER = "com.google.dagger:hilt-compiler:${Constants.Dependency.HILT}"
    }

    object Misc {
        const val DEBUGGER = "com.amitshekhar.android:debug-db:${Constants.Dependency.DEBUGGER}"
        const val EVENT_BUS = "org.greenrobot:eventbus:${Constants.Dependency.EVENT_BUS}"
        const val KOTLIN_STDLIB =
            "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Constants.Dependency.KOTLIN}"
        const val LOGGER = "com.orhanobut:logger:${Constants.Dependency.LOGGER}"
        const val VIEW_BINDING_PROPERTY_DELEGATE = "com.github.kirich1409:viewbindingpropertydelegate-noreflection:${Constants.Dependency.VIEW_BINDING_PROPERTY_DELEGATE}"
    }

    object Network {
        const val MOSHI = "com.squareup.moshi:moshi-kotlin:${Constants.Dependency.MOSHI}"
        const val RETROFIT_MOSHI_CONVERTER =
            "com.squareup.retrofit2:converter-moshi:${Constants.Dependency.RETROFIT}"
        const val RETROFIT = "com.squareup.retrofit2:retrofit:${Constants.Dependency.RETROFIT}"
        const val OKHTTP = "com.squareup.okhttp3:okhttp:${Constants.Dependency.OKHTTP}"
        const val OKHTTP_LOGGING =
            "com.squareup.okhttp3:logging-interceptor:${Constants.Dependency.OKHTTP}"
    }

    object Router {
        const val AROUTER = "com.alibaba:arouter-api:${Constants.Dependency.AROUTER}"
        const val AROUTER_COMPILER = "com.alibaba:arouter-compiler:${Constants.Dependency.AROUTER}"
    }

    object Test {
        const val TEST_ESPRESSO =
            "androidx.test.espresso:espresso-core:${Constants.Dependency.TEST_ESPRESSO}"
        const val TEST_EXT_JUNIT = "androidx.test.ext:junit:${Constants.Dependency.TEST_EXT_JUNIT}"
        const val TEST_JUNIT = "junit:junit:${Constants.Dependency.TEST_JUNIT}"
    }

    fun addLibOpenSourceDependencies(project: Project) {
        project.dependencies.apply {
            api(
                project.fileTree(
                    mapOf(
                        "dir" to "libs",
                        "include" to listOf("*.jar", "*.aar")
                    )
                )
            )
            api(AndroidX.ANNOTATION)
            api(AndroidX.APP_COMPAT)
            api(AndroidX.CONSTRAINT_LAYOUT)
            api(AndroidX.CORE_KTX)
            api(AndroidX.FRAGMENT_KTX)
            api(AndroidX.LIFECYCLE_LIVEDATA_KTX)
            api(AndroidX.LIFECYCLE_RUNTIME_KTX)
            api(AndroidX.LIFECYCLE_VIEWMODEL_KTX)
            api(AndroidX.MATERIAL_DESIGN)
            api(AndroidX.PAGING)
            api(AndroidX.ROOM_KTX)
            api(AndroidX.ROOM_RUNTIME)
            api(AndroidX.WORK_MANAGER_KTX)
            api(AndroidX.SECURITY_CRYPTO)
            api(Glide.GLIDE)
            api(Misc.EVENT_BUS)
            api(Misc.KOTLIN_STDLIB)
            api(Misc.LOGGER)
            api(Misc.VIEW_BINDING_PROPERTY_DELEGATE)
            api(Network.RETROFIT_MOSHI_CONVERTER)
            api(Network.MOSHI)
            api(Network.RETROFIT)
            api(Network.OKHTTP)
            api(Network.OKHTTP_LOGGING)
            testApi(Test.TEST_JUNIT)
            androidTestApi(Test.TEST_ESPRESSO)
            androidTestApi(Test.TEST_EXT_JUNIT)
            debugImplementation(Misc.DEBUGGER)
        }
        addExtLibsSource(project)
    }

    fun addCommonDependencies(project: Project) {
        project.dependencies.apply {
            kapt(Glide.GLIDE_COMPILER)
            addDependencyInjection()
            apiProject(Constants.Module.LIB_DATA_SOURCE, true)
        }
    }

    fun addDataDependencies(project: Project) {
        project.dependencies.apply {
            apiProject(Constants.Module.LIB_BASE_SOURCE, true)
            kapt(AndroidX.ROOM_COMPILER)
            addDependencyInjection()
        }
        addExtLibsSource(project)
    }

    fun addExtLibsSource(project: Project) {
        project.dependencies.apply {
            implementation(
                project.fileTree(
                    mapOf(
                        "dir" to "libs",
                        "include" to listOf("*.jar", "*.aar")
                    )
                )
            )
        }
    }

    fun DependencyHandler.implementation(dependencyNotation: Any) {
        this.add("implementation", dependencyNotation)
    }

    fun DependencyHandler.implementationProject(projectPath: String, fromLibFolder: Boolean = false) {
        if (fromLibFolder) {
            this.implementation(this.project("path" to ":libs:$projectPath"))
        } else {
            this.implementation(this.project("path" to ":$projectPath"))
        }
    }

    fun DependencyHandler.kapt(dependencyNotation: Any) {
        this.add("kapt", dependencyNotation)
    }

    private fun DependencyHandler.addDependencyInjection() {
        implementation(Hilt.HILT)
        kapt(Hilt.HILT_COMPILER)
        implementation(Router.AROUTER)
        kapt(Router.AROUTER_COMPILER)
    }

    private fun DependencyHandler.debugImplementation(dependencyNotation: Any) {
        this.add("debugImplementation", dependencyNotation)
    }

    private fun DependencyHandler.api(dependencyNotation: Any) {
        this.add("api", dependencyNotation)
    }

    private fun DependencyHandler.apiProject(projectPath: String, fromLibFolder: Boolean = false) {
        if (fromLibFolder) {
            this.api(this.project("path" to ":libs:$projectPath"))
        } else {
            this.api(this.project("path" to ":$projectPath"))
        }
    }

    private fun DependencyHandler.testApi(dependencyNotation: Any) {
        this.add("testApi", dependencyNotation)
    }

    private fun DependencyHandler.androidTestApi(dependencyNotation: Any) {
        this.add("androidTestApi", dependencyNotation)
    }
}

