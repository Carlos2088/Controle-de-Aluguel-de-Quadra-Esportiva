package Repository;

import Model.Horario;
import java.util.ArrayList;
import java.util.List;

public class HorarioRepository {
    private List<Horario> horarios = new ArrayList<>();

    public void salvar(Horario h) { horarios.add(h); }
    public List<Horario> listarTodos() { return horarios; }
    public Horario buscarPorId(int id) {
        for (Horario h : horarios) {
            if (h.getId() == id) return h;
        }
        return null;
    }
}
