package models;

import enums.Patente;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public class Militar implements Comparable<Militar> {
    private String numeroDeIdentificacao;
    private String nome;
    private int tempoDeServico;
    private Patente patente;

    public Militar(String nome, int tempoDeServico, Patente patente) {
        this.nome = nome;
        this.tempoDeServico = tempoDeServico;
        this.patente = patente;
        this.numeroDeIdentificacao = gerarNumeroAleatorioIdentificacao();
    }

    private String gerarNumeroAleatorioIdentificacao(){
        Random random = new Random();
        int numeroAleatorio = random.nextInt(1000000);
        return String.format("%06d", numeroAleatorio);
    }

    public List<Militar> getSubordinados(List<Militar> militares){
        return militares.stream().sorted().filter(militar -> militar.patente.ordinal() < this.patente.ordinal()).toList();
    }

    public Optional<Militar> getSuperiorImediato(List<Militar> militares){
        return militares.stream().sorted().filter(militar -> militar.patente.ordinal() > this.patente.ordinal()).findFirst();
    }

    @Override
    public int compareTo(Militar other) {
        int indexOfPatent = this.patente.ordinal();
        int indexOfOtherPatent = other.patente.ordinal();
        if(indexOfPatent == indexOfOtherPatent){
            return this.tempoDeServico - other.tempoDeServico;
        }
        return indexOfPatent < indexOfOtherPatent? -1 : 1;
    }

    @Override
    public String toString() {
        return "Militar{" +
                "numeroDeIdentificacao='" + numeroDeIdentificacao + '\'' +
                ", nome='" + nome + '\'' +
                ", tempoDeServico=" + tempoDeServico +
                ", patente=" + patente +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public Patente getPatente() {
        return patente;
    }
}
