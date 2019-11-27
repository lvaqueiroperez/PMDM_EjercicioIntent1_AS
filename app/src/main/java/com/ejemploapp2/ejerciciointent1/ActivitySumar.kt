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

        val num1 = intent.getIntExtra("num1",0)
        //ponemos un valor por defecto (0)
        val num2 = intent.getIntExtra("num2",0)

        val result = num1 + num2
        val data = Intent()

        data.putExtra("result", result)
        //TENEMOS QUE PONERLO COMO UN STRING
        textoResult.setText(result.toString())

        setResult(Activity.RESULT_OK, data)

        //PARA VOLVER
        btnVolver.setOnClickListener { finish() }


    }
}
