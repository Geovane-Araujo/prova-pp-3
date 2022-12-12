package org.prova.controller.strategy;

public class PesquisaExterna extends PesquisaEmpresa{

    public PesquisaExterna(){
        pesquisa = new Ligacao();
    }
}
