package com.example.exercicio_2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetalhesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalhes_activity);

        String nome = getIntent().getStringExtra("nome");
        String data = getIntent().getStringExtra("data");
        String preco = getIntent().getStringExtra("preco");
        int imagem = getIntent().getIntExtra("imagem", 0);

        TextView nomeTextView = findViewById(R.id.tituloProduto);
        TextView dataTextView = findViewById(R.id.descricaoProduto);
        TextView precoTextView = findViewById(R.id.precoProduto);
        Button botaoVoltar = findViewById(R.id.botaoVoltar);
        ImageView imageView = findViewById(R.id.imagemProduto);

        nomeTextView.setText(nome);
        dataTextView.setText(data);
        precoTextView.setText(preco);
        imageView.setImageResource(imagem);

        botaoVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
