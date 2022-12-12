package org.prova.controller.iterator.perguntas;

import org.prova.model.Perguntas;

import java.util.ArrayList;
import java.util.List;

public class PerguntasIteratorImpl implements PerguntasIterator{

    private List<Perguntas> perguntas = new ArrayList();
    private int index = 0;
    @Override
    public boolean hasNext() {
        return index < perguntas.size() && perguntas.get(index) != null;
    }

    @Override
    public Perguntas next() {
        return perguntas.get(index++);
    }

    @Override
    public void add(Perguntas pergunta) {
        this.perguntas.add(pergunta);
    }

    @Override
    public List<Perguntas> getAll() {
        return this.perguntas.stream().toList();
    }
}
