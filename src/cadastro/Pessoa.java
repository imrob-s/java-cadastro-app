package cadastro;

public class Pessoa {
    public String nome;
    public Integer idade;
    public String sexo;
    public Double altura;
    
    public Pessoa(String nome, Integer idade, String sexo, Double altura){
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.altura = altura;
    }
    
    public String mostrar(){
           String dados = String.format(
                  "Nome: %s\n"
                + "Idade: %d\n"
                + "Sexo: %s\n"
                + "Altura %s\n", nome, idade, sexo, altura);
        return dados;
    }
    
}
