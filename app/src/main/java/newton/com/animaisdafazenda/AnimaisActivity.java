package newton.com.animaisdafazenda;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AnimaisActivity extends Activity {
    final int MILISEGUNDOS = 2500;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animais);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent i = new Intent(AnimaisActivity.this, MainActivity.class);
                AnimaisActivity.this.startActivity(i);
            }
        }, MILISEGUNDOS);
    }

}
