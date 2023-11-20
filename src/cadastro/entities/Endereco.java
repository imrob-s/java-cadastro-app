package cadastro.entities;

import cadastro.Tabela;

public class Endereco {
    public Integer id;
    public String rua;
    public Integer numero;
    public String cep;
    public String cidade;
    public String estado;
    public String pais;
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
                cidade.toString().length(), estado.length(), pais.length()};
    }

    public void mostrar(){
        final int ESPACAMENTO = 2;
        for (int i = 0; i < COLUNAS.length; i++) {
            if (larguras[i] < Tabela.largurasEnderecos[i]) {
                larguras[i] = Tabela.largurasEnderecos[i];
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
}
