package com.example.template_v2.main.splash

sealed class SplashState {
    object Init : SplashState()

    object InitialActionCompleted : SplashState()
}