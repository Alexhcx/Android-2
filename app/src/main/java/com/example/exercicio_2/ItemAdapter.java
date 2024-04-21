package com.example.exercicio_2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    Context contexto;
    ArrayList<ObjectData> itemDataAL;
    boolean escuro;

    public ItemAdapter(Context contexto, ArrayList<ObjectData> itemDataAL, boolean escuro) {
        this.contexto = contexto;
        this.itemDataAL = itemDataAL;
        this.escuro = escuro;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(contexto).inflate(R.layout.item_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String valorProduto = String.valueOf(itemDataAL.get(position).getValor());

        valorProduto = valorProduto.replace(".",",");
        valorProduto = "R$ " + valorProduto;

        holder.data.setText(itemDataAL.get(position).getData());
        holder.nome.setText(itemDataAL.get(position).getNome());
        holder.preco.setText(valorProduto);
        holder.imageView.setImageResource(itemDataAL.get(position).getImgId());
    }

    @Override
    public int getItemCount() {
        return itemDataAL.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nome, data, preco, botaoMais;
        ImageView imageView;

        public ViewHolder (View itemView){
            super(itemView);
            nome = itemView.findViewById(R.id.nome);
            data = itemView.findViewById(R.id.data);
            preco = itemView.findViewById(R.id.preco);
            botaoMais = itemView.findViewById(R.id.botaoMais);
            imageView = itemView.findViewById(R.id.img00);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        ObjectData clickedItem = itemDataAL.get(position);
                        Toast.makeText(contexto, clickedItem.getNome(), Toast.LENGTH_SHORT).show();
                    }
                }
            });

            botaoMais.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View detalhesView) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        ObjectData clickedItem = itemDataAL.get(position);
                        double valor = clickedItem.getValor();
                        String intentValor = "R$ " + valor;
                        Intent intent = new Intent(contexto, DetalhesActivity.class);
                        intent.putExtra("nome", clickedItem.getNome());
                        intent.putExtra("data", clickedItem.getData());
                        intent.putExtra("preco", intentValor.replace(".",","));
                        intent.putExtra("imagem", clickedItem.getImgId());
                        contexto.startActivity(intent);
                    }
                }
            });

            if (escuro){
                nome.setTextColor(Color.WHITE);
                data.setTextColor(Color.WHITE);
            }

        }
    }
}
