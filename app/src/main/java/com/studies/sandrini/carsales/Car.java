package com.studies.sandrini.carsales;

/**
 * Created by Sandrini on 13/11/2017.
 */

public class Car {
    private int id;
    private String foto;
    private String modelo;
    private String preco;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public Car(int id, String foto, String modelo, String preco) {

        this.id = id;
        this.foto = foto;
        this.modelo = modelo;
        this.preco = preco;
    }
}
