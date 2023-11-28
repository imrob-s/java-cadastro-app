package cadastro;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class ConsoleUI {
    private static final int CADASTRO_PESSOA = 1, NOVO = 1;
    private static final int CADASTRO_ENDERECO = 2, ATUALIZAR = 2;
    private static final int EXIBIR_PESSOAS = 3, APAGAR =3;
    private static final int EXIBIR_ENDERECOS = 4;
    private static final int SAIR = 0;
    private static final Scanner sc = new Scanner(System.in).useLocale(Locale.US).useDelimiter("\n");

    public static boolean iniciar() throws IOException, InterruptedException {
        Menu.principal();
        int opcao = sc.nextInt();
        switch (opcao) {
            case CADASTRO_PESSOA:
                limpar();
                Menu.titulo("cadastro de pessoas");
                cadastrarPessoa();
                break;
            case CADASTRO_ENDERECO:
                limpar();
                Menu.titulo("cadastro de enderecos");
                cadastrarEndereco();
                break;
            case EXIBIR_PESSOAS:
                limpar();
                TabelaPrinter.exibirPessoas(CadastroManager.getPessoas());
                Menu.menuHistorico();
                opcao = sc.nextInt();
                switch (opcao) {
                    case NOVO:
                        cadastrarPessoa();
                        break;
                    case ATUALIZAR:
                        updatePessoa();
                        break;
                    case APAGAR:
                        deletePessoa();
                        break;
                    default:
                        break;
                }
                break;
            case EXIBIR_ENDERECOS:
                limpar();
                TabelaPrinter.exibirEnderecos(CadastroManager.getEnderecos());
                Menu.menuHistorico();
                opcao = sc.nextInt();
                switch (opcao) {
                    case NOVO:
                        cadastrarEndereco();
                        break;
                    case ATUALIZAR:
                        updateEndereco();
                        break;
                    case APAGAR:
                        deleteEndereco();
                        break;
                    default:
                        break;
                }
                break;
            case SAIR:
                System.out.println("Saindo do programa...");
                return true;
            default:
                limpar();
                Menu.opcaoInvalida();
                Thread.sleep(2000);
        }
        return false;
    }
    public static void cadastrarPessoa() {
        System.out.print("Digite o nome: ");
        String nome = sc.next();
        System.out.print("Digite a idade: ");
        Integer idade = sc.nextInt();
        System.out.print("Digite o sexo: ");
        String sexo = sc.next();
        System.out.print("Digite a altura: ");
        Double altura = sc.nextDouble();

        if (nome.isEmpty() ||
                idade == null ||
                sexo.isEmpty() ||
                altura == null) {
            System.out.println("TODOS OS CAMPOS PRECISAM SER PREENCHIDOS!");
            System.out.println("PREENCHA O CADASTRO NOVAMENTE\n");
            cadastrarPessoa();
        }
        CadastroManager.addPessoa(nome, idade, sexo, altura);
    }
    private static void cadastrarEndereco() {

        System.out.print("Digite a rua: ");
        String rua = sc.next();
        System.out.print("Digite o numero: ");
        Integer numero = sc.nextInt();
        System.out.print("Digite o cep: ");
        String cep = sc.next();
        System.out.print("Digite a cidade: ");
        String cidade = sc.next();
        System.out.print("Digite o estado: ");
        String estado = sc.next();
        System.out.print("Digite o pais: ");
        String pais = sc.next();

        if (rua.isEmpty() || numero == null ||
                cep.isEmpty() || cidade.isEmpty() || pais.isEmpty()) {
            System.out.println("TODOS OS CAMPOS PRECISAM SER PREENCHIDOS!");
            System.out.println("PREENCHA O CADASTRO NOVAMENTE\n");
            cadastrarEndereco();
        }
        CadastroManager.addEndereco(rua, numero, cep, cidade, estado, pais);
    }
    public static void updatePessoa() {
        System.out.println("Digite o ID do cadastro: ");
        int id = sc.nextInt();

        System.out.print("Qual campo gostaria de atualizar? (Nome, Idade, Sexo, Altura): ");
        String campo = sc.next();

        System.out.println("Digite o novo valor: ");
        String novoValor = sc.next();

        CadastroManager.updatePessoa(id, campo, novoValor);
    }
    public static void updateEndereco() {
        System.out.println("Digite o ID do cadastro: ");
        int id = sc.nextInt();

        System.out.print("Qual campo gostaria de atualizar? (Rua, Numero, CEP, Cidade, Estado, Pais): ");
        String campo = sc.next();

        System.out.println("Digite o novo valor: ");
        String novoValor = sc.next();

        CadastroManager.updateEndereco(id, campo, novoValor);
    }
    public static void deletePessoa() {
        System.out.println("Digite o ID do cadastro: ");
        int id = sc.nextInt();
        CadastroManager.deletePessoa(id);
    }
    public static void deleteEndereco() {
        System.out.println("Digite o ID do cadastro: ");
        int id = sc.nextInt();
        CadastroManager.deleteEndereco(id);
    }
    /**
     * Esse método é utilizado para limpar o conteúdo da tela / terminal.
     *
     * @throws IOException          Exceção caso ocorra algum erro durante a execução
     *                              do metodo ConsoleUI.limpar()
     * @throws InterruptedException Exceção caso ocorra algum erro durante a execução
     *                              do metodo ConsoleUI.limpar()
     */
    public static void limpar() throws IOException, InterruptedException {
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");
    }
}
