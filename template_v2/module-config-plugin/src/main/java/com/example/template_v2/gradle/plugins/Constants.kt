package com.example.template_v2.gradle.plugins

object Constants {

    /**
     * To make module (feature_one) to be build as application or library
     *
     *  true => build as application
     *  false => build as library
     */
    const val IS_BUILD_MODULE = true

    object App {
        const val APPLICATION_ID = "com.example.template_v2"
        const val BUILD_TOOLS = "30.0.2"
        const val COMPILE_SDK = 30
        const val MIN_SDK = 21
        const val VERSION_CODE = 1
        const val VERSION_NAME = "1.0.0"
        const val TARGET_SDK = 30
    }

    object Dependency {
        const val AROUTER = "1.5.1"
        const val ANNOTATION = "1.2.0"
        const val APP_COMPAT = "1.3.0"
        const val CONSTRAINT_LAYOUT = "2.0.4"
        const val CORE_KTX = "1.3.2"
        const val DEBUGGER = "1.0.6"
        const val EVENT_BUS = "3.2.0"
        const val FRAGMENT_KTX = "1.3.4"
        const val GLIDE = "4.12.0"
        const val HILT = "2.38.1"
        const val KOTLIN = "1.5.0"
        const val LIFECYCLE = "2.4.0-alpha02"
        const val LOGGER = "2.2.0"
        const val MATERIAL_DESIGN = "1.3.0"
        const val MOSHI = "1.12.0"
        const val OKHTTP = "4.9.0"
        const val PAGING = "3.0.0"
        const val RETROFIT = "2.9.0"
        const val ROOM = "2.3.0"
        const val SECURITY_CRYPTO = "1.1.0-alpha01"
        const val TEST_ESPRESSO = "3.3.0"
        const val TEST_EXT_JUNIT = "1.1.2"
        const val TEST_JUNIT = "4.13.2"
        const val WORK_MANAGER = "2.5.0"
    }

    object Module {
        const val APP = "app"
        const val COMMON = "common"
        const val FEATURE_ONE = "feature_one"
        const val FEATURE_ONE_API = "feature_one_api"
        const val LIB_BASE_SOURCE = "lib_base_source"
        const val LIB_DATA_SOURCE = "lib_data_source"
        const val MAIN = "main"
        const val MAIN_API = "main_api"
    }

    object SubApplicationId {
        const val FEATURE_ONE = "feature_one"
    }
}