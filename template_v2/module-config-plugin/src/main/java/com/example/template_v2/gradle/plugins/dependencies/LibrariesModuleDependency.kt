package com.example.template_v2.gradle.plugins.dependencies

import com.example.template_v2.gradle.plugins.AndroidConfig
import com.example.template_v2.gradle.plugins.DependencyConfig
import com.example.template_v2.gradle.plugins.PluginConfig
import org.gradle.api.Project

class LibrariesModuleDependency(project: Project) : BaseModuleDependency(project) {

    companion object {
        const val COMMON_MODULE = "common"
        const val API_SOURCE_MODULE = "lib_base_source"
        const val DATA_MODULE = "lib_data_source"
    }

    init {
        PluginConfig.addLibraryPlugins(project.plugins)
        addAndroidConfig()
        when (project.name) {
            API_SOURCE_MODULE -> {
                DependencyConfig.addLibOpenSourceDependencies(project)
            }

            COMMON_MODULE -> {
                PluginConfig.addHiltPlugin(project.plugins)
                getExtension().apply {
                    AndroidConfig.Extra.addViewBinding(this)
                }
                DependencyConfig.addCommonDependencies(project)
            }

            DATA_MODULE -> {
                DependencyConfig.addDataDependencies(project)
            }
        }
        configureKapt()
    }
}