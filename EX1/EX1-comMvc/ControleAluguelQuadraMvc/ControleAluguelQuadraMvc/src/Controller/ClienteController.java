package Controller;

import Model.Cliente;
import Repository.ClienteRepository;

public class ClienteController {
    private ClienteRepository repo = new ClienteRepository();

    public Cliente cadastrar(String nome, String telefone) {
        Cliente c = new Cliente(nome, telefone);
        repo.salvar(c);
        return c;
    }
}
