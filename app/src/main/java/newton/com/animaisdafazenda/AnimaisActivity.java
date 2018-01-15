package newton.com.animaisdafazenda;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class AnimaisActivity extends Activity {
    final int MILISEGUNDOS = 2500;
    SQLiteDatabase bancoDeDados;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animais);

        //criando o banco de dados
        bancoDeDados = openOrCreateDatabase("Banco", Context.MODE_PRIVATE,null);
        bancoDeDados.execSQL("CREATE TABLE IF NOT EXISTS tbl_animais (Codigo INT NOT NULL,Nome VARCHAR, Especie VARCHAR, Porte VARCHAR)");


        //inserir os dados
        /*
        bancoDeDados.execSQL("INSERT INTO tbl_animais VALUES ('1','Galinha','Aves','Pequeno');");
        bancoDeDados.execSQL("INSERT INTO tbl_animais VALUES ('2','Porco','Suino','Medio');");
        bancoDeDados.execSQL("INSERT INTO tbl_animais VALUES ('3','Boi','Bovino','Grande');");
        bancoDeDados.execSQL("INSERT INTO tbl_animais VALUES ('4','Vaca','Bovino','Grande');");
        bancoDeDados.execSQL("INSERT INTO tbl_animais VALUES ('5','Bezerra','Bovino','Medio');");
        bancoDeDados.execSQL("INSERT INTO tbl_animais VALUES ('6','Patos','Aves','Pequeno');");
        bancoDeDados.execSQL("INSERT INTO tbl_animais VALUES ('7','Peru','Aves','Pequeno');");
        bancoDeDados.execSQL("INSERT INTO tbl_animais VALUES ('8','Egua','Equino','Grande');");
        bancoDeDados.execSQL("INSERT INTO tbl_animais VALUES ('9','Cavalo','Equino','Grande');");
        bancoDeDados.execSQL("INSERT INTO tbl_animais VALUES ('10','Peixe','Peixes','Medio');");
        */


        //contador de tempo pra ir pra tela do main
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent i = new Intent(AnimaisActivity.this, MainActivity.class);
                AnimaisActivity.this.startActivity(i);
            }
        }, MILISEGUNDOS);
    }

}
