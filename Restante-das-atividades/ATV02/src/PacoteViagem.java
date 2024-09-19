public class PacoteViagem {
    private Transporte transporte;
    private Hospedagem hospedagem;
    private String destino;
    private int quantidadeDias;

    public PacoteViagem(Transporte transporte, Hospedagem hospedagem, String destino, int quantidadeDias) {
        this.transporte = transporte;
        this.hospedagem = hospedagem;
        this.destino = destino;
        this.quantidadeDias = quantidadeDias;
    }

    public double calcularTotalHospedagem() {
        return quantidadeDias * hospedagem.getValorDiaria();
    }

    public double calcularValorComLucro(double valor, double margemLucro) {
        return valor + (valor * margemLucro / 100);
    }

    public double calcularTotalPacote(double margemLucro, double taxasAdicionais) {
        double totalHospedagem = calcularTotalHospedagem();
        double totalTransporte = transporte.getValor();
        double total = totalHospedagem + totalTransporte;
        total = calcularValorComLucro(total, margemLucro);
        return total + taxasAdicionais;
    }

    @Override
    public String toString() {
        return "Destino: " + destino + "\nTransporte: " + transporte.getTipo() +
                "\nHospedagem: " + hospedagem.getDescricao() + "\nDias: " + quantidadeDias;
    }
}
