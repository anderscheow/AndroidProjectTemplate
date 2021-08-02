package com.example.template_v2.gradle.plugins.dependencies

import com.example.template_v2.gradle.plugins.DependencyConfig
import com.example.template_v2.gradle.plugins.PluginConfig
import org.gradle.api.Project

class FeatureOneModuleDependency(project: Project) : BaseModuleDependency(project) {

    companion object {
        const val FEATURE_ONE_MODULE = "feature_one"
        const val FEATURE_ONE_MODULE_API = "feature_one_api"
    }

    init {
        when (project.name) {
            FEATURE_ONE_MODULE -> {
                PluginConfig.addModulePlugins(project.plugins)
                addDependencyInjection()
                DependencyConfig.addExtLibsSource(project)
                addModuleAndroidConfig("feature_pne")
                implementProjects(
                    listOf(
                        FEATURE_ONE_MODULE_API,
                        "common",
                        MainModuleDependency.MAIN_MODULE,
                        MainModuleDependency.MAIN_MODULE_API
                    )
                )
            }

            FEATURE_ONE_MODULE_API -> {
                PluginConfig.addApiPlugin(project.plugins)
                addAndroidConfig()
                addApiDependencies()
            }
        }
        configureKapt()
    }
}

