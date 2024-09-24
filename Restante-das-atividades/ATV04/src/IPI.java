public class IPI extends ImpostoBase {
    private double valorProduto;
    private double frete;
    private double seguro;
    private double outrasDespesas;
    private double aliquota;

    public IPI(double valorProduto, double frete, double seguro, double outrasDespesas, double aliquota) {
        super("IPI");
        this.valorProduto = valorProduto;
        this.frete = frete;
        this.seguro = seguro;
        this.outrasDespesas = outrasDespesas;
        this.aliquota = aliquota;
    }

    @Override
    public double calcularImposto() {
        double baseCalculo = valorProduto + frete + seguro + outrasDespesas;
        return baseCalculo * (aliquota / 100);
    }
}
