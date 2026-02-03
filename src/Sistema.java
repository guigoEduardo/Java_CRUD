package src;
import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Produto> produtos = new ArrayList<>();

        int opcao = 0;

        while (opcao != 5) {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Adicionar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Atualizar produto");
            System.out.println("4 - Deletar produto");
            System.out.println("5 - Sair");

            System.out.println("Escolha uma opcao\n");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o ID do produto: ");
                    int id = scanner.nextInt();

                    scanner.nextLine();

                    System.out.println("Digite o nome do produto: ");
                    String nome = scanner.nextLine();

                    System.out.println("Digite o preço do produto: ");
                    double preco = scanner.nextDouble();

                    Produto produto = new Produto(id, nome, preco);
                    produtos.add(produto);

                    System.out.println("Produto adicionado com sucesso!");
                    break;

                case 2:
                    if (produtos.isEmpty()) {
                        System.out.println("Nenhum produto cadastrado.");
                    } else{
                        System.out.println("\n=== LISTA DE PRODUTOS ===");
                        for (Produto p : produtos) {
                            System.out.println(
                                "ID: " + p.getId() +
                                " | Nome: " +  p.getNome() +
                                " | Preço: " + p.getPreco() 
                            );
                        }
                    }
                    break;

                case 3:
                    System.out.println("Digite o ID do produto para atualizar: ");
                    int IdAtualizar = scanner.nextInt();

                    scanner.nextLine();

                    boolean encontrado = false;

                    for (Produto p : produtos) {
                        if (p.getId() == IdAtualizar) {
                            System.out.println("Novo nome: ");
                            String novoNome = scanner.next();

                            System.out.println("Novo preço: ");
                            double novoPreco = scanner.nextDouble();

                            p.setNome(novoNome);
                            p.setPreco(novoPreco);

                            System.out.println("Produto atualizado com sucesso!");
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Produto não encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("Digite o ID do produto para deletar: ");
                    int idDeletar = scanner.nextInt();

                    boolean removido = false;
                    
                    for (Produto p : produtos) {
                        if (p.getId() == idDeletar) {
                            produtos.remove(p);
                            System.out.println("Produto removido com sucesso!");
                            removido = true;
                            break;
                        }
                    }

                    if (!removido) {
                        System.out.println("Produto não encontrado.");
                    }
                    break;

                case 5:
                    System.out.println("Saindo do sistema");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
        scanner.close();
    }
}
