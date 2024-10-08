public class Hospedagem {
    private String descricao;
    private double valorDiaria;

    public Hospedagem(String descricao, double valorDiaria) {
        this.descricao = descricao;
        this.valorDiaria = valorDiaria;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    @Override
    public String toString() {
        return "Hospedagem: " + descricao + " | Valor diária: $" + valorDiaria;
    }
}
