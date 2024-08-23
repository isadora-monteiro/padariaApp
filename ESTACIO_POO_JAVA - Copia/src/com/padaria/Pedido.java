package src.com.padaria;


import java.util.HashMap;
import java.util.Map;

public class Pedido {
    private Map<Produto, Integer> itens = new HashMap<>();

    public void adicionarItem(Produto produto, int quantidade) {
        if (produto.getQuantidadeEmEstoque() >= quantidade) {
            itens.put(produto, itens.getOrDefault(produto, 0) + quantidade);
            produto.ajustarEstoque(-quantidade);
        } else {
            System.out.println("Quantidade insuficiente para " + produto.getNome());
        }
    }

    public double calcularTotal() {
        double total = 0;
        for (Map.Entry<Produto, Integer> entry : itens.entrySet()) {
            total += entry.getKey().getPreco() * entry.getValue();
        }
        return total;
    }

    public void exibirPedido() {
        System.out.println("Itens do Pedido:");
        for (Map.Entry<Produto, Integer> entry : itens.entrySet()) {
            System.out
                    .println(entry.getKey().getNome() + ": " + entry.getValue() + " x R$" + entry.getKey().getPreco());
        }
        System.out.println("Total: R$" + calcularTotal());
    }
}
