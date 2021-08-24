package com.example.template_v2.gradle.plugins.dependencies.base

import com.android.build.gradle.BaseExtension
import com.example.template_v2.gradle.plugins.Constants
import com.example.template_v2.gradle.plugins.configs.AndroidConfig
import com.example.template_v2.gradle.plugins.configs.DependencyConfig
import com.example.template_v2.gradle.plugins.configs.DependencyConfig.implementation
import com.example.template_v2.gradle.plugins.configs.DependencyConfig.implementationProject
import com.example.template_v2.gradle.plugins.configs.DependencyConfig.kapt
import com.example.template_v2.gradle.plugins.kapt
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

abstract class BaseModuleDependency(private val project: Project) {

    internal fun getExtension(): BaseExtension {
        return project.extensions.getByType()
    }

    internal fun addAndroidConfig() {
        getExtension().run {
            AndroidConfig.Module.setAndroidConfig(this)
            AndroidConfig.BuildType.addApiBuildType(this)
            AndroidConfig.SourceSet.addExtNativeLibSource(this)
        }
    }

    internal fun addModuleAndroidConfig(subApplicationId: String) {
        getExtension().run {
            AndroidConfig.Module.addModuleConfig(this, subApplicationId)
            AndroidConfig.BuildType.addModuleBuildType(this)
            AndroidConfig.SourceSet.addModuleSourceSet(this)
            AndroidConfig.SourceSet.addExtNativeLibSource(this)
            AndroidConfig.Extra.addViewBinding(this)
        }
    }

    internal fun implementProjects(projectPaths: List<String>) {
        project.dependencies.apply {
            projectPaths.forEach { path ->
                implementationProject(path)
            }
        }
    }

    internal fun implementDependencies(dependencyPaths: List<String>) {
        project.dependencies.apply {
            dependencyPaths.forEach { path ->
                implementation(path)
            }
        }
    }

    internal fun addAnnotationDependencies(dependencyPaths: List<String>) {
        project.dependencies.apply {
            dependencyPaths.forEach { path ->
                kapt(path)
            }
        }
    }

    internal fun addApiDependencies() {
        implementProjects(listOf(Constants.Module.COMMON))
        addDependencyInjection()
        DependencyConfig.addExtLibsSource(project)
    }

    internal fun addDependencyInjection() {
        implementDependencies(
            listOf(
                DependencyConfig.Hilt.HILT,
                DependencyConfig.Router.AROUTER
            )
        )
        addAnnotationDependencies(
            listOf(
                DependencyConfig.Hilt.HILT_COMPILER,
                DependencyConfig.Router.AROUTER_COMPILER
            )
        )
    }

    internal fun configureKapt() {
        project.kapt {
            correctErrorTypes = true
            arguments {
                arg("AROUTER_MODULE_NAME", project.name)
                arg("room.schemaLocation", "${project.projectDir}/schemas")
            }
        }
    }
}