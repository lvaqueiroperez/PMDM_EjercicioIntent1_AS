package com.ejemploapp2.ejerciciointent1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detalle.*

class ActivityDetalle : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)

        //Para recoger los valores "extras" de otra Actividad a través de su Intent:
        val valor = intent.getStringExtra("color")
        miColorText.setText(valor)
        if (valor == "amarillo") {

            miColorText.setTextColor(Color.YELLOW)

        } else if (valor == "rojo") {

            miColorText.setTextColor(Color.RED)

        }


    }
}
