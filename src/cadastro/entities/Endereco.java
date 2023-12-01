package cadastro.entities;

import cadastro.TabelaPrinter;

/**
 * Essa classe modela a entidade Endereço e pussui os atributos id, rua, numero, cep, cidade, estado, pais.
 * também é possivel exibir na tela as informações de um objeto instanciado através do metodo mostrar().
 */
public class Endereco {
    private final Integer id;
    private String rua;
    private Integer numero;
    private String cep;
    private String cidade;
    private String estado;
    private String pais;
    public static final String[] COLUNAS = {"ID", "Rua", "Numero", "CEP", "Cidade", "Estado", "Pais"};
    public int[] larguras;
    private static final String COR_TEXTO = "\033[38;05;234m"; // Preto
    private static final String COR_FUNDO = "\033[48;05;15m"; // Cinza Claro
    private static final String RESET_COR = "\033[0m";

    public Endereco(Integer id, String rua, Integer numero, String cep, String cidade, String estado, String pais) {
        this.id = id;
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        larguras = new int[]{id.toString().length(), rua.length(), numero.toString().length(), cep.length(),
                cidade.length(), estado.length(), pais.length()};
    }

    /**
     * Esse método exibe na tela as informações do endereço instanciado.
     * É comparado com o metodo toString() porém com uma estilização para tabela.
     */
    public void mostrar() {
        final int ESPACAMENTO = 2;
        for (int i = 0; i < COLUNAS.length; i++) {
            if (larguras[i] < TabelaPrinter.larguraColEndereco[i]) {
                larguras[i] = TabelaPrinter.larguraColEndereco[i];
            }
        }
        System.out.printf("%s%s%-" + (larguras[0] + ESPACAMENTO) + "s%s", COR_TEXTO, COR_FUNDO, id, RESET_COR);
        System.out.printf("%s%s%-" + (larguras[1] + ESPACAMENTO) + "s%s", COR_TEXTO, COR_FUNDO, rua, RESET_COR);
        System.out.printf("%s%s%-" + (larguras[2] + ESPACAMENTO) + "s%s", COR_TEXTO, COR_FUNDO, numero, RESET_COR);
        System.out.printf("%s%s%-" + (larguras[3] + ESPACAMENTO) + "s%s", COR_TEXTO, COR_FUNDO, cep, RESET_COR);
        System.out.printf("%s%s%-" + (larguras[4] + ESPACAMENTO) + "s%s", COR_TEXTO, COR_FUNDO, cidade, RESET_COR);
        System.out.printf("%s%s%-" + (larguras[5] + ESPACAMENTO) + "s%s", COR_TEXTO, COR_FUNDO, estado, RESET_COR);
        System.out.printf("%s%s%-" + (larguras[6] + ESPACAMENTO) + "s%s", COR_TEXTO, COR_FUNDO, pais, RESET_COR);
    }

    public Integer getId() {
        return id;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getRua() {
        return rua;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getPais() {
        return pais;
    }
}
