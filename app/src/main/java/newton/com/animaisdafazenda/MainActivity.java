package newton.com.animaisdafazenda;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.sql.SQLClientInfoException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listaAnimais;
    SQLiteDatabase bancoDeDados;
    private ArrayList<String> animais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animais = new ArrayList<String>();
        bancoDeDados = openOrCreateDatabase("Banco", Context.MODE_PRIVATE,null);
        listaAnimais = findViewById(R.id.listId);

        Cursor c = bancoDeDados.rawQuery("SELECT Nome FROM tbl_animais",null);
        c.moveToFirst();
        do{
            this.animais.add(c.getString(0));
        }while(c.moveToNext());

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,android.R.layout.simple_expandable_list_item_1,android.R.id.text1,animais
        );

        listaAnimais.setAdapter(adapter);

        listaAnimais.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int posicao = i;
                String identidade = String.valueOf(posicao);
                Intent intent = new Intent(MainActivity.this,DescricaoActivity.class);
                intent.putExtra("identificador",identidade);
                startActivity(intent);

            }
        });

    }
}
