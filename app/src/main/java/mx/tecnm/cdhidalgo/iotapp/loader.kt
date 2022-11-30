package mx.tecnm.cdhidalgo.iotapp

import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.view.animation.Animation
import android.widget.ImageView
import android.widget.TextView
import android.os.Handler;
import android.view.View
import android.util.Pair as UtilPair;

class loader : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

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
//            val pairs: Pair[2];
//            pairs[0] = Pair<View, String>(logoImageView, "logoImageTransition")
//            pairs[1] = Pair<View, String>(hydroblasTextView, "bienvenidoTextTransition")

          //  var pairs3: Pair<View, String>
            //pairs3.first
//            var pairs2 = listOf<Pair<View, String>>(
//                Pair<View, String>(logoImageView, "logoImageTransition"),
//                Pair<View, String>(hydroblasTextView, "bienvenidoTextTransition")
//            )

//            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
//                val options = ActivityOptions.makeSceneTransitionAnimation(this,
//                    UtilPair.create(view1, "agreedName1"),
//                    UtilPair.create(view2, "agreedName2"))
////               var options: ActivityOptions
////               options = ActivityOptions.makeSceneTransitionAnimation(this, pairs2 );
//            }


            startActivity(Intent(this,MainActivity::class.java))
        }, 4000)


    }
}