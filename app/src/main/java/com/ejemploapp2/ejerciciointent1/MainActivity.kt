package com.ejemploapp2.ejerciciointent1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.browse
import org.jetbrains.anko.db.INTEGER
import java.lang.Integer.parseInt

//CONSTANTE GLOBAL PARA EL EJERCICIO DE LA SUMA
const val SUMA_REQUEST = 1

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


        //USANDO EL MÉTODO DE LAS FUNCIONES:
        //En "OnCreate()", creamos un "onClickListener()" para cada botón que usemos y
        //dentro de los CORCHETES del listener, llamamos a la función que contendrá el código que hará
        //cambiar de Actividad etc
        //OJO!!! "it" es una referencia a la variable/objeto con la que estamos llamando, en este caso, al listener (it = nuestros botones)
        btnAm.setOnClickListener { cambiarDetalle(it) }
        btnRojo.setOnClickListener { cambiarDetalle(it) }

        //PARA ACCEDER A LA URL: (AÑADIR HTTP://)
        btnUrl.setOnClickListener { browse("http://www.google.com") }

        //PARA ACCEDER A LA FUNCION SUMAR:
        btnSuma.setOnClickListener { sumar(it) }

    }

    //USANDO UNA FUNCIÓN EN VEZ DEL LISTENER (así no tenemos que crear 2 listeners):
    //FUNCIONES FUERA DE ON CREATRE, NO METER FUNCIONES DENTRO DE FUNCIONES (no normalmente)
    //Como los botones y cualquier otro elemento de la interfaz extienden de View, podemos guardar
    //un botón en una variable de tipo View y castear variables View a cualquier otro componente que herede de view

    fun cambiarDetalle(v: View) {

        //recogemos los botones en  el parámetro "v" y los casteamos de View a Button (y los ponemos en una variable)
        val botonAux = v as Button
        //creamos una variable que contenga el Intent (builder de Intent según la página de Anko en GitHub)
        val miIntent = Intent(this, ActivityDetalle::class.java)
        //Para diferenciar con qué botón estamos accediendo, hacemos un if simple:
        if (botonAux == btnAm) {
            //El intent funciona como una especie de "HashMap", con una Clave y un Valor
            //Añadimos un elemento o "extra" al Intent por cada valor con el que queramos trabajar:
            miIntent.putExtra("color", "amarillo")
            //Y lanzamos la Activity deseada (que recibirá los datos del Intent)
            //Esto es útil para pasar y guardar datos de una Actividad a otra
            startActivity(miIntent)

        } else if (botonAux == btnRojo) {

            miIntent.putExtra("color", "rojo")
            startActivity(miIntent)


        }


    }

    fun sumar(v: View) {

        val botonAux = v as Button

        val miIntent = Intent(this, ActivitySumar::class.java)

        miIntent.putExtra("num1", num1.text)
        miIntent.putExtra("num2", num2.text)



        startActivityForResult(miIntent, SUMA_REQUEST)


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1) {

            if (requestCode == Activity.RESULT_OK) {

                if (data != null) {

                    result1.setText(data.getIntExtra("result", 0))

                }


            }

        }
    }


    //Gracias a Anko, el builder del Intent se puede simplificar en una línea: PENDIENTE
    /*fun cambiarDetalle(v : View){

        startActivity<ActivityDetalle::class.java>("color" to "amarillo")

    }
     */

    //EJERCICIO DE SUMA:


}
