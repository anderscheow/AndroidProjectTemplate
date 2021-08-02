package com.example.template_v2.gradle.plugins

object Constants {

    /**
     * To make module (feature_one) to be build as application or library
     *
     *  true => build as application
     *  false => build as library
     */
    const val isBuildModule = true

    object App {
        const val applicationId = "com.example.template_v2"
        const val build_tools = "30.0.2"
        const val compile_sdk = 30
        const val min_sdk = 21
        const val version_code = 1
        const val version_name = "1.0.0"
        const val target_sdk = 30
    }

    object Dependency {
        const val aRouter = "1.5.1"
        const val annotation = "1.2.0"
        const val appcompat = "1.3.0"
        const val constraint_layout = "2.0.4"
        const val core_ktx = "1.3.2"
        const val crypto = "1.1.0-alpha01"
        const val debugger = "1.0.6"
        const val event_bus = "3.2.0"
        const val fragment_ktx = "1.3.4"
        const val glide = "4.12.0"
        const val hilt = "2.35"
        const val kotlin = "1.5.0"
        const val lifecycle = "2.4.0-alpha02"
        const val logger = "2.2.0"
        const val material_design = "1.3.0"
        const val moshi = "1.12.0"
        const val okHttp = "4.9.0"
        const val paging = "3.0.0"
        const val retrofit = "2.9.0"
        const val room = "2.3.0"
        const val test_espresso = "3.3.0"
        const val test_ext_junit = "1.1.2"
        const val test_junit = "4.13.2"
        const val workmanager = "2.5.0"
    }
}