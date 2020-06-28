package com.w.detalle.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.w.detalle.R
import com.w.detalle.util.ConstantsUtil.PRODUCT_ID
import com.w.detalle.util.FragmentUtil.replaceFragment
import com.w.detalle.view.fragments.DetalleFragment
import java.lang.Exception

class DetalleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detalle_activity)
        replaceFragment(savedInstanceState, this.supportFragmentManager, R.id.root_container, DetalleFragment.newInstance())
        getDataIntent(intent)
    }

    private fun getDataIntent(intent : Intent){
        try {
            productId = intent.getStringExtra(PRODUCT_ID)!!
        }catch (e : Exception){
            e.printStackTrace()
            finish()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    companion object DetalleActivityCompanion{
        var productId : String = ""
    }
}
