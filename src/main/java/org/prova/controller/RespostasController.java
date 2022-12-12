package org.prova.controller;

import org.prova.connectiondb.ConnectionDb;
import org.prova.controller.iterator.perguntas.PerguntasIteratorImpl;
import org.prova.controller.iterator.respostas.RespostasIteratorImpl;
import org.prova.enuns.Origem;
import org.prova.enuns.TipoResposta;
import org.prova.model.Perguntas;
import org.prova.model.Respostas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RespostasController {


    public static void onInsert(RespostasIteratorImpl respostasIterator){
        try{
            String sql = "INSERT INTO respostas (resposta, idpergunta) VALUES (?, ?)";

            PreparedStatement stmt = ConnectionDb.getInstance().getConnection().prepareStatement(sql);
            // aqui uso o padrão iterator pra salvar na base a lista de perguntas
            while (respostasIterator.hasNext()){
                Respostas re = respostasIterator.next();
                stmt.setString(1,re.getResposta());
                stmt.setInt(2,re.getPerguntas().getId());
                stmt.execute();
            }

            stmt.close();

            System.out.println("Salvo com sucesso!!");
        } catch (SQLException ex) {
            System.out.println("Falha ao inserir perguntas");
        }
    }

    public static List<Respostas> onGetAll(Origem origem){
        RespostasIteratorImpl respostasIterator = new RespostasIteratorImpl();
        try{
            String sql = "select * from respostas inner join perguntas on perguntas.id = respostas.idpergunta where perguntas.origen = '"+origem.toString()+"'";

            PreparedStatement stmt = ConnectionDb.getInstance().getConnection().prepareStatement(sql);
            stmt.execute();
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                Respostas r = new Respostas();
                r.setPerguntas(PerguntasController.onGetById(rs.getInt(2)));
                r.setResposta(rs.getString(1));
                r.setId(rs.getInt(0));
                respostasIterator.add(r);
            }
            // aqui uso o padrão iterator pra salvar na base a lista de perguntas

            stmt.close();
            rs.close();

        } catch (SQLException ex) {
            System.out.println("Falha ao inserir perguntas");
        }

        return respostasIterator.getAll();
    }
}
