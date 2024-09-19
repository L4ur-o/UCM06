import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Funcionario> funcionarios = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            System.out.println("Cadastro de funcionário #" + (i + 1));

            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("CPF: ");
            String cpf = scanner.nextLine();

            System.out.print("Endereço: ");
            String endereco = scanner.nextLine();

            System.out.print("Telefone: ");
            String telefone = scanner.nextLine();

            System.out.print("Setor: ");
            String setor = scanner.nextLine();

            System.out.print("Tipo de funcionário (1 - Assalariado, 2 - Horista): ");
            int tipo = scanner.nextInt();

            if (tipo == 1) {
                System.out.print("Salário mensal: ");
                double salarioMensal = scanner.nextDouble();
                scanner.nextLine();  // Limpar o buffer
                Funcionario assalariado = new Assalariado(nome, cpf, endereco, telefone, setor, salarioMensal);
                funcionarios.add(assalariado);
            } else if (tipo == 2) {
                System.out.print("Horas trabalhadas: ");
                double horasTrabalhadas = scanner.nextDouble();

                System.out.print("Valor por hora: ");
                double valorHora = scanner.nextDouble();
                scanner.nextLine();  // Limpar o buffer
                Funcionario horista = new Horista(nome, cpf, endereco, telefone, setor, horasTrabalhadas, valorHora);
                funcionarios.add(horista);
            }

            System.out.print("Deseja cadastrar outro funcionário? (S/N): ");
            String resposta = scanner.next();
            scanner.nextLine();  // Limpar o buffer
            if (resposta.equalsIgnoreCase("N")) {
                break;
            }
        }

        System.out.println("\n--- Dados e Salários dos Funcionários ---");
        for (Funcionario f : funcionarios) {
            f.mostrarDados();
            System.out.printf("Salário: R$ %.3f\n", f.calcularSalario());
            System.out.println("------------------------------");
        }

        System.out.print("Informe o percentual de aumento para todos os funcionários: ");
        double aumentoPercentual = scanner.nextDouble();

        for (Funcionario f : funcionarios) {
            f.aplicarAumento(aumentoPercentual);
        }

        System.out.println("\n--- Dados e Salários com Aumento ---");
        for (Funcionario f : funcionarios) {
            f.mostrarDados();
            System.out.printf("Salário com aumento: R$ %.3f\n", f.calcularSalario());
            System.out.println("------------------------------");
        }

        scanner.close();
    }
}
