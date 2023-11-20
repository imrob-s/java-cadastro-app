package cadastro;

import cadastro.entities.Endereco;
import cadastro.entities.Pessoa;

import java.util.Locale;
import java.util.Scanner;

/**
 * A classe Cadastro é responsável por gerenciar um cadastro de pessoas.
 */
public class Cadastro {
    private static final Scanner sc = new Scanner(System.in).useLocale(Locale.US);
    private static final int capacidade = 5;
    public static Pessoa[] pessoas = new Pessoa[capacidade];
    public static Endereco[] enderecos = new Endereco[capacidade];
    private static int contadorPessoa = 0;
    private static int contadorEndereco = 0;

    /**
     * Adiciona uma nova pessoa ao cadastro.
     * Solicita ao usuário informações como nome, idade, sexo, e altura.
     * Verifica se todos os campos sejam preenchidos antes de adicionar a pessoa.
     * Se a capacidade máxima for atingida, reinicia o contador para permitir
     * novos cadastros.
     */
    public static void addPessoa() {
        if (contadorPessoa < capacidade) {
            Integer id = contadorPessoa;
            System.out.print("Digite o nome: ");
            String nome = sc.nextLine();
            System.out.print("Digite a idade: ");
            Integer idade = sc.nextInt();
                    sc.nextLine();
            System.out.print("Digite o sexo: ");
            String sexo = sc.next();
            System.out.print("Digite a altura: ");
            Double altura = sc.nextDouble();
            sc.nextLine();

            if (nome.isEmpty() ||
                idade == null ||
                sexo.isEmpty() ||
                altura == null) {
                System.out.println("TODOS OS CAMPOS PRECISAM SER PREENCHIDOS!");
                System.out.println("PREENCHA O CADASTRO NOVAMENTE\n");
                addPessoa();
            }
            Pessoa pessoaCadastrar = new Pessoa(id, nome, idade, sexo, altura);
            pessoas[contadorPessoa] = pessoaCadastrar;
            contadorPessoa++;
        } else {
            contadorPessoa = 0;
            addPessoa();
        }
    }
    
    public static void addEndereco() {
        if (contadorEndereco < capacidade) {
            Integer id = contadorEndereco;
            System.out.print("Digite a rua: ");
            String rua = sc.nextLine();
            System.out.print("Digite o numero: ");
            Integer numero = sc.nextInt();
                    sc.nextLine();
            System.out.print("Digite o cep: ");
            String cep = sc.nextLine();
            System.out.print("Digite a cidade: ");
            String cidade = sc.nextLine();
            System.out.print("Digite o estado: ");
            String estado = sc.nextLine();
            System.out.print("Digite o pais: ");
            String pais = sc.nextLine();

            if (rua.isEmpty() || numero == null ||
                    cep.isEmpty() || cidade.isEmpty() || pais.isEmpty()) {
                System.out.println("TODOS OS CAMPOS PRECISAM SER PREENCHIDOS!");
                System.out.println("PREENCHA O CADASTRO NOVAMENTE\n");
                addEndereco();
            }
            Endereco enderecoCadastrar = new Endereco(id, rua, numero, cep, cidade, estado, pais);
            enderecos[contadorEndereco] = enderecoCadastrar;
            contadorEndereco++;
        } else {
            contadorEndereco = 0;
            addEndereco();
        }
    }
}
