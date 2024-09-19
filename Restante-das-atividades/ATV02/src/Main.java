/*
Cada pacote de viagens é formado pelo meio de transporte e pela hospedagem – cada meio de transporte tem tipo
e valor e cada hospedagem tem tipo e valor. Os valores de pacote de viagem são formados pelos valores do transporte
e da hospedagem somados a uma margem de lucro e taxas adicionais. A venda inclui dados do cliente,
forma de pagamento, data e pacote sendo vendido e precisa ser capaz de converter
o valor do pacote em reais para dólar e vice-versa.
Classe para transporte, com o tipo (aéreo, rodoviário, marítimo etc.) e valor
Classe para hospedagem, com descrição e valor de diária
Classe para pacote de viagem, com transporte, hospedagem, destino (texto), quantidade de dias. Essa classe ainda deve ser capaz de
calcular o total de hospedagem a partir do número de dias e o valor da diária.
calcular valor de lucro a partir de uma margem informada (porcentagem) e valor informado. O resultado retornado deve ser o valor + margem aplicada ao valor.
calcular e retornar o total do pacote, somando o transporte, o total da hospedagem e os valores adicionais informados – margem de lucro (porcentagem) e taxas adicionais (valor monetário).
Observação: os valores nesta classe serão considerados em dólar.
Classe para venda, que contenha nome do cliente, forma de pagamento e pacote de viagem. A classe deve ser capaz de
converter um valor em reais a partir de um valor informado em dólar e da cotação da moeda, também informada.
mostrar na tela o total do pacote de viagem em dólar e em reais.
Na classe principal, elabore código para interação com o usuário em que seja possível “cadastrar” uma venda e
obtenha todos os valores necessários para criar um pacote de viagem e crie esse objeto.
mostre na tela as informações do pacote criado, incluindo o valor total. O usuário ainda precisará informar margem de lucro (uma porcentagem).
obtenha do usuário também as informações para a criação de uma venda.
mostre na tela todas as informações da venda, incluindo valor total em dólar e valor em reais (o usuário terá que informar a cotação do dólar no dia).
Recomenda-se o uso de construtores nas classes.
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String tipoTransporte = escolherTipoTransporte(sc);

        System.out.print("Informe o valor do transporte: ");
        double valorTransporte = sc.nextDouble();

        int estrelasHospedagem = escolherEstrelasHospedagem(sc);

        System.out.print("Informe o valor da diária: ");
        double valorDiaria = sc.nextDouble();

        System.out.print("Informe o destino: ");
        sc.nextLine();  // Limpar o buffer
        String destino = sc.nextLine();
        System.out.print("Informe a quantidade de dias: ");
        int dias = sc.nextInt();

        Transporte transporte = new Transporte(tipoTransporte, valorTransporte);
        Hospedagem hospedagem = new Hospedagem(estrelasHospedagem + " estrelas", valorDiaria);
        PacoteViagem pacote = new PacoteViagem(transporte, hospedagem, destino, dias);

        System.out.println("\nInforme os dados do cliente:");
        System.out.print("Nome do cliente: ");
        sc.nextLine();  // Limpar o buffer
        String nomeCliente = sc.nextLine();
        System.out.print("Forma de pagamento: ");
        String formaPagamento = sc.nextLine();

        Venda venda = new Venda(nomeCliente, formaPagamento, pacote);

        System.out.print("Informe a cotação do dólar: ");
        double cotacaoDolar = sc.nextDouble();

        System.out.println("\nInformações do Pacote de Viagem:");
        System.out.println(venda);

        System.out.println("\nTotais:");
        venda.mostrarTotais(cotacaoDolar);

        sc.close();
    }

    public static String escolherTipoTransporte(Scanner sc) {
        int opcao = -1;
        String tipoTransporte = "";

        while (opcao < 1 || opcao > 3) {
            System.out.println("Escolha o tipo de transporte:");
            System.out.println("1 - Aéreo");
            System.out.println("2 - Rodoviário");
            System.out.println("3 - Marítimo");
            System.out.print("Sua escolha: ");

            if (sc.hasNextInt()) {
                opcao = sc.nextInt();
                switch (opcao) {
                    case 1:
                        tipoTransporte = "Aéreo";
                        break;
                    case 2:
                        tipoTransporte = "Rodoviário";
                        break;
                    case 3:
                        tipoTransporte = "Marítimo";
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } else {
                System.out.println("Entrada inválida. Digite um número.");
                sc.next();  // Limpar a entrada inválida
            }
        }

        return tipoTransporte;
    }

    public static int escolherEstrelasHospedagem(Scanner sc) {
        int estrelas = -1;

        while (estrelas < 1 || estrelas > 5) {
            System.out.println("Quantas estrelas será o hostel que irá se hospedar? (Escolha entre 1 a 5 estrelas)");
            System.out.print("Sua escolha: ");

            if (sc.hasNextInt()) {
                estrelas = sc.nextInt();
                if (estrelas < 1 || estrelas > 5) {
                    System.out.println("Tente novamente. Escolha entre 1 e 5 estrelas.");
                }
            } else {
                System.out.println("Entrada inválida. Digite um número.");
                sc.next();  // Limpar a entrada inválida
            }
        }

        return estrelas;
    }
}
