package com.ejemploapp2.ejerciciointent1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sumar.*

class ActivitySumar : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sumar)


        //PARA MOSTRAR EL RESULTADO DE LA SUMA: (crashea si no lo pasamos bien a int ???? Crashea al trabajar con int???)

        val num1 = intent.getStringExtra("num1")
        //ponemos un valor por defecto (0)
        val num2 = intent.getStringExtra("num2")

        val result = num1 + num2
        val data = Intent()

        data.putExtra("result", result)

        textoResult.setText(result)

        setResult(Activity.RESULT_OK, data)

        //PARA VOLVER
        btnVolver.setOnClickListener { finish() }


    }
}
