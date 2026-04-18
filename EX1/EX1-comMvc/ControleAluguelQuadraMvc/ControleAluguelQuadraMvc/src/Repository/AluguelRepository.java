package Repository;

import Model.Aluguel;
import java.util.ArrayList;
import java.util.List;

public class AluguelRepository {
    private List<Aluguel> alugueis = new ArrayList<>();

    public void salvar(Aluguel a) { alugueis.add(a); }
    public List<Aluguel> listarTodos() { return alugueis; }
    public List<Aluguel> buscarPorData(String data) {
        List<Aluguel> resultado = new ArrayList<>();
        for (Aluguel a : alugueis) {
            if (a.getData().equals(data)) resultado.add(a);
        }
        return resultado;
    }
}
