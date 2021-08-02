package com.example.template_v2.gradle.plugins.dependencies

import com.example.template_v2.gradle.plugins.AndroidConfig
import com.example.template_v2.gradle.plugins.PluginConfig
import org.gradle.api.Project

class MainModuleDependency(project: Project) : BaseModuleDependency(project) {

    companion object {
        const val MAIN_MODULE = "main"
        const val MAIN_MODULE_API = "main_api"
    }

    init {
        PluginConfig.addApiPlugin(project.plugins)
        addAndroidConfig()
        configureKapt()
        when (project.name) {
            MAIN_MODULE -> {
                addDependencyInjection()
                getExtension().apply {
                    AndroidConfig.Extra.addViewBinding(this)
                }
                implementProjects(
                    listOf(
                        "common",
                        MAIN_MODULE_API,
                        FeatureOneModuleDependency.FEATURE_ONE_MODULE_API
                    )
                )
            }

            MAIN_MODULE_API -> {
                addApiDependencies()
            }
        }
    }
}


