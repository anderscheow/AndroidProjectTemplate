package com.example.template_v2.gradle.plugins.dependencies

import com.example.template_v2.gradle.plugins.Constants
import com.example.template_v2.gradle.plugins.configs.AndroidConfig
import com.example.template_v2.gradle.plugins.configs.DependencyConfig
import com.example.template_v2.gradle.plugins.configs.PluginConfig
import com.example.template_v2.gradle.plugins.dependencies.base.BaseModuleDependency
import org.gradle.api.Project

class LibrariesModuleDependency(project: Project) : BaseModuleDependency(project) {

    init {
        PluginConfig.addLibraryPlugins(project.plugins)
        addAndroidConfig()
        when (project.name) {
            "lib_base_source" -> {
                DependencyConfig.addLibOpenSourceDependencies(project)
            }

            Constants.Module.COMMON -> {
                PluginConfig.addHiltPlugin(project.plugins)
                getExtension().apply {
                    AndroidConfig.Extra.addViewBinding(this)
                }
                DependencyConfig.addCommonDependencies(project)
            }

            "lib_data_source" -> {
                DependencyConfig.addDataDependencies(project)
            }
        }
        configureKapt()
    }
}