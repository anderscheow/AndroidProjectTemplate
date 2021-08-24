package com.example.template_v2.gradle.plugins.dependencies

import com.example.template_v2.gradle.plugins.Constants
import com.example.template_v2.gradle.plugins.configs.AndroidConfig
import com.example.template_v2.gradle.plugins.configs.PluginConfig
import com.example.template_v2.gradle.plugins.dependencies.base.BaseModuleDependency
import org.gradle.api.Project

class ApplicationDependency(project: Project) : BaseModuleDependency(project) {

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
        implementProjects(listOf(Constants.Module.COMMON, Constants.Module.MAIN))
        configureKapt()
    }
}