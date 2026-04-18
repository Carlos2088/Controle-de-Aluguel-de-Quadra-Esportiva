package Controller;

import Model.Horario;
import Repository.HorarioRepository;

public class HorarioController {
    private HorarioRepository repo = new HorarioRepository();

    public Horario cadastrar(String descricao, double valor) {
        Horario h = new Horario(descricao, valor);
        repo.salvar(h);
        return h;
    }
}
