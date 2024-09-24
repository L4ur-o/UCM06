public class PIS extends ImpostoBase {
    private double debito;
    private double credito;

    public PIS(double debito, double credito) {
        super("PIS");
        this.debito = debito;
        this.credito = credito;
    }

    @Override
    public double calcularImposto() {
        return (debito - credito) * 0.0165;
    }
}
