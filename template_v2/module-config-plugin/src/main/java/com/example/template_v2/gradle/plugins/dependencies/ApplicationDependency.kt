package com.example.template_v2.gradle.plugins.dependencies

import com.example.template_v2.gradle.plugins.AndroidConfig
import com.example.template_v2.gradle.plugins.PluginConfig
import org.gradle.api.Project

class ApplicationDependency(project: Project) : BaseModuleDependency(project) {
    companion object {
        const val APP_MODULE = "app"
    }

    init {
        PluginConfig.addAppPlugins(project.plugins)
        addDependencyInjection()
        addAndroidConfig()
        getExtension().apply {
            AndroidConfig.Module.addApplicationConfig(this)
            AndroidConfig.BuildType.addModuleBuildType(this)
            AndroidConfig.ProductFlavors.addBasicProductFlavor(this, project.plugins)
            AndroidConfig.Extra.addViewBinding(this)
        }
        implementProjects(listOf(":common", MainModuleDependency.MAIN_MODULE))
        configureKapt()
    }
}