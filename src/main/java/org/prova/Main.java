package org.prova;

import org.prova.connectiondb.ConnectionDb;
import org.prova.controller.PerguntasController;
import org.prova.controller.iterator.perguntas.PerguntasIteratorImpl;
import org.prova.enuns.Origem;
import org.prova.enuns.TipoResposta;
import org.prova.model.Menu;
import org.prova.model.Perguntas;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Aqui usei o padrão de projeto singleton para abrir a cenexão com a base e manter ela aberta aaté o fim da execução
        ConnectionDb.getInstance().getConnection();
        Scanner scan = new Scanner(System.in);
        int resposta = 0;
        do{
            povoaMenus().forEach(obj -> System.out.println(obj.getIdMenu() +" - " + obj.getMenuName()));
            System.out.print("Escolha uma opção: ");
            resposta = validateUSerDigit(scan.next());
            acoes(resposta);
        }while (resposta != 3);
    }

    static void acoes(int opcao){
        Scanner scan = new Scanner(System.in);
        int resposta = 0;
        switch (opcao){
            case 1:

                PerguntasIteratorImpl perguntasIterator = new PerguntasIteratorImpl();
                do{
                    Perguntas pergunta = createQuest();
                    System.out.println("Deseja continuar cadastrando? 0 pra sim, 1 para sair");
                    resposta = validateUSerDigit(scan.nextLine());
                    perguntasIterator.add(pergunta);
                } while (resposta == 0);

                PerguntasController.onInsert(perguntasIterator);
                break;
            case 2:
                do{

                } while (resposta == 0);
                break;
            case 3:
                break;
            default:
                return;
        }
    }

    private static Perguntas createQuest() {
        Scanner scan = new Scanner(System.in);
        Perguntas perguntas = new Perguntas();

        System.out.println("Digite a pergunta");
        perguntas.setPergunta(scan.nextLine());

        System.out.println("Origem? (ex: 1 - interno ou 2 - externo)");
        perguntas.setOrigem(retOrigin(scan.nextLine()));

        System.out.println("Tipo? (ex: 1 - STRING, 2 - INTEGER, 3 - SIM_NAO,  3 - DATA)");
        perguntas.setTipoResposta(retTipoResposta(scan.nextLine()));

        return perguntas;

    }

    private static Origem retOrigin(String next) {
        return switch (next){
            case "1" -> Origem.INTERNO;
            case "2" -> Origem.EXTERNO;
            default -> Origem.INTERNO;
        };
    }

    private static TipoResposta retTipoResposta(String next) {
        return switch (next){
            case "1" -> TipoResposta.STRING;
            case "2" -> TipoResposta.INTEGER;
            case "3" -> TipoResposta.SIM_NAO;
            case "4" -> TipoResposta.DATA;
            default -> TipoResposta.STRING;
        };
    }

    private static int validateUSerDigit(String next) {
        int ret = 0;
        if(next.length() > 1){
            System.out.println("Somente é permitido 1 digito!!");
        }
        if(next.matches("[0-9]*")){
            ret = Integer.parseInt(next);
        } else {
            System.out.println("Sãao Permitidos apenas numeros!!");
        }
        return ret;

    }

    private static List<Menu> povoaMenus(){
        return Arrays.asList(new Menu(1,"Cadastrar Perguntas"),
                new Menu(2,"Fazer Pesquisa"),
                new Menu(2,"Ver Respostas"),
                new Menu(3,"Sair"),
                new Menu(4,"Menu 4"));
    }
}