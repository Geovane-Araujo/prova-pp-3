package org.prova.controller.iterator;

import org.prova.connectiondb.ConnectionDb;
import org.prova.controller.iterator.perguntas.PerguntasIteratorImpl;
import org.prova.enuns.Origem;
import org.prova.enuns.TipoResposta;
import org.prova.model.Perguntas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PerguntasController {

    public static void onInsert(PerguntasIteratorImpl perguntasIterator){
        try{
            String sql = "INSERT INTO perguntas (pergunta, tipoResposta, origem) VALUES (?, ?,?)";

            PreparedStatement stmt = ConnectionDb.getInstance().getConnection().prepareStatement(sql);
            // aqui uso o padrão iterator pra salvar na base a lista de perguntas
            while (perguntasIterator.hasNext()){
                Perguntas pe = perguntasIterator.next();
                stmt.setString(1,pe.getPergunta());
                stmt.setString(2,pe.getTipoResposta().toString());
                stmt.setString(3,pe.getOrigem().toString());

                stmt.execute();
            }

            stmt.close();

            System.out.println("Salvo com sucesso!!");
        } catch (SQLException ex) {
            System.out.println("Falha ao inserir perguntas");
        }
    }

    public List<Perguntas> onGet(Origem origem){
        PerguntasIteratorImpl perguntasIterator = new PerguntasIteratorImpl();
        try{
            String sql = "select * from perguntas";

            PreparedStatement stmt = ConnectionDb.getInstance().getConnection().prepareStatement(sql);
            stmt.execute();
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                perguntasIterator.add(new Perguntas(rs.getInt(0),rs.getString(1),TipoResposta.valueOf(rs.getString(2)),Origem.valueOf(rs.getString(3))));
            }
            // aqui uso o padrão iterator pra salvar na base a lista de perguntas

            stmt.close();
            rs.close();

        } catch (SQLException ex) {
            System.out.println("Falha ao inserir perguntas");
        }

        return perguntasIterator.getAll();
    }
}
