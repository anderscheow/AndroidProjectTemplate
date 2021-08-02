package com.example.template_v2.gradle.plugins.dependencies

import com.android.build.gradle.BaseExtension
import com.example.template_v2.gradle.plugins.AndroidConfig
import com.example.template_v2.gradle.plugins.DependencyConfig
import com.example.template_v2.gradle.plugins.DependencyConfig.implementation
import com.example.template_v2.gradle.plugins.DependencyConfig.implementationProject
import com.example.template_v2.gradle.plugins.DependencyConfig.kapt
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
            for (index in projectPaths.indices) {
                implementationProject(":${projectPaths[index]}")
            }
        }
    }

    internal fun implementDependencies(dependencyPaths: List<String>) {
        project.dependencies.apply {
            for (index in dependencyPaths.indices) {
                implementation(dependencyPaths[index])
            }
        }
    }

    internal fun addAnnotationDependencies(dependencyPaths: List<String>) {
        project.dependencies.apply {
            for (index in dependencyPaths.indices) {
                kapt(dependencyPaths[index])
            }
        }
    }

    internal fun addApiDependencies() {
        implementProjects(listOf(":common"))
        addDependencyInjection()
        DependencyConfig.addExtLibsSource(project)
    }

    internal fun addDependencyInjection() {
        implementDependencies(
            listOf(
                DependencyConfig.Hilt.hilt,
                DependencyConfig.Router.aRouter
            )
        )
        addAnnotationDependencies(
            listOf(
                DependencyConfig.Hilt.hilt_compiler,
                DependencyConfig.Router.aRouter_compiler
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