public class Main {
    public static void main(String[] args) {
        SistemaQuadra sistema = new SistemaQuadra();

        // Cadastro de clientes
        Cliente c1 = new Cliente("Evelyn", "11999990001");
        Cliente c2 = new Cliente("Darth Vader", "11999990002");
        sistema.cadastrarCliente(c1);
        sistema.cadastrarCliente(c2);

        // Cadastro de horários
        Horario h1 = new Horario("09:00 - 11:00", 80.0);// Se colocar 9 as 11 ele n da erro
        Horario h2 = new Horario("10:00 - 11:00", 80.0); // agora ser for igual sim, 10:00 as 11:00
        Horario h3 = new Horario("10:00 - 11:00", 100.0);

        sistema.cadastrarHorario(h1); // Recebe os valor acima
        sistema.cadastrarHorario(h2);
        sistema.cadastrarHorario(h3);

        // Registrar aluguéis
        sistema.registrarAluguel(c1, h1, "17/04/2026");
        sistema.registrarAluguel(c1, h2, "18/04/2026");
        sistema.registrarAluguel(c2, h3, "17/04/2026");

        // Tentar reservar horário já ocupado
        try {
            sistema.registrarAluguel(c2, h1, "17/04/2026"); // Caso a reserva seja na mesma data
        } catch (IllegalStateException e) { // se nao for funfa normal
            System.out.println("Erro esperado: " + e.getMessage());
        }

        // Consultar aluguéis do dia
        sistema.consultarPorData("17/04/2026");

        // Total de um cliente no dia
        double totalJoao = sistema.calcularTotalClienteNoDia(c1, "17/04/2026");
        System.out.println("\nTotal do João no dia: R$" + totalJoao);

        // Tentar cadastrar cliente com nome vazio
        try {
            new Cliente("", "11900000000");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro esperado: " + e.getMessage()); // aqui é para "Provar" que a regra
            // de negócio ta funfando.
        }

        // Tentar cadastrar horário com valor negativo
        try {
            new Horario("14:00 - 15:00", -50.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro esperado: " + e.getMessage()); //Mesma coisa aqui
        }
    }
}
