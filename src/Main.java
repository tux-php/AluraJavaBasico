import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        boolean sair = false;
        int opcao;
        double valor;

        Pessoa cliente = new Pessoa("Manoel Baia");
        ContaCorrente cc = new ContaCorrente(5000.00);
        System.out.println(getAbertura(cliente, cc));

        while (!sair) {
            System.out.println(getOpcoes());

            System.out.println("Digite a opção desejada:");
            opcao = leitura.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("O saldo atual é R$ " + cc.getSaldo());
                    break;
                case 2:
                    try {
                        System.out.println("Informe o valor a receber: ");
                        valor = leitura.nextDouble();
                        if ((valor > 0)) {
                            cc.recebeTransferencia(valor);
                            System.out.println("Saldo atualizado R$ " + cc.getSaldo());
                        } else {
                            System.out.println("Valor inválido.");
                        }
                        break;
                    } catch (Exception e) {
                        System.out.println("Ocorreu um erro no processamento. " + e.getMessage());
                    }

                case 3:
                    try {
                        System.out.println("Informe o valor que deseja transferir:");
                        valor = leitura.nextDouble();
                        if (cc.getSaldo() >= valor) {
                            cc.fazerTransferencia(valor);
                            System.out.println("Saldo atualizado R$ " + cc.getSaldo());
                        } else {
                            System.out.println("Não há saldo suficiente para fazer essa transferência.");
                        }
                        break;
                    } catch (Exception e) {
                        System.out.println("Ocorreu um erro no processamento. " + e.getMessage());
                    }

                case 4:
                    System.out.println("Saindo...");
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    private static String getAbertura(Pessoa cliente, ContaCorrente cc) {
        String abertura = """
                ***********************
                Dados iniciais do cliente:
                Nome: %s
                Tipo conta: %s
                Saldo inicial: R$ %.2f
                ***********************
                """.formatted(cliente.getNome(), cc.toString(), cc.getSaldo());
        return abertura;
    }

    private static String getOpcoes() {
        String opcoes = """
                                
                                
                Operações
                                
                1- Consultar saldos
                2- Receber valor
                3- Transferir valor
                4- Sair
                """;
        return opcoes;
    }
}
