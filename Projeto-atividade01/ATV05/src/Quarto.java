public class Quarto {
    private boolean ocupado;

    public Quarto() {
        this.ocupado = false;
    }

    public void ocupar() {
        this.ocupado = true;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    @Override
    public String toString() {
        return ocupado ? "ocupado" : "desocupado";
    }
}
