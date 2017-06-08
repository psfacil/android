package esensato.nac02;

import java.text.DecimalFormat;

public class Acao {

    public static final DecimalFormat df = new DecimalFormat("R$ #,###,###.00");

    private String nome;

    private double valor;

    public Acao(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String toString() {

        return nome + " - " + df.format(valor);

    }

}
