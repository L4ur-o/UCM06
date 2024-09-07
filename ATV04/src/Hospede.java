import java.util.ArrayList;
import java.util.Scanner;

public class Hospede {
    private ArrayList<String> listaDeHospedes = new ArrayList<>();

    public String nomeHospede() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do hóspede: ");
        return scanner.nextLine();
    }

    public String pesquisaHospede() {
        String nome = nomeHospede();
        if (listaDeHospedes.contains(nome)) {
            int indice = listaDeHospedes.indexOf(nome);
            return "Hóspede " + nome + " foi encontrado no índice " + indice;
        } else {
            return "Hóspede " + nome + " não encontrado";
        }
    }

    public void cadastrarHospede() {
        if (listaDeHospedes.size() < 15) {
            listaDeHospedes.add(nomeHospede());
        } else {
            System.out.println("Máximo de cadastros atingido.");
        }
    }

    public int getNumeroDeHospedes() {
        return listaDeHospedes.size();
    }
}
