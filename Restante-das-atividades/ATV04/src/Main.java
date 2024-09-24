import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe o nome da empresa: ");
        String nomeEmpresa = scanner.nextLine();

        Pagamentos pagamentos = new Pagamentos(nomeEmpresa);

        while (true) {
            System.out.println("\nEscolha o tipo de imposto a ser calculado:");
            System.out.println("1 - PIS");
            System.out.println("2 - IPI");
            System.out.println("Digite 'pare' para finalizar.");
            String opcao = scanner.nextLine();

            if (opcao.equalsIgnoreCase("pare")) {
                break;
            }

            switch (opcao) {
                case "1":
                    System.out.print("Informe o valor total de débito: ");
                    double debito = scanner.nextDouble();
                    System.out.print("Informe o valor total de crédito: ");
                    double credito = scanner.nextDouble();
                    pagamentos.adicionarImposto(new PIS(debito, credito));
                    break;

                case "2":
                    System.out.print("Informe o valor do produto: ");
                    double valorProduto = scanner.nextDouble();
                    System.out.print("Informe o valor do frete: ");
                    double frete = scanner.nextDouble();
                    System.out.print("Informe o valor do seguro: ");
                    double seguro = scanner.nextDouble();
                    System.out.print("Informe o valor de outras despesas: ");
                    double outrasDespesas = scanner.nextDouble();
                    System.out.print("Informe a alíquota do IPI (em %): ");
                    double aliquota = scanner.nextDouble();
                    pagamentos.adicionarImposto(new IPI(valorProduto, frete, seguro, outrasDespesas, aliquota));
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
            scanner.nextLine();
        }


        pagamentos.exibirResumoImpostos();
        scanner.close();
    }
}
