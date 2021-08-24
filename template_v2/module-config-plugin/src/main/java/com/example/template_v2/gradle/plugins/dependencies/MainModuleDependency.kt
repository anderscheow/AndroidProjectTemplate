package com.example.template_v2.gradle.plugins.dependencies

import com.example.template_v2.gradle.plugins.Constants
import com.example.template_v2.gradle.plugins.configs.AndroidConfig
import com.example.template_v2.gradle.plugins.configs.PluginConfig
import com.example.template_v2.gradle.plugins.dependencies.base.BaseModuleDependency
import org.gradle.api.Project

class MainModuleDependency(project: Project) : BaseModuleDependency(project) {

    init {
        PluginConfig.addApiPlugin(project.plugins)
        addAndroidConfig()
        configureKapt()
        when (project.name) {
            Constants.Module.MAIN -> {
                addDependencyInjection()
                getExtension().apply {
                    AndroidConfig.Extra.addViewBinding(this)
                }
                implementProjects(
                    listOf(
                        Constants.Module.COMMON,
                        Constants.Module.MAIN_API,
                        Constants.Module.FEATURE_ONE_API
                    )
                )
            }

            Constants.Module.MAIN_API -> {
                addApiDependencies()
            }
        }
    }
}


