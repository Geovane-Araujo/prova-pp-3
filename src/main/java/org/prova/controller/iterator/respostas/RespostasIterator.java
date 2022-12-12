package org.prova.controller.iterator.respostas;

import org.prova.model.Perguntas;
import org.prova.model.Respostas;

import java.util.List;

public interface RespostasIterator {

    boolean hasNext();

    Respostas next();

    void add(Respostas respostas);

    List<Respostas> getAll();
}
