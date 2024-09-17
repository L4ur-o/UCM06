import java.util.Scanner;

public class Hotel {
    private Quarto[][] quartos;

    public Hotel(int andares, int quartosPorAndar) {
        this.quartos = new Quarto[andares][quartosPorAndar];

        for (int i = 0; i < andares; i++) {
            for (int j = 0; j < quartosPorAndar; j++) {
                quartos[i][j] = new Quarto();
            }
        }
    }

    public void registrarOcupacao(Scanner sc) {
        int andar = -1;
        int quarto = -1;

        while (andar < 1 || andar > 4) {
            System.out.print("Informe o andar (1 a 4): ");

            if (sc.hasNextInt()) {
                andar = sc.nextInt();
                if (andar < 1 || andar > 4) {
                    System.out.println("Número de andar inválido. Tente novamente usando apenas os números citados.");
                }
            } else {
                System.out.println("Entrada inválida. Tente novamente usando apenas os números citados.");
                sc.next();
            }
        }

        while (quarto < 1 || quarto > 3) {
            System.out.print("Informe o número do quarto (1 a 3): ");

            if (sc.hasNextInt()) {
                quarto = sc.nextInt();
                if (quarto < 1 || quarto > 3) {
                    System.out.println("Número de quarto inválido. Tente novamente usando apenas os números citados.");
                }
            } else {
                System.out.println("Entrada inválida. Tente novamente usando apenas os números citados.");
                sc.next();
            }
        }

        quartos[andar - 1][quarto - 1].ocupar();
    }

    public void mostrarOcupacaoDetalhada() {
        for (int i = 0; i < quartos.length; i++) {
            System.out.println((i + 1) + "º andar:");
            for (int j = 0; j < quartos[i].length; j++) {
                System.out.println("- Quarto " + (j + 1) + " " + quartos[i][j]);
            }
            System.out.println();
        }
    }
}
