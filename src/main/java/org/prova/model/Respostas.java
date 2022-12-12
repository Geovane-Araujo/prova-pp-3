package org.prova.model;

public class Respostas {

    private int id;

    private Perguntas perguntas;

    private String resposta;

    public Respostas(){}


    public Respostas(int id, Perguntas perguntas, String resposta) {
        this.id = id;
        this.perguntas = perguntas;
        this.resposta = resposta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Perguntas getPerguntas() {
        return perguntas;
    }

    public void setPerguntas(Perguntas perguntas) {
        this.perguntas = perguntas;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }
}
