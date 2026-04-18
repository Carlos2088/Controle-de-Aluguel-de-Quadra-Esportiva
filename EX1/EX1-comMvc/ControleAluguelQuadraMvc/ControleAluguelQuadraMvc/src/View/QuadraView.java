package View;

import Model.Aluguel;
import java.util.List;

public class QuadraView {

    public void exibirAluguel(Aluguel aluguel) {
        System.out.println("Aluguel registrado: " + aluguel);
    }

    public void exibirAlugueisDoDia(String data, List<Aluguel> alugueis) {
        System.out.println("\n--- Aluguéis do dia " + data + " ---");
        double total = 0;
        for (Aluguel a : alugueis) {
            System.out.println(a);
            total += a.getValor();
        }
        System.out.printf("Total do dia: R$%.2f%n", total);
    }

    public void exibirTotalCliente(String nome, String data, double total) {
        System.out.printf("Total do cliente %s em %s: R$%.2f%n", nome, data, total);
    }

    public void exibirErro(String mensagem) {
        System.out.println("Erro: " + mensagem);
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}
