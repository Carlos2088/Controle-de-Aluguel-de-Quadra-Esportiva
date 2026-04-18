import java.util.ArrayList;
import java.util.List;

public class SistemaQuadra {
    private List<Cliente> clientes = new ArrayList<>();
    private List<Horario> horarios = new ArrayList<>();
    private List<Aluguel> alugueis = new ArrayList<>();

    public void cadastrarCliente(Cliente c) {
        clientes.add(c);
        System.out.println("Cliente cadastrado: " + c);
    }

    public void cadastrarHorario(Horario h) {
        horarios.add(h);
        System.out.println("Horário cadastrado: " + h);
    }

    public void registrarAluguel(Cliente cliente, Horario horario, String data) {
        // Verifica se já existe aluguel no mesmo horário e data
        for (Aluguel a : alugueis) {
            if (a.getData().equals(data) &&
                    a.getHorario().getDescricao().equals(horario.getDescricao())) {
                throw new IllegalStateException("Já existe uma reserva para o horário "
                        + horario.getDescricao() + " nesta data.");
            }
        }
        Aluguel aluguel = new Aluguel(cliente, horario, data);
        alugueis.add(aluguel);
        System.out.println("Aluguel registrado: " + aluguel);
    }

    public void consultarPorData(String data) {
        System.out.println("\n--- Aluguéis do dia " + data + " ---");
        double total = 0;
        for (Aluguel aluguel : alugueis) {
            if (aluguel.getData().equals(data)) {
                System.out.println(aluguel);
                total += aluguel.getValor();
            }
        }
        System.out.println("Total do dia: R$" + total);
    }

    public double calcularTotalClienteNoDia(Cliente cliente, String data) {
        double total = 0;
        for (Aluguel aluguel : alugueis) {
            if (aluguel.getCliente().getId() == cliente.getId() && aluguel.getData().equals(data)) {
                total += aluguel.getValor(); // primeiro ele faz a comparacao pelo id depois pela data
            }
        }
        return total;
    }
}
