package cadastro;

import cadastro.entities.Endereco;
import cadastro.entities.Pessoa;

/**
 * A classe CadastroManager é responsável por gerenciar um cadastro de pessoas.
 */
public class CadastroManager {

    // Capacidade total de dados que podem ser inseridas nos vetores pessoas e endereços.
    private static final int capacidade = 8;
    // Os dados cadastrados serão armazenados nos arrays pessoas e enderecos.
    private static final Pessoa[] pessoas = new Pessoa[capacidade];
    private static final Endereco[] enderecos = new Endereco[capacidade];
    private static int contadorPessoa = 4;
    private static int contadorEndereco = 4;

    static {
        // Inserindo no banco de dados alguns dados fictícios
        pessoas[0] = new Pessoa(0, "João", 25, 'M', 1.75);
        pessoas[1] = new Pessoa(1, "Maria", 30, 'F', 1.65);
        pessoas[2] = new Pessoa(2, "Carlos", 40, 'M', 1.80);
        pessoas[3] = new Pessoa(3, "Ana", 28, 'F', 1.60);

        enderecos[0] = new Endereco(0, "Rua Treze", 123, "12345-678", "Limeira", "SP", "Brasil");
        enderecos[1] = new Endereco(1, "Rua Vinte", 456, "98765-432", "Americana", "SP", "Brasil");
        enderecos[2] = new Endereco(2, "Rua Dois", 789, "54321-876", "Rio Claro", "SP", "Brasil");
        enderecos[3] = new Endereco(3, "Rua Onze", 987, "87654-321", "Sao Paulo", "SP", "Brasil");
    }
    /**
     * Obtém a lista de pessoas cadastradas.
     *
     * @return Um array contendo as pessoas cadastradas.
     */
    public static Pessoa[] getPessoas() {
        return pessoas;
    }
    /**
     * Obtém a lista de endereços cadastrados.
     *
     * @return Um array contendo os endereços cadastrados.
     */
    public static Endereco[] getEnderecos() {
        return enderecos;
    }

    /**
     * Adiciona uma nova pessoa ao cadastro.
     *
     * @param nome   O nome da pessoa.
     * @param idade  A idade da pessoa.
     * @param sexo   O sexo da pessoa ('M' para masculino, 'F' para feminino).
     * @param altura A altura da pessoa.
     */
    public static void addPessoa(String nome, Integer idade, Character sexo, Double altura) {

        int id;
        if (contadorPessoa < capacidade) {
            id = contadorPessoa;
            try {
                Pessoa pessoaCadastrar = new Pessoa(id, nome, idade, sexo, altura);
                pessoas[contadorPessoa] = pessoaCadastrar;
                contadorPessoa++;
            } catch (Exception e) {
                Menu.erro("Erro: Digite um numero válido!");
                ConsoleUI.cadastrarPessoa();
            }

        } else {
            contadorPessoa = 0;
            id = contadorPessoa;
            try {
                Pessoa pessoaCadastrar = new Pessoa(id, nome, idade, sexo, altura);
                pessoas[contadorPessoa] = pessoaCadastrar;
                contadorPessoa++;
            } catch (Exception e) {
                Menu.erro("Digite um numero válido!");
                ConsoleUI.cadastrarPessoa();
            }
        }
    }

    /**
     * Adiciona um novo endereço ao cadastro.
     *
     * @param rua    O nome da rua.
     * @param numero O número do endereço.
     * @param cep    O CEP do endereço.
     * @param cidade O nome da cidade.
     * @param estado O estado do endereço.
     * @param pais   O país do endereço.
     */
    public static void addEndereco(String rua, Integer numero, String cep, String cidade, String estado, String pais) {
        int id;
        if (contadorEndereco < capacidade) {
            id = contadorEndereco;
            try {
                Endereco enderecoCadastrar = new Endereco(id, rua, numero, cep, cidade, estado, pais);
                enderecos[contadorEndereco] = enderecoCadastrar;
                contadorEndereco++;
            } catch (Exception e) {
                Menu.erro("Erro: Digite um numero válido!");
                ConsoleUI.cadastrarEndereco();
            }
        } else {
            contadorEndereco = 0;
            try {
                addEndereco(rua, numero, cep, cidade, estado, pais);
            } catch (Exception e) {
                Menu.erro("Digite um numero válido!");
                ConsoleUI.cadastrarEndereco();
            }
        }
    }
    /**
     * Atualiza informações de uma pessoa no cadastro.
     *
     * @param id        O ID da pessoa a ser atualizada.
     * @param campo     O campo a ser atualizado ('nome', 'idade', 'sexo' ou 'altura').
     * @param novoValor O novo valor a ser atribuído ao campo.
     */
    public static void updatePessoa(int id, String campo, String novoValor) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa != null && pessoa.getId() == id) {
                switch (campo) {
                    case "nome" -> pessoa.setNome(novoValor);
                    case "idade" -> pessoa.setIdade(Integer.parseInt(novoValor));
                    case "sexo" -> pessoa.setSexo(novoValor.charAt(0));
                    case "altura" -> pessoa.setAltura(Double.parseDouble(novoValor));
                    default -> {
                        Menu.erro("O campo informado não existe.");
                        return;
                    }
                }
                Menu.sucesso("Atualização realizada com sucesso!");
                return;
            }
        }
        System.out.println("ID da pessoa não encontrado");
    }
    /**
     * Atualiza informações de um endereço no cadastro.
     *
     * @param id        O ID do endereço a ser atualizado.
     * @param campo     O campo a ser atualizado ('rua', 'numero', 'cep', 'cidade', 'estado' ou 'pais').
     * @param novoValor O novo valor a ser atribuído ao campo.
     */
    public static void updateEndereco(int id, String campo, String novoValor) {
        for (Endereco endereco : enderecos) {
            if (endereco != null && endereco.getId() == id) {
                switch (campo) {
                    case "rua" -> endereco.setRua(novoValor);
                    case "numero" -> endereco.setNumero(Integer.parseInt(novoValor));
                    case "cep" -> endereco.setCep(novoValor);
                    case "cidade" -> endereco.setCidade(novoValor);
                    case "estado" -> endereco.setEstado(novoValor);
                    case "pais" -> endereco.setPais(novoValor);
                    default -> {
                        System.out.println("O campo informado não existe.");
                        return;
                    }
                }
                Menu.sucesso("Atualização realizada com sucesso!");
                return;
            }
        }
        System.out.println("ID do endereço não encontrado");

    }
    /**
     * Exclui uma pessoa do cadastro.
     *
     * @param id O ID da pessoa a ser excluída.
     */
    public static void deletePessoa(int id) {
        for (int i = 0; i < enderecos.length; i++) {
            if (pessoas[i] != null && pessoas[i].getId() == id) {
                pessoas[i] = null;
                return;
            }
        }
    }
    /**
     * Exclui um endereço do cadastro.
     *
     * @param id O ID do endereço a ser excluído.
     */
    public static void deleteEndereco(int id) {
        for (int i = 0; i < enderecos.length; i++) {
            if (enderecos[i] != null && enderecos[i].getId() == id) {
                enderecos[i] = null;
                return;
            }
        }

    }
}