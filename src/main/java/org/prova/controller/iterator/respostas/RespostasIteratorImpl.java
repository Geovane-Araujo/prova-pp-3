package org.prova.controller.iterator.respostas;

import org.prova.model.Perguntas;
import org.prova.model.Respostas;

import java.util.ArrayList;
import java.util.List;

public class RespostasIteratorImpl implements RespostasIterator {

    private List<Respostas> respostas = new ArrayList();
    private int index = 0;
    @Override
    public boolean hasNext() {
        return index < respostas.size() && respostas.get(index) != null;
    }

    @Override
    public Respostas next() {
        return respostas.get(index++);
    }

    @Override
    public void add(Respostas resposta) {

        this.respostas.add(resposta);
    }

    @Override
    public List<Respostas> getAll() {
        return this.respostas.stream().toList();
    }
}
