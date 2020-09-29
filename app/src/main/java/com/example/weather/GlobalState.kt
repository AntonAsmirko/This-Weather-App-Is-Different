package com.example.weather

object GlobalState {
    enum class Theme{
        DARK, LIGHT
    }

    enum class Orientation{
        HORIZONTAL, VERTICAL
    }

    var currentTheme = Theme.LIGHT
    var orientation = Orientation.VERTICAL
}