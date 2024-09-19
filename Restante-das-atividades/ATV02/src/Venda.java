public class Venda {
    private String nomeCliente;
    private String formaPagamento;
    private PacoteViagem pacote;

    public Venda(String nomeCliente, String formaPagamento, PacoteViagem pacote) {
        this.nomeCliente = nomeCliente;
        this.formaPagamento = formaPagamento;
        this.pacote = pacote;
    }

    public double converterParaReais(double valorDolar, double cotacaoDolar) {
        return valorDolar * cotacaoDolar;
    }

    public void mostrarTotais(double cotacaoDolar) {
        double totalDolar = pacote.calcularTotalPacote(10, 50); // Exemplo de margem de lucro e taxas
        double totalReais = converterParaReais(totalDolar, cotacaoDolar);

        System.out.println("Valor total em dólar: $" + totalDolar);
        System.out.println("Valor total em reais: R$" + totalReais);
    }

    @Override
    public String toString() {
        return "Cliente: " + nomeCliente + "\nForma de Pagamento: " + formaPagamento + "\n" + pacote.toString();
    }
}
