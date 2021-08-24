package com.example.template_v2.gradle.plugins.configs

import com.example.template_v2.gradle.plugins.Constants
import org.gradle.api.plugins.PluginContainer

object PluginConfig {

    private const val android_application = "com.android.application"
    private const val android_library = "com.android.library"
    private const val dagger_hilt = "dagger.hilt.android.plugin"
    private const val kotlin_android = "kotlin-android"
    private const val kotlin_kapt = "kotlin-kapt"
    private const val kotlin_parcelize = "kotlin-parcelize"

    private fun addBasicPlugins(pluginContainer: PluginContainer) {
        pluginContainer.apply {
            apply(kotlin_android)
            apply(kotlin_kapt)
            apply(kotlin_parcelize)
        }
    }

    fun addHiltPlugin(pluginContainer: PluginContainer) {
        pluginContainer.apply {
            apply(dagger_hilt)
        }
    }

    fun addAppPlugins(pluginContainer: PluginContainer) {
        pluginContainer.apply {
            apply(android_application)
            addHiltPlugin(pluginContainer)
            addBasicPlugins(pluginContainer)
        }
    }

    fun addLibraryPlugins(pluginContainer: PluginContainer) {
        pluginContainer.apply {
            apply(android_library)
            addBasicPlugins(pluginContainer)
        }
    }

    fun addModulePlugins(pluginContainer: PluginContainer) {
        pluginContainer.apply {
            if (Constants.IS_BUILD_MODULE) {
                addAppPlugins(pluginContainer)
            } else {
                addHiltPlugin(pluginContainer)
                addLibraryPlugins(pluginContainer)
            }
        }
    }

    fun addApiPlugin(pluginContainer: PluginContainer) {
        pluginContainer.apply {
            apply(android_library)
            addBasicPlugins(pluginContainer)
            addHiltPlugin(pluginContainer)
        }
    }
}