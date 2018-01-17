package newton.com.animaisdafazenda;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DescricaoActivity extends AppCompatActivity {

    TextView id;
    TextView nome;
    TextView especie;
    TextView porte;
    SQLiteDatabase bancoDeDados;
    Button botaoVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descricao);

        bancoDeDados = openOrCreateDatabase("Banco", Context.MODE_PRIVATE,null);

        id = findViewById(R.id.texto_id);
        nome = findViewById(R.id.texto_nome);
        especie = findViewById(R.id.texto_especie);
        porte = findViewById(R.id.texto_porte);
        botaoVoltar = findViewById(R.id.botao_voltar);

        Bundle extra = getIntent().getExtras();
        String codigo = extra.getString("identificador");

        int selecao = Integer.parseInt(codigo);
        selecao = selecao + 1;


        Cursor c = bancoDeDados.rawQuery("SELECT * FROM tbl_animais WHERE Codigo="+selecao,null);
        if (c.moveToFirst()){
            String id1 = c.getString(0);
            String id2 = c.getString(1);
            String id3 = c.getString(2);
            String id4 = c.getString(3);
            id.setText("Codigo de identificação : " + c.getString(0));
            nome.setText("Nome do animal : " + c.getString(1));
            especie.setText("Especie do animal :" + c.getString(2));
            porte.setText("Porte do animal : " + c.getString(3));
        }

        botaoVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
