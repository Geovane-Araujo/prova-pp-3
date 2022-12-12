package org.prova.controller.iterator.perguntas;

import org.prova.model.Perguntas;

import java.util.List;

public interface PerguntasIterator {

    boolean hasNext();

    Perguntas next();

    void add(Perguntas pergunta);

    List<Perguntas> getAll();
}
