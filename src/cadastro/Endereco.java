package cadastro;

public class Endereco {
    public String rua;
    public Integer numero;
    public String cep;
    public String cidade;
    public String pais;

    public Endereco(String rua, Integer numero, String cep, String cidade, String pais) {
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
        this.cidade = cidade;
        this.pais = pais;
    }
    
    public String mostrar(){
        String dados = String.format(
                  "Rua: %s\n"
                + "Numero: %d\n"
                + "Cep: %s\n"
                + "cidade %s\n"
                + "pais %s\n", rua, numero, cep, cidade, pais);
        return dados;
}
}
