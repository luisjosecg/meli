package com.w.buscador.view.activitie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.w.buscador.R
import com.w.buscador.view.fragments.BuscadorResulltadoFragment
import com.w.buscador.util.FragmentUtil

class BuscadorMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buscador_main)
        FragmentUtil.replaceFragment(savedInstanceState, this.supportFragmentManager, R.id.root_container, BuscadorResulltadoFragment.newInstance())
    }


    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
