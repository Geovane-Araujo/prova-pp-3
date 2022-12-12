package org.prova.controller.strategy;

import org.prova.controller.PerguntasController;
import org.prova.enuns.Origem;
import org.prova.model.Perguntas;
import org.prova.model.Respostas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ligacao implements Pesquisa{

    @Override
    public void perguntar() {
        List<Perguntas> perguntas = PerguntasController.onGet(Origem.EXTERNO);
        List<Respostas> respostas = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        perguntas.forEach(item -> {
            Respostas r = new Respostas();
            r.setPerguntas(item);
            System.out.println(item.getPergunta());
            r.setResposta(scan.nextLine());
            respostas.add(r);
        });

    }
}
