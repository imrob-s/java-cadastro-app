package cadastro.entities;

import cadastro.TabelaPrinter;

/**
 * Essa classe modela a entidade Pessoa e pussui os atributos id, nome, idade, sexo e altura.
 * também é possivel exibir na tela as informações de um objeto instanciado através do metodo mostrar()
 */
public class Pessoa {
    private final Integer id;
    private String nome;
    private Integer idade;
    private char sexo;
    private Double altura;
    public static final String[] COLUNAS = {"ID", "Nome", "Idade", "Sexo", "Altura"};
    public int[] larguras;
    private static final String COR_TEXTO = "\033[38;05;234m"; // Preto
    private static final String COR_FUNDO = "\033[48;05;15m"; // Cinza Claro
    private static final String RESET_COR = "\033[0m";

    /**
     * Construtor da classe Pessoa.
     *
     * @param id     Identificador único da pessoa.
     * @param nome   Nome da pessoa.
     * @param idade  Idade da pessoa.
     * @param sexo   Sexo da pessoa (M ou F).
     * @param altura Altura da pessoa.
     */
    public Pessoa(Integer id, String nome, Integer idade, Character sexo, Double altura) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.altura = altura;
        larguras = new int[]{id.toString().length(), nome.length(), idade.toString().length(), sexo.toString().length(),
                altura.toString().length()};
    }

    /**
     * Este método exibe na tela as informações da pessoa instanciada.
     */
    public void mostrar() {
        final int ESPACAMENTO = 2;
        for (int i = 0; i < COLUNAS.length; i++) {
            if (larguras[i] < TabelaPrinter.larguraColPessoa[i]) {
                larguras[i] = TabelaPrinter.larguraColPessoa[i];
            }
        }
        System.out.printf("%s%s%-" + (larguras[0] + ESPACAMENTO) + "s%s", COR_TEXTO, COR_FUNDO, id, RESET_COR);
        System.out.printf("%s%s%-" + (larguras[1] + ESPACAMENTO) + "s%s", COR_TEXTO, COR_FUNDO, nome, RESET_COR);
        System.out.printf("%s%s%-" + (larguras[2] + ESPACAMENTO) + "s%s", COR_TEXTO, COR_FUNDO, idade, RESET_COR);
        System.out.printf("%s%s%-" + (larguras[3] + ESPACAMENTO) + "s%s", COR_TEXTO, COR_FUNDO, sexo, RESET_COR);
        System.out.printf("%s%s%-" + (larguras[4] + ESPACAMENTO) + ".2f%s", COR_TEXTO, COR_FUNDO, altura, RESET_COR);
    }

    /**
     * Obtém o identificador único da pessoa.
     *
     * @return O identificador único da pessoa.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Define o nome da pessoa.
     *
     * @param nome O novo nome da pessoa.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Define a idade da pessoa.
     *
     * @param idade A nova idade da pessoa.
     */
    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    /**
     * Define o sexo da pessoa.
     *
     * @param sexo O novo sexo da pessoa.
     */
    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    /**
     * Define a altura da pessoa.
     *
     * @param altura A nova altura da pessoa.
     */
    public void setAltura(Double altura) {
        this.altura = altura;
    }

    /**
     * Obtém o nome da pessoa.
     *
     * @return O nome da pessoa.
     */
    public String getNome() {
        return nome;
    }
}
