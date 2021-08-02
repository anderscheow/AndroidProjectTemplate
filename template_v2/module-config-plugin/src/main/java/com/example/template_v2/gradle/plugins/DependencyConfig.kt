package com.example.template_v2.gradle.plugins

import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

object DependencyConfig {

    object AndroidX {
        const val annotation = "androidx.annotation:annotation:${Constants.Dependency.annotation}"
        const val appcompat = "androidx.appcompat:appcompat:${Constants.Dependency.appcompat}"
        const val constraint_layout =
            "androidx.constraintlayout:constraintlayout:${Constants.Dependency.constraint_layout}"
        const val core_ktx = "androidx.core:core-ktx:${Constants.Dependency.core_ktx}"
        const val fragment_ktx =
            "androidx.fragment:fragment-ktx:${Constants.Dependency.fragment_ktx}"
        const val lifecycle_livedata_ktx =
            "androidx.lifecycle:lifecycle-livedata-ktx:${Constants.Dependency.lifecycle}"
        const val lifecycle_runtime_ktx =
            "androidx.lifecycle:lifecycle-runtime-ktx:${Constants.Dependency.lifecycle}"
        const val lifecycle_viewmodel_ktx =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:${Constants.Dependency.lifecycle}"
        const val material_design =
            "com.google.android.material:material:${Constants.Dependency.material_design}"
        const val paging = "androidx.paging:paging-runtime-ktx:${Constants.Dependency.paging}"
        const val room_compiler = "androidx.room:room-compiler:${Constants.Dependency.room}"
        const val room_ktx = "androidx.room:room-ktx:${Constants.Dependency.room}"
        const val room_runtime = "androidx.room:room-runtime:${Constants.Dependency.room}"
        const val workmanager_ktx =
            "androidx.work:work-runtime-ktx:${Constants.Dependency.workmanager}"
        const val security_crypto =
            "androidx.security:security-crypto:${Constants.Dependency.crypto}"
    }

    object Glide {
        const val glide = "com.github.bumptech.glide:glide:${Constants.Dependency.glide}"
        const val glide_compiler =
            "com.github.bumptech.glide:compiler:${Constants.Dependency.glide}"
    }

    object Hilt {
        const val hilt = "com.google.dagger:hilt-android:${Constants.Dependency.hilt}"
        const val hilt_compiler = "com.google.dagger:hilt-compiler:${Constants.Dependency.hilt}"
    }

    object Misc {
        const val debugger = "com.amitshekhar.android:debug-db:${Constants.Dependency.debugger}"
        const val event_bus = "org.greenrobot:eventbus:${Constants.Dependency.event_bus}"
        const val kotlin_stdlib =
            "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Constants.Dependency.kotlin}"
        const val logger = "com.orhanobut:logger:${Constants.Dependency.logger}"
    }

    object Network {
        const val moshi = "com.squareup.moshi:moshi-kotlin:${Constants.Dependency.moshi}"
        const val moshi_converter =
            "com.squareup.retrofit2:converter-moshi:${Constants.Dependency.retrofit}"
        const val retrofit = "com.squareup.retrofit2:retrofit:${Constants.Dependency.retrofit}"
        const val okhttp = "com.squareup.okhttp3:okhttp:${Constants.Dependency.okHttp}"
        const val okhttp_logging =
            "com.squareup.okhttp3:logging-interceptor:${Constants.Dependency.okHttp}"
    }

    object Router {
        const val aRouter = "com.alibaba:arouter-api:${Constants.Dependency.aRouter}"
        const val aRouter_compiler = "com.alibaba:arouter-compiler:${Constants.Dependency.aRouter}"
    }

    object Test {
        const val test_espresso =
            "androidx.test.espresso:espresso-core:${Constants.Dependency.test_espresso}"
        const val test_ext_junit = "androidx.test.ext:junit:${Constants.Dependency.test_ext_junit}"
        const val test_junit = "junit:junit:${Constants.Dependency.test_junit}"
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
            api(AndroidX.annotation)
            api(AndroidX.appcompat)
            api(AndroidX.constraint_layout)
            api(AndroidX.core_ktx)
            api(AndroidX.fragment_ktx)
            api(AndroidX.lifecycle_livedata_ktx)
            api(AndroidX.lifecycle_runtime_ktx)
            api(AndroidX.lifecycle_viewmodel_ktx)
            api(AndroidX.material_design)
            api(AndroidX.paging)
            api(AndroidX.room_ktx)
            api(AndroidX.room_runtime)
            api(AndroidX.workmanager_ktx)
            api(AndroidX.security_crypto)
            api(Glide.glide)
            api(Misc.event_bus)
            api(Misc.kotlin_stdlib)
            api(Misc.logger)
            api(Network.moshi_converter)
            api(Network.moshi)
            api(Network.retrofit)
            api(Network.okhttp)
            api(Network.okhttp_logging)
            testApi(Test.test_junit)
            androidTestApi(Test.test_espresso)
            androidTestApi(Test.test_ext_junit)
            debugImplementation(Misc.debugger)
        }
        addExtLibsSource(project)
    }

    fun addCommonDependencies(project: Project) {
        project.dependencies.apply {
            apiProject(":libs:lib_base_source")
            kapt(Glide.glide_compiler)
            addDependencyInjection()
            apiProject(":libs:lib_data_source")
        }
    }

    fun addDataDependencies(project: Project) {
        project.dependencies.apply {
            implementationProject(":libs:lib_base_source")
            kapt(AndroidX.room_compiler)
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

    fun DependencyHandler.implementationProject(projectPath: String) {
        this.implementation(this.project("path" to projectPath))
    }

    fun DependencyHandler.kapt(dependencyNotation: Any) {
        this.add("kapt", dependencyNotation)
    }

    private fun DependencyHandler.addDependencyInjection() {
        implementation(Hilt.hilt)
        kapt(Hilt.hilt_compiler)
        implementation(Router.aRouter)
        kapt(Router.aRouter_compiler)
    }

    private fun DependencyHandler.debugImplementation(dependencyNotation: Any) {
        this.add("debugImplementation", dependencyNotation)
    }

    private fun DependencyHandler.api(dependencyNotation: Any) {
        this.add("api", dependencyNotation)
    }

    private fun DependencyHandler.apiProject(projectPath: String) {
        this.api(this.project("path" to projectPath))
    }

    private fun DependencyHandler.testApi(dependencyNotation: Any) {
        this.add("testApi", dependencyNotation)
    }

    private fun DependencyHandler.androidTestApi(dependencyNotation: Any) {
        this.add("androidTestApi", dependencyNotation)
    }
}

