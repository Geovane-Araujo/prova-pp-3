package org.prova.controller.strategy;

import org.prova.controller.PerguntasController;
import org.prova.controller.RespostasController;
import org.prova.controller.iterator.respostas.RespostasIteratorImpl;
import org.prova.enuns.Origem;
import org.prova.model.Perguntas;
import org.prova.model.Respostas;

import java.util.List;
import java.util.Scanner;

public class Email implements Pesquisa{

    @Override
    public void perguntar() {
        // aqui enviaa as perguntas por email
        List<Perguntas> perguntas = PerguntasController.onGet(Origem.INTERNO);
        RespostasIteratorImpl respostas = new RespostasIteratorImpl();
        Scanner scan = new Scanner(System.in);
        perguntas.forEach(item -> {
            Respostas r = new Respostas();
            r.setPerguntas(item);
            System.out.println(item.getPergunta());
            r.setResposta(scan.nextLine());
            respostas.add(r);
        });
        RespostasController.onInsert(respostas);
    }
}
