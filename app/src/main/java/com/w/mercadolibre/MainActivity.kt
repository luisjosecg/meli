package com.w.mercadolibre

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    /**
     * Se implementaron dos modulos uno para Search y otro para el Product Page.
     * Arquitectura para el modulo de Search (buscador) MVVM
     * Documentacion: @see = https://developer.android.com/jetpack/docs/guide?hl=es-419#recommended-app-arch
     * Arquitectura para el modulo de ProductPage (detalle) MVP
     * Principios comunes de arquitectura: @see https://developer.android.com/jetpack/docs/guide?hl=es-419#separation-of-concerns
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}