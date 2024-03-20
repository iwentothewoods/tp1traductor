package com.lunasoft.tp1traducir;

public class Palabra {

    private String espanol;
    private String ingles;
    private int foto;

    public Palabra(String espanol, String ingles, int foto) {
        this.espanol = espanol;
        this.ingles = ingles;
        this.foto = foto;
    }

    public String getEspanol() {
        return espanol;
    }

    public void setEspanol(String espanol) {
        this.espanol = espanol;
    }

    public String getIngles() {
        return ingles;
    }

    public void setIngles(String ingles) {
        this.ingles = ingles;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
