package mx.tecnm.cdhidalgo.iotapp

import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.Request
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

//    variables para obtener datos
    private lateinit var email: EditText
    private lateinit var pass: EditText
    private lateinit var button: Button

    //variables de sesion son variables globales
    var sesion: SharedPreferences? = null;


    override fun onCreate(savedInstanceState: Bundle?) {
//        retrasar incio por 2 seg
      //  Thread.sleep(2000);
//        establecer tema
       // setTheme(R.style.Theme_IotApp);


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        asociando variables con elementos de la vista
        email = findViewById(R.id.txtUser);
        pass = findViewById(R.id.txtPass);
        button =  findViewById(R.id.btnIniciar);
        sesion = getSharedPreferences("sesion", 0);
        button.setOnClickListener{
            login()
        }
    }

//    verificar credenciales
    private fun login() {
        val url = Uri.parse(Config.URL + "login.php")
            .buildUpon()
            .appendQueryParameter("email", email.text.toString())
            .appendQueryParameter("pass", pass.text.toString())
            .build().toString()

        val peticion = JsonObjectRequest(
            Request.Method.GET, url, null,
            {response -> respuesta(response) },
            { error ->
                Toast.makeText(this, "Error: "+error.message, Toast.LENGTH_SHORT).show()
            })
        MySingleton.getInstance(applicationContext).addToRequestQueue(peticion)
    }

    private fun respuesta(response: JSONObject?) {
        try {
            if (response!!.getString("status") == "ok"){
                val jwt = response.getString("jwt")
                with (sesion!!.edit()) {
                    putString("email", email.text.toString())
                    putString("token", jwt)
                    apply()
                }
                startActivity(Intent(this,MainActivity2::class.java))
            } else {
                Toast.makeText(this, "Error de email o contraseña", Toast.LENGTH_SHORT).show()
            }
        }catch (e:Exception){}
    }
}