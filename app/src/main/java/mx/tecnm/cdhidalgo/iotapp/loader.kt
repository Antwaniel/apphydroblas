package mx.tecnm.cdhidalgo.iotapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.view.animation.Animation
import android.widget.ImageView
import android.widget.TextView
import android.os.Handler;

class loader : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_loader)

        var animacion:Animation;
        var animacion2:Animation;

         animacion = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_arriba);
        animacion2 =AnimationUtils.loadAnimation(this, R.anim.desplazamiento_abajo);


         var  hydroblasTextView:TextView;
        var logoImageView: ImageView;

        hydroblasTextView=findViewById(R.id.hydroblasTextView)
        logoImageView=findViewById(R.id.logoImageView)


        hydroblasTextView.setAnimation(animacion2);
        logoImageView.setAnimation(animacion);

        val handler = Handler()
        handler.postDelayed({
            // do something after 1000ms
            startActivity(Intent(this,MainActivity::class.java))
        }, 4000)


    }
}