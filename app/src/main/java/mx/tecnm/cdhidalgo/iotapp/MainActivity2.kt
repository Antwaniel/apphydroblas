package mx.tecnm.cdhidalgo.iotapp

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity2 : AppCompatActivity() {
    private lateinit var value: EditText;
    private lateinit var refresh: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        value = findViewById(R.id.txtValue);
        refresh = findViewById(R.id.btnRefresh);
    }

//     private fun read(){
//        val url = Uri.parse(Config.URL + "register.php")
//    }

}