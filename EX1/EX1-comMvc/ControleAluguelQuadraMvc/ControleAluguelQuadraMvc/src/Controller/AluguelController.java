package Controller;

import Model.Aluguel;
import Model.Cliente;
import Model.Horario;
import Repository.AluguelRepository;
import java.util.List;

public class AluguelController {
    private AluguelRepository repo = new AluguelRepository();

    public void registrar(Cliente cliente, Horario horario, String data) {
        for (Aluguel aluguel : repo.buscarPorData(data)) {
            if (aluguel.getHorario().getDescricao().equals(horario.getDescricao())) {
                throw new IllegalStateException("Já existe uma reserva para o horário "
                        + horario.getDescricao() + " nesta data.");
            }
        }
        Aluguel a = new Aluguel(cliente, horario, data);
        horario.setDisponivel(false);
        repo.salvar(a);
    }

    public List<Aluguel> consultarPorData(String data) {
        return repo.buscarPorData(data);
    }

    public double calcularTotalClienteNoDia(Cliente cliente, String data) {
        double total = 0;
        for (Aluguel a : repo.buscarPorData(data)) {
            if (a.getCliente().getId() == cliente.getId()) {
                total += a.getValor();
            }
        }
        return total;
    }
}
