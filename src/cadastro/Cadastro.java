package cadastro;

import java.util.Scanner;

/**
 * A classe Cadastro é responsável por gerenciar um cadastro de pessoas.
 */
public class Cadastro {
    private static Scanner sc = new Scanner(System.in);
    private static final int capacidade = 5;
    public static Pessoa pessoas[] = new Pessoa[capacidade];
    public static Endereco enderecos[] = new Endereco[capacidade];
    private static int contadorPessoa = 0;
    private static int contadorEndereco = 0;

    /**
     * Adiciona uma nova pessoa ao cadastro.
     * Solicita ao usuário informações como nome, idade, sexo, altura e cidade.
     * Verifica se todos os campos sejam preenchidos antes de adicionar a pessoa.
     * Se a capacidade máxima for atingida, reinicia o contador para permitir
     * novos cadastros.
     */
    public static void addPessoa() {
        
        if (contadorPessoa < capacidade) {
            System.out.print("Digite o nome: ");
            String nome = sc.next();
            System.out.print("Digite a idade: ");
            Integer idade = sc.nextInt();
            System.out.print("Digite o sexo: ");
            String sexo = sc.next();
            System.out.print("Digite a altura: ");
            Double altura = sc.nextDouble();

            if (pessoas[contadorPessoa] == null || pessoas[contadorPessoa].equals("")) {
                System.out.println("TODOS OS CAMPOS PRECISAM SER PREENCHIDOS!");
                System.out.println("PREENCHA O CADASTRO NOVAMENTE\n");
                addPessoa();
            }
            Pessoa pessoaCadastrar = new Pessoa(nome, idade, sexo, altura);
            pessoas[contadorPessoa] = pessoaCadastrar;
            contadorPessoa++;
        } else {
            contadorPessoa = 0;
            addPessoa();
        }
    }
    
    public static void addEndereco() {
        
        if (contadorEndereco < capacidade) {
            System.out.print("Digite o rua: ");
            String rua = sc.next();
            System.out.print("Digite a numero: ");
            Integer numero = sc.nextInt();
            System.out.print("Digite o cep: ");
            String cep = sc.next();
            System.out.print("Digite a cidade: ");
            String cidade = sc.next();
            System.out.print("Digite a pais: ");
            String pais = sc.next();

            if (enderecos[contadorEndereco] == null || enderecos[contadorEndereco].equals("")) {
                System.out.println("TODOS OS CAMPOS PRECISAM SER PREENCHIDOS!");
                System.out.println("PREENCHA O CADASTRO NOVAMENTE\n");
                addPessoa();
            }
            Endereco enderecoCadastrar = new Endereco(rua, numero, cep, cidade, pais);
            enderecos[contadorEndereco] = enderecoCadastrar;
            contadorEndereco++;
        } else {
            contadorEndereco = 0;
            addPessoa();
        }
    }
}
