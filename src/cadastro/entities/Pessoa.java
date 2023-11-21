package cadastro.entities;

import cadastro.Tabela;

/**
 * Essa classe modela a entidade Pessoa e pussui os atributos id, nome, idade, sexo e altura.
 * também é possivel exibir na tela as informações de um objeto instanciado através do metodo mostrar()
 */
public class Pessoa {
    public Integer id;
    public String nome;
    public Integer idade;
    public String sexo;
    public Double altura;
    public static final String[] COLUNAS = {"ID", "Nome", "Idade", "Sexo", "Altura"};
    public int[] larguras;

    public Pessoa(Integer id, String nome, Integer idade, String sexo, Double altura) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.altura = altura;
        larguras = new int[]{id.toString().length(), nome.length(), idade.toString().length(), sexo.length(),
                altura.toString().length()};
    }

    /**
     * Esse método exibe na tela as informações da pessoa instanciada.
     */
    public void mostrar() {
        final int ESPACAMENTO = 2;
        for (int i = 0; i < COLUNAS.length; i++) {
            if (larguras[i] < Tabela.largurasPessoas[i]) {
                larguras[i] = Tabela.largurasPessoas[i];
            }
        }
        System.out.printf("\033[38;05;234m\033[48;05;15m%-" + (larguras[0] + ESPACAMENTO)
                + "s\033[0m", id);
        System.out.printf("\033[38;05;234m\033[48;05;15m%-" + (larguras[1] + ESPACAMENTO)
                + "s\033[0m", nome);
        System.out.printf("\033[38;05;234m\033[48;05;15m%-" + (larguras[2] + ESPACAMENTO)
                + "s\033[0m", idade);
        System.out.printf("\033[38;05;234m\033[48;05;15m%-" + (larguras[3] + ESPACAMENTO)
                + "s\033[0m", sexo);
        System.out.printf("\033[38;05;234m\033[48;05;15m%-" + (larguras[4] + ESPACAMENTO)
                + "s\033[0m", altura);
    }

}
