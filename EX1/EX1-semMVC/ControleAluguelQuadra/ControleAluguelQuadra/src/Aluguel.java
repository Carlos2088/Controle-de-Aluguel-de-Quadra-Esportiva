public class Aluguel {
    private static int contador = 1;
    private int id;
    private Cliente cliente;
    private Horario horario;
    private String data;

    public Aluguel(Cliente cliente, Horario horario, String data) {
        if (!horario.isDisponivel()) {
            throw new IllegalStateException("Horário " + horario.getDescricao() + " já está ocupado.");
        }
        this.id = contador++;
        this.cliente = cliente;
        this.horario = horario;
        this.data = data;
        horario.setDisponivel(false);
    }

    public int getId() { return id; }
    public Cliente getCliente() { return cliente; }
    public Horario getHorario() { return horario; }
    public String getData() { return data; }
    public double getValor() { return horario.getValor(); }

    @Override
    public String toString() {
        return "Aluguel (id = " + id + ", cliente = " + cliente.getNome() +
                ", horário = " + horario.getDescricao() + ", data = " + data +
                ", valor = R$" + horario.getValor() + ")";
    }
}
