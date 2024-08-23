package src.com.padaria;

import java.util.Scanner;

public class PadariaApp {
    public static void main(String[] args) {
        // Inicialização do estoque
        Estoque estoque = new Estoque();
        estoque.adicionarProduto(new Produto("Pão", 2.50, 100));
        estoque.adicionarProduto(new Produto("Bolo", 15.00, 20));

        // Interface de usuário
        Scanner scanner = new Scanner(System.in);
        Pedido pedido = new Pedido();

        while (true) {
            System.out.println("\n1. Listar Produtos");
            System.out.println("2. Adicionar ao Pedido");
            System.out.println("3. Exibir Pedido");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    estoque.listarProdutos();
                    break;
                case 2:
                    System.out.print("Digite o nome do produto: ");
                    String nome = scanner.nextLine();
                    Produto produto = estoque.buscarProduto(nome);
                    if (produto != null) {
                        System.out.print("Digite a quantidade: ");
                        int quantidade = scanner.nextInt();
                        scanner.nextLine(); // Limpar buffer
                        pedido.adicionarItem(produto, quantidade);
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;
                case 3:
                    pedido.exibirPedido();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}
