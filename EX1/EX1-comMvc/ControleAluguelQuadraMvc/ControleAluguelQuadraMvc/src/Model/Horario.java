package Model;

public class Horario {
    private static int contador = 1;
    private int id;
    private String descricao;
    private double valor;
    private boolean disponivel;

    public Horario(String descricao, double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("Valor do horário não pode ser negativo.");
        }
        this.id = contador++;
        this.descricao = descricao;
        this.valor = valor;
        this.disponivel = true;
    }

    public int getId() { return id; }
    public String getDescricao() { return descricao; }
    public double getValor() { return valor; }
    public boolean isDisponivel() { return disponivel; }
    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }

    @Override
    public String toString() {
        return "Horario (id = " + id + ", descricao = " + descricao + ", valor = " + valor + ", disponivel = " + disponivel + ")";
    }
}
