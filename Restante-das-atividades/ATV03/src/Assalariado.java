public class Assalariado extends Funcionario{
    private double salarioMensal;

    public Assalariado(String nome, String cpf, String endereco, String telefone, String setor, double salarioMensal) {
        super(nome, cpf, endereco, telefone, setor);
        this.salarioMensal = salarioMensal;
    }

    @Override
    public double calcularSalario() {
        return salarioMensal;
    }

    @Override
    public void aplicarAumento(double percentual) {
        salarioMensal += salarioMensal * percentual / 100;
    }
}
