package org.prova.controller.strategy;

public abstract class PesquisaEmpresa {

    protected Pesquisa pesquisa;

    public void perguntar(){
        pesquisa.perguntar();
    }
}
