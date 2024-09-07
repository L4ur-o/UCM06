public class Main {
    public static void main(String[] args) {
        Hospede hospede = new Hospede();
        int opcao = 0;

        while (opcao != 3) {

            if (hospede.getNumeroDeHospedes() == 15) {
                System.out.println("Máximo de cadastros atingido");
                opcao = Menu.mostrarOpcaoPesquisa();
                if (opcao == 2) {
                    System.out.println(hospede.pesquisaHospede());
                } else if (opcao == 3) {
                    break;
                }
            } else {
                opcao = Menu.mostrarMenu();
                if (opcao == 1) {
                    hospede.cadastrarHospede();
                } else if (opcao == 2) {
                    System.out.println(hospede.pesquisaHospede());
                } else if (opcao == 3) {
                    break;
                } else {
                    System.out.println("Número ínválido, tente novamente");
                }
            }
        }
    }
}
