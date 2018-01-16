package newton.com.animaisdafazenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listaAnimais;
    private String[] animais = {
            "Galinha","Porco","Boi","Vacas","Bezerros(as)","Patos","Perus","Eguas","Cavalos","Peixes"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaAnimais = findViewById(R.id.listId);

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
