import Controller.AluguelController;
import Controller.ClienteController;
import Controller.HorarioController;
import Model.Cliente;
import Model.Horario;
import View.QuadraView;
import java.util.List;
import Model.Aluguel;

public class Main {
    public static void main(String[] args) {

        ClienteController clienteCtrl = new ClienteController();
        HorarioController horarioCtrl = new HorarioController();
        AluguelController aluguelCtrl = new AluguelController();
        QuadraView view = new QuadraView();

        Cliente c1 = clienteCtrl.cadastrar("Evelyn", "11999990001");
        Cliente c2 = clienteCtrl.cadastrar("Darth Vader", "11999990002");

        view.exibirMensagem("Cadastrado: " + c1);
        view.exibirMensagem("Cadastrado: " + c2);

        Horario h1 = horarioCtrl.cadastrar("08:00 - 09:00", 80.0);
        Horario h2 = horarioCtrl.cadastrar("10:00 - 11:00", 80.0);
        Horario h3 = horarioCtrl.cadastrar("10:00 - 11:00", 100.0);

        aluguelCtrl.registrar(c1, h1, "17/04/2026");
        aluguelCtrl.registrar(c1, h2, "18/04/2026");
        aluguelCtrl.registrar(c2, h3, "17/04/2026");

        try {
            aluguelCtrl.registrar(c2, h1, "17/04/2026");
        } catch (IllegalStateException e) {
            view.exibirErro(e.getMessage());
        }

        List<Aluguel> lista = aluguelCtrl.consultarPorData("17/04/2026");
        view.exibirAlugueisDoDia("17/04/2026", lista);

        // Total do cliente no dia
        double total = aluguelCtrl.calcularTotalClienteNoDia(c1, "17/04/2026");
        view.exibirTotalCliente(c1.getNome(), "17/04/2026", total);

        try {
            clienteCtrl.cadastrar("", "11900000000");
        } catch (IllegalArgumentException e) {
            view.exibirErro(e.getMessage());
        }

        try {
            horarioCtrl.cadastrar("14:00 - 15:00", -50.0);
        } catch (IllegalArgumentException e) {
            view.exibirErro(e.getMessage());
        }
    }
}
