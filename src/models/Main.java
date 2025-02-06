package models;

import enums.Patente;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Batalhao batalhao = new Batalhao("19 BC");
        batalhao.adicionarMilitar(new Militar("João", 5, Patente.soldado));
        batalhao.adicionarMilitar(new Militar("Maria", 10, Patente.cabo));
        batalhao.adicionarMilitar(new Militar("José", 15, Patente.sargento));
        batalhao.adicionarMilitar(new Militar("Ana", 20, Patente.tenente));
        batalhao.adicionarMilitar(new Militar("Carlos", 25, Patente.capitao));
        batalhao.adicionarMilitar(new Militar("Marta", 30, Patente.major));

       List<Militar> militares = batalhao.getMilitares();
       for (Militar militar : militares) {
              System.out.printf("O superior imediato de %s %s é: %s%n", militar.getNome(),militar.getPatente(), militar.getSuperiorImediato(militares).toString());
              System.out.printf("Os subordinados de %s são: %s%n", militar.getNome(), militar.getSubordinados(militares).toString());
       }
       batalhao.removerMilitar(militares.getLast());

    }
}