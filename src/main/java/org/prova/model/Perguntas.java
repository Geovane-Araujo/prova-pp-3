package org.prova.model;

import org.prova.enuns.Origem;
import org.prova.enuns.TipoResposta;

public class Perguntas {

    private int id;

    private String pergunta;

    private TipoResposta tipoResposta;

    private Origem origem;

    public Perguntas() {
    }

    public Perguntas(int id, String pergunta, TipoResposta tipoResposta, Origem origem) {
        this.id = id;
        this.pergunta = pergunta;
        this.tipoResposta = tipoResposta;
        this.origem = origem;
    }

    public Origem getOrigem() {
        return origem;
    }

    public void setOrigem(Origem origem) {
        this.origem = origem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public TipoResposta getTipoResposta() {
        return tipoResposta;
    }

    public void setTipoResposta(TipoResposta tipoResposta) {
        this.tipoResposta = tipoResposta;
    }
}
