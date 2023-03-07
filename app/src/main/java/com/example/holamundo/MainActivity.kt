package com.example.holamundo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.time.temporal.TemporalQueries

class MainActivity : AppCompatActivity() {
    protected var contador : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtcuenta: TextView = findViewById<TextView>(R.id.activity_main_contador)
        if (savedInstanceState != null){
            contador = savedInstanceState.getInt("conta")
        }
        txtcuenta.text = contador.toString()

        Log.e("Miapp","onCreate()")
    }

        override fun onStart() {
            super.onStart()
            Log.e("MiApp","onStart")
        }

        override fun onResume(){
            super.onResume()
            Log.e("MiApp","onResume")
        }

        override fun onPause(){
            super.onPause()
            Log.e("MiApp","onPause")
        }

        override fun onStop(){
            super.onStop()
            Log.e("MiApp","onRestart")
        }

        override fun onRestart(){
            super.onRestart()
            Log.e("MiApp","onRestart")
        }

        override fun onDestroy(){
            super.onDestroy()
            Log.e("MiApp","onDestroy")
        }

        fun guardar(view: View){
            val name = findViewById<EditText>(R.id.activity_main_name)
            val phone = findViewById<EditText>(R.id.activity_main_phone)

            var bndName = true
            var bndPhone = true
            name.error = null
            phone.error = null

            if(name.text.toString().trim().isEmpty()){
                bndName = false
                name.error = getString(R.string.activity_main_error)
            }

            if (phone.text.toString().trim().isEmpty()){
                bndPhone = false
                phone.error = getString(R.string.activity_main_error)
            }

            if(bndName && bndPhone)
                Toast.makeText(
                    this@MainActivity,
                    name.text.toString() + ""+phone.text.toString(),
                    Toast.LENGTH_LONG
                ).show()

        }

        fun contar(view: View){
            val txtcuenta: TextView = findViewById<TextView>(R.id.activity_main_contador)
            contador++
            txtcuenta.text = contador.toString()
        }

        override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("conta",contador)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val txtcuenta: TextView = findViewById<TextView>(R.id.activity_main_contador)
        if (savedInstanceState != null){
            contador = savedInstanceState.getInt("conta")
        }
        txtcuenta.text = contador.toString()
    }


}