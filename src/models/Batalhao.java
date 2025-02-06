package models;

import java.util.ArrayList;
import java.util.List;

public class Batalhao {
    private String nome;
    private List<Militar> militares;

    public Batalhao(String nome, List<Militar> militares) {
        this.nome = nome;
        this.militares = militares;
    }

    public Batalhao(String nome){
        this.nome = nome;
        this.militares = new ArrayList<>();
    }

    public void adicionarMilitar(Militar militar) {
        this.militares.add(militar);
    }

    public void removerMilitar(Militar militar) {
        List<Militar> subordinados = militar.getSubordinados(this.militares);

        if(subordinados.isEmpty()){
            System.out.printf("O militar %s foi removido com sucesso!%n", militar.getNome());
        }else{
            System.out.printf("O militar %s foi removido, e com ele foram removidos outros %d militares, sendo eles: %s!%n", militar.getNome(), subordinados.size(), subordinados.toString());
        }
        this.militares.remove(militar);
        for (Militar subordinado : subordinados) {
            this.removerMilitar(subordinado);
        }
    }

    public List<Militar> getMilitares(){
        return List.copyOf(this.militares.stream().sorted().toList());
    }
}
