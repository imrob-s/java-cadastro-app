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
     */
    public void mostrar() {
        final int ESPACAMENTO = 2;
        for (int i = 0; i < COLUNAS.length; i++) {
            if (larguras[i] < TabelaPrinter.largurasEnderecos[i]) {
                larguras[i] = TabelaPrinter.largurasEnderecos[i];
            }
        }
        System.out.printf("\033[38;05;234m\033[48;05;15m%-" + (larguras[0] + ESPACAMENTO)
                + "s\033[0m", id);
        System.out.printf("\033[38;05;234m\033[48;05;15m%-" + (larguras[1] + ESPACAMENTO)
                + "s\033[0m", rua);
        System.out.printf("\033[38;05;234m\033[48;05;15m%-" + (larguras[2] + ESPACAMENTO)
                + "s\033[0m", numero);
        System.out.printf("\033[38;05;234m\033[48;05;15m%-" + (larguras[3] + ESPACAMENTO)
                + "s\033[0m", cep);
        System.out.printf("\033[38;05;234m\033[48;05;15m%-" + (larguras[4] + ESPACAMENTO)
                + "s\033[0m", cidade);
        System.out.printf("\033[38;05;234m\033[48;05;15m%-" + (larguras[5] + ESPACAMENTO)
                + "s\033[0m", estado);
        System.out.printf("\033[38;05;234m\033[48;05;15m%-" + (larguras[6] + ESPACAMENTO)
                + "s\033[0m", pais);
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
}
