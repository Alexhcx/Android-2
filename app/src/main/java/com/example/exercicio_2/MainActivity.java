package com.example.exercicio_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    RecyclerView recyclerView;
    ItemAdapter adapter;
    ArrayList<ObjectData> dadosAL;
    boolean escuro = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler);
        dadosAL = new ArrayList<>();
        textView = findViewById(R.id.titulo);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Bem vindo!!", Toast.LENGTH_SHORT).show();
            }
        });

        int modoAtual = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;

        switch (modoAtual){
            case Configuration.UI_MODE_NIGHT_NO:
                escuro = false;
                break;
            case Configuration.UI_MODE_NIGHT_YES:
                escuro = true;
                TextView textView = findViewById(R.id.titulo);
                textView.setTextColor(Color.WHITE);
                break;
        }

        dadosAL.add(new ObjectData(
                "Ovos Mantiqueira Happy Eggs Vermelho c/ 20 Unid",
                "Desfrute da qualidade superior dos Ovos Mantiqueira Happy Eggs Vermelho, embalados com cuidado e frescor. Com uma caixa contendo 20 unidades, estes ovos são colhidos de galinhas criadas de forma responsável, garantindo uma fonte nutritiva e deliciosa de proteína para suas refeições. Aproveite a cor vermelha vibrante e o sabor excepcional desses ovos de alta qualidade.",
                9.99,
                R.drawable.ovos));
        dadosAL.add(new ObjectData(
                "Filé de Peito de Frango Sadia Bandeja Congelado 1Kg",
                "Desfrute da conveniência e qualidade do Filé de Peito de Frango Sadia Congelado. Com uma bandeja de 1kg, este produto oferece filés de frango suculentos e saborosos, perfeitos para uma variedade de receitas. Congelados para preservar a frescura e o sabor, esses filés são uma escolha saudável e prática para suas refeições do dia a dia",
                15.99,
                R.drawable.filedepeito));
        dadosAL.add(new ObjectData(
                "Bombom Nestlé Especialidades Caixa 251g",
                "A Caixa Nestlé® Especialidades junta os maiores sucessos da Nestlé em um lugar só: Prestígio, Alpino, Suflair, Classic ao Leite, Galak, Lollo, Charge, Sensação, Chokito, Smash e Negresco.",
                11.99,
                R.drawable.bombons));
        dadosAL.add(new ObjectData(
                "Cerveja Amstel Lager Premium Puro Malte Lata 350ml",
                "Desfrute do sabor autêntico da Cerveja Amstel Lager Premium Puro Malte. Embalada em latas de 350ml, esta cerveja oferece uma experiência refrescante e encorpada, com notas distintas de malte. Perfeita para acompanhar momentos de descontração e celebração, a Amstel Lager é uma escolha premium para os apreciadores de cerveja.",
                3.79,
                R.drawable.cervejalager));
        dadosAL.add(new ObjectData("Tomate",
                "O tomate é um alimento versátil e nutritivo que traz inúmeros benefícios para a saúde. Rico em vitaminas A, C e K, além de minerais como potássio e licopeno, o tomate é um aliado na prevenção de doenças e no fortalecimento do sistema imunológico. Seu consumo regular contribui para a saúde dos olhos, pele e cabelos, além de auxiliar na redução do risco de doenças cardiovasculares.",
                1.61,
                R.drawable.tomates));
        dadosAL.add(new ObjectData("Banana Nanica",
                "A fruta tropical mais popular do mundo, a Banana Nanica é uma escolha saudável e deliciosa para incluir na sua dieta diária. Com sua casca amarela vibrante e formato alongado, essa fruta é conhecida por seu sabor doce e textura macia. Além de ser uma opção prática e versátil, a Banana Nanica oferece uma série de benefícios para a saúde.",
                0.39,
                R.drawable.bananas));


        adapter = new ItemAdapter(MainActivity.this, dadosAL, escuro);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}