import java.util.ArrayList;
import java.util.List;

public class Pagamentos {
    private String nomeEmpresa;
    private List<Imposto> listaImpostos;

    public Pagamentos(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
        this.listaImpostos = new ArrayList<>();
    }

    public void adicionarImposto(Imposto imposto) {
        listaImpostos.add(imposto);
    }

    public void exibirResumoImpostos() {
        System.out.println("\nResumo dos impostos para a empresa: " + nomeEmpresa);
        for (Imposto imposto : listaImpostos) {
            System.out.printf("Imposto: %s - Valor Calculado: %.3f%n", imposto.getDescricao(), imposto.calcularImposto());
        }
    }
}
