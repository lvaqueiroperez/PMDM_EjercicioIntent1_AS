package com.ejemploapp2.ejerciciointent1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //SIN FUNCIÓN, DIRECTAMENTE CON LISTENER (habría que crear un listener con todas esas líneas para cada botón)

        """btnAm.setOnClickListener {
            val miIntent = Intent(this, ActivityDetalle::class.java)

            miIntent.putExtra("color", "amarillo")

            startActivity(miIntent)

        }"""


        //USANDO EL MÉTODO DE LAS FUNCIONES, LOS LISTENER SE CREAN EN ONCREATE !!!
        btnAm.setOnClickListener { cambiarDetalle(it) }
        btnRojo.setOnClickListener { cambiarDetalle(it) }

    }

    //USANDO UNA FUNCIÓN EN VEZ DEL LISTENER (así no tenemos que crear 2 listeners)
    //como los botones y cualquier otro elemento de la interfaz extienden de View,
    //FUNCIONES A PARTE FUERA DE ON CREATRE, NO METER FUNCIONES DENTRO DE FUNCIONES (no normalmente)
    fun cambiarDetalle(v: View) {

        //recogemos los botones en una variable y los casteamos de View a Button
        val botonAux = v as Button

        val miIntent = Intent(this, ActivityDetalle::class.java)

        if (botonAux == btnAm) {

            miIntent.putExtra("color", "amarillo")

            startActivity(miIntent)

        } else if (botonAux == btnRojo) {

            miIntent.putExtra("color", "rojo")
            startActivity(miIntent)


        }


    }
}
