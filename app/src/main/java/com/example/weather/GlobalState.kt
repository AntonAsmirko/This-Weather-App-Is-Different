package com.example.weather

object GlobalState {
    enum class Theme{
        DARK, LIGHT
    }

    var currentTheme = Theme.LIGHT
}