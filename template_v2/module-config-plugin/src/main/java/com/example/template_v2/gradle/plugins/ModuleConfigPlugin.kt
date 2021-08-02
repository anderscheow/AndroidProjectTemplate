package com.example.template_v2.gradle.plugins

import com.android.build.gradle.BaseExtension
import com.android.build.gradle.api.AndroidBasePlugin
import com.example.template_v2.gradle.plugins.dependencies.*
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions
import org.jetbrains.kotlin.gradle.plugin.KaptExtension

open class ModuleConfigPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        when (target.name) {
            ApplicationDependency.APP_MODULE -> {
                ApplicationDependency(target)
            }

            MainModuleDependency.MAIN_MODULE,
            MainModuleDependency.MAIN_MODULE_API -> {
                MainModuleDependency(target)
            }

            FeatureOneModuleDependency.FEATURE_ONE_MODULE,
            FeatureOneModuleDependency.FEATURE_ONE_MODULE_API -> {
                FeatureOneModuleDependency(target)
            }

            LibrariesModuleDependency.API_SOURCE_MODULE,
            LibrariesModuleDependency.COMMON_MODULE,
            LibrariesModuleDependency.DATA_MODULE -> {
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

