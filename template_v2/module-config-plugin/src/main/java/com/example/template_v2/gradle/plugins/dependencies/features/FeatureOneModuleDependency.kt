package com.example.template_v2.gradle.plugins.dependencies.features

import com.example.template_v2.gradle.plugins.Constants
import com.example.template_v2.gradle.plugins.configs.DependencyConfig
import com.example.template_v2.gradle.plugins.configs.PluginConfig
import com.example.template_v2.gradle.plugins.dependencies.base.BaseModuleDependency
import org.gradle.api.Project

class FeatureOneModuleDependency(project: Project) : BaseModuleDependency(project) {

    init {
        when (project.name) {
            Constants.Module.FEATURE_ONE -> {
                PluginConfig.addModulePlugins(project.plugins)
                addDependencyInjection()
                DependencyConfig.addExtLibsSource(project)
                addModuleAndroidConfig(Constants.SubApplicationId.FEATURE_ONE)
                implementProjects(
                    listOf(
                        Constants.Module.FEATURE_ONE_API,
                        Constants.Module.COMMON,
                        Constants.Module.MAIN,
                        Constants.Module.MAIN_API
                    )
                )
            }

            Constants.Module.FEATURE_ONE_API -> {
                PluginConfig.addApiPlugin(project.plugins)
                addAndroidConfig()
                addApiDependencies()
            }
        }
        configureKapt()
    }
}

