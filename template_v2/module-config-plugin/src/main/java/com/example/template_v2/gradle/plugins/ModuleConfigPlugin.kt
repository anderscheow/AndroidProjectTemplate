package com.example.template_v2.gradle.plugins

import com.android.build.gradle.BaseExtension
import com.android.build.gradle.api.AndroidBasePlugin
import com.example.template_v2.gradle.plugins.dependencies.ApplicationDependency
import com.example.template_v2.gradle.plugins.dependencies.LibrariesModuleDependency
import com.example.template_v2.gradle.plugins.dependencies.MainModuleDependency
import com.example.template_v2.gradle.plugins.dependencies.features.FeatureOneModuleDependency
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions
import org.jetbrains.kotlin.gradle.plugin.KaptExtension

open class ModuleConfigPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        when (target.name) {
            Constants.Module.APP -> {
                ApplicationDependency(target)
            }

            Constants.Module.MAIN,
            Constants.Module.MAIN_API -> {
                MainModuleDependency(target)
            }

            Constants.Module.FEATURE_ONE,
            Constants.Module.FEATURE_ONE_API -> {
                FeatureOneModuleDependency(target)
            }

            Constants.Module.COMMON,
            Constants.Module.LIB_BASE_SOURCE,
            Constants.Module.LIB_DATA_SOURCE -> {
                LibrariesModuleDependency(target)
            }
        }
    }
}

internal fun Project.containsAndroidPlugin(): Boolean {
    return project.plugins.toList().any { plugin -> plugin is AndroidBasePlugin }
}

internal fun BaseExtension.kotlinOptions(configure: KotlinJvmOptions.() -> Unit): Unit =
    (this as ExtensionAware).extensions.configure("kotlinOptions", configure)

internal fun Project.kapt(configure: KaptExtension.() -> Unit): Unit =
    (this as ExtensionAware).extensions.configure("kapt", configure)

