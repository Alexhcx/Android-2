package com.example.exercicio_2;

public class ObjectData {

    private String nome;
    private String data;
    private double valor;
    private int imgId;


    public ObjectData(){}

    public ObjectData(String nome, String data, double valor, int imgId){
        this.nome = nome;
        this.data = data;
        this.valor = valor;
        this.imgId = imgId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getValor(){ return valor; }

    public void setValor(double valor){ this.valor = valor; }

    public int getImgId() {return imgId;}

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }


}
