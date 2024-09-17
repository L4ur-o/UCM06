import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hotel hotel = new Hotel(4, 3);

        String continuar = "S";
        while (continuar.equalsIgnoreCase("S")) {
            hotel.registrarOcupacao(sc);

            System.out.print("Deseja informar outra ocupação? (S/N): ");
            continuar = sc.next();
        }

        hotel.mostrarOcupacaoDetalhada();

        sc.close();
    }
}
