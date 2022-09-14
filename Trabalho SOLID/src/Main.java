import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void ShowMenu(){
        System.out.println("Menu de opcoes");
        System.out.println("1 - Cadastrar cliente");
        System.out.println("2 - Criar Conta Corrente");
        System.out.println("3 - Criar Conta Poupanca");
        System.out.println("4 - Efetuar Deposito");
        System.out.println("5 - Efetuar Saque");
        System.out.println("6 - Efetuar Transferencia");
        System.out.println("7 - Sair");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //Variaveis locais
        int buscarCliente, buscarContaCorrente, buscarContaPoupanca, escolhaMenu;
        String confirmaSenha, numContaPoupanca, numContaCorrente;
        boolean sairLoop;

        //Hashtable
        Hashtable<Integer, String> clientes = new Hashtable<Integer, String>();
        Hashtable<Integer, String> contasCorrentes = new Hashtable<Integer, String>();
        Hashtable<Integer, String> contasPoupancas = new Hashtable<Integer, String>();

        //New
        Cliente clienteNovo = new Cliente();
        ContaCorrente contaCorrenteNova = new ContaCorrente();
        ContaPoupanca contaPoupancaNova = new ContaPoupanca();

        ShowMenu();

        System.out.print("Entre com a opcao desejada:");
        escolhaMenu = in.nextInt();
        boolean sair = false;
        int sairYesNo = 0;
        while (sair != true) {
            switch (escolhaMenu) {
                //Cadastrar cliente
                case 1:
                    System.out.print("Entre com o nome do cliente: ");
                    clienteNovo.setNome(in.next());

                    System.out.print("Entre com o cpf do cliente: ");
                    clienteNovo.setCpf(in.nextInt());

                    Integer cpfCliente = Integer.valueOf(clienteNovo.getCpf());

                    //clientes.put(clienteNovo.getNome(), cpfCliente);
                    clientes.put(cpfCliente, clienteNovo.getNome());

                    System.out.println("\n" + "CPF | Nome");

                    for (Map.Entry<Integer, String> listagemClientes : clientes.entrySet()) {

                        System.out.println(listagemClientes.getKey() + " | " + listagemClientes.getValue());
                        System.out.println("Cadastro realizado!!!");
                    }

                    //Outra pergunta
                    System.out.println("\nDeseja sair do programa?");
                    System.out.println("1 - Sim");
                    System.out.println("2 - Nao");
                    sairYesNo = in.nextInt();

                    if (sairYesNo == 1) {
                        System.out.println("Saindo do programa...");
                        sair = true;
                        break;
                    } else if (sairYesNo != 1 && sairYesNo != 2) {
                        System.out.println("Opcao invalida, saindo do programa...");
                    } else {
                        ShowMenu();

                        System.out.print("Entre com a opcao desejada:");
                        escolhaMenu = in.nextInt();
                    }
                    break;
                //Criar conta corrente
                case 2:
                    System.out.println("\nPara criar uma conta corrente, entre com o dado solicitado abaixo...");
                    System.out.print("Informe o numero do seu cpf para buscarmos seu cadastro: ");
                    buscarCliente = in.nextInt();

                    //buscar cliente
                    if (clientes.containsKey(buscarCliente)) {
                        System.out.println("CPF localizado!\n");

                        //verificar se o cliente possui conta poupança
                        buscarContaPoupanca = buscarCliente;
                        if (contasPoupancas.containsKey(buscarContaPoupanca)) {
                            contaCorrenteNova.setConta(contaPoupancaNova.getConta());
                            contaCorrenteNova.setAgencia(contaPoupancaNova.getAgencia());
                            contaCorrenteNova.setSenha(contaPoupancaNova.getSenha());
                            contaCorrenteNova.setTipoConta("Conta Corrente e Poupança");
                            contasCorrentes.put(buscarContaPoupanca, contasPoupancas.get(buscarContaPoupanca));

                            System.out.println("Notificacao: Verificamos que em seu CPF possui uma conta corrente cadastrada. Sendo assim, o tipo de sua conta passa a ser Conta corrente e poupanca!");
                            for (Map.Entry<Integer, String> listagemContasPoupancas : contasPoupancas.entrySet()) {
                                System.out.println("\n------------Conta alterada------------");
                                System.out.println("Responsavel da conta: " + clientes.get(buscarContaPoupanca));
                                System.out.println("Conta corrente: " + contaCorrenteNova.getConta());
                                System.out.println("Agencia: " + contaCorrenteNova.getAgencia());
                                System.out.println("Senha: " + contaCorrenteNova.getSenha());
                                System.out.println("Tipo de conta: " + contaCorrenteNova.getTipoConta());
                                System.out.println("------------------------------------");
                            }
                            //Outra pergunta
                            System.out.println("\nDeseja sair do programa?");
                            System.out.println("1 - Sim");
                            System.out.println("2 - Nao");
                            sairYesNo = in.nextInt();

                            if (sairYesNo == 1) {
                                System.out.println("Saindo do programa...");
                                sair = true;
                                break;
                            } else if (sairYesNo != 1 && sairYesNo != 2) {
                                System.out.println("Opcao invalida, saindo do programa...");
                            } else {
                                ShowMenu();

                                System.out.print("Entre com a opcao desejada:");
                                escolhaMenu = in.nextInt();
                            }
                            break;
                        } else {
                            System.out.println("Gerando conta...");
                            System.out.print("Crie uma senha para sua conta: ");
                            contaCorrenteNova.setSenha(in.next());
                            System.out.print("Digite sua senha para confirmarmos: ");
                            confirmaSenha = in.next();

                            sairLoop = false;
                            while (sairLoop == false) {
                                if (confirmaSenha.equalsIgnoreCase(contaCorrenteNova.getSenha())) {
                                    sairLoop = true;
                                } else {
                                    System.out.println("Senha inserida invalida!");
                                    System.out.print("Crie novamente sua senha: ");
                                    contaCorrenteNova.setSenha(in.next());
                                    System.out.print("Digite sua senha para confirmarmos: ");
                                    confirmaSenha = in.next();
                                }
                            }

                            contaCorrenteNova.setTipoConta("Conta Corrente");

                            for (Map.Entry<Integer, String> listagemContasCorrentes : contasCorrentes.entrySet()) {

                                contaCorrenteNova.NumeroConta();
                                clientes.get(buscarCliente);
                                numContaCorrente = String.valueOf(contaCorrenteNova.getConta());
                                contasCorrentes.put(buscarCliente, numContaCorrente);

                                System.out.println("\n------------Conta criada------------");
                                System.out.println("Responsavel da conta: " + clientes.get(buscarCliente));
                                System.out.println("Conta: " + contaCorrenteNova.getConta());
                                System.out.println("Agencia: " + contaCorrenteNova.getAgencia());
                                System.out.println("Senha: " + contaCorrenteNova.getSenha());
                                System.out.println("Tipo de conta: " + contaCorrenteNova.getTipoConta());
                                System.out.println("------------------------------------");
                            }
                            //Outra pergunta
                            System.out.println("\nDeseja sair do programa?");
                            System.out.println("1 - Sim");
                            System.out.println("2 - Nao");
                            sairYesNo = in.nextInt();

                            if (sairYesNo == 1) {
                                System.out.println("Saindo do programa...");
                                sair = true;
                                break;
                            } else if (sairYesNo != 1 && sairYesNo != 2) {
                                System.out.println("Opcao invalida, saindo do programa...");
                                break;
                            } else {
                                ShowMenu();
                                System.out.print("Entre com a opcao desejada:");
                                escolhaMenu = in.nextInt();
                            }
                            break;
                        }
                    } else {
                        System.err.println("CPF nao localizado!\n");
                        break;
                    }
                //Criar conta poupanca
                case 3:
                    System.out.println("\nPara criar uma conta poupanca, entre com o dado solicitado abaixo...");
                    System.out.print("Informe o numero do seu cpf para buscarmos seu cadastro: ");
                    buscarCliente = in.nextInt();

                    //buscar cliente
                    if (clientes.containsKey(buscarCliente)) {
                        System.out.println("CPF localizado!\n");

                        //verificar se o cliente possui conta corrente
                        if (contasCorrentes.containsKey(buscarCliente)) {
                            contaPoupancaNova.setConta(contaCorrenteNova.getConta());
                            contaPoupancaNova.setAgencia(contaCorrenteNova.getAgencia());
                            contaPoupancaNova.setSenha(contaCorrenteNova.getSenha());
                            contaPoupancaNova.setTipoConta("Conta Corrente e Poupança");
                            contasPoupancas.put(buscarCliente, contasCorrentes.get(buscarCliente));

                            System.out.println("Notificacao: Verificamos que em seu CPF possui uma conta corrente cadastrada. Sendo assim, o tipo de sua conta passa a ser Conta corrente e poupanca!");
                            for (Map.Entry<Integer, String> listagemContasPoupancas : contasPoupancas.entrySet()) {
                                System.out.println("\n------------Conta alterada------------");
                                System.out.println("Responsavel da conta: " + clientes.get(buscarCliente));
                                System.out.println("Conta corrente: " + contaPoupancaNova.getConta());
                                System.out.println("Agencia: " + contaPoupancaNova.getAgencia());
                                System.out.println("Senha: " + contaPoupancaNova.getSenha());
                                System.out.println("Tipo de conta: " + contaPoupancaNova.getTipoConta());
                                System.out.println("------------------------------------");
                            }
                            //Outra pergunta
                            System.out.println("\nDeseja sair do programa?");
                            System.out.println("1 - Sim");
                            System.out.println("2 - Nao");
                            sairYesNo = in.nextInt();

                            if (sairYesNo == 1) {
                                System.out.println("Saindo do programa...");
                                sair = true;
                                break;
                            } else if (sairYesNo != 1 && sairYesNo != 2) {
                                System.out.println("Opcao invalida, saindo do programa...");
                            } else {
                                ShowMenu();

                                System.out.print("Entre com a opcao desejada:");
                                escolhaMenu = in.nextInt();
                            }
                            break;
                        } else {

                            System.out.println("Gerando conta...");
                            System.out.print("Crie uma senha para sua conta: ");
                            contaPoupancaNova.setSenha(in.next());
                            System.out.print("Digite sua senha para confirmarmos: ");
                            confirmaSenha = in.next();

                            sairLoop = false;
                            while (sairLoop == false) {
                                if (confirmaSenha.equalsIgnoreCase(contaPoupancaNova.getSenha())) {
                                    sairLoop = true;
                                } else {
                                    System.out.println("Senha inserida invalida!");
                                    System.out.print("Crie novamente sua senha: ");
                                    contaPoupancaNova.setSenha(in.next());
                                    System.out.print("Digite sua senha para confirmarmos: ");
                                    confirmaSenha = in.next();
                                }
                            }

                            contaPoupancaNova.setTipoConta("Conta Poupança");

                            for (Map.Entry<Integer, String> listagemContasPoupancas : contasPoupancas.entrySet()) {

                                contaPoupancaNova.NumeroConta();
                                clientes.get(buscarCliente);
                                numContaPoupanca = String.valueOf(contaPoupancaNova.getConta());
                                contasPoupancas.put(buscarCliente, numContaPoupanca);

                                System.out.println("\n------------Conta criada------------");
                                System.out.println("Responsavel da conta: " + clientes.get(buscarCliente));
                                System.out.println("Conta: " + contaPoupancaNova.getConta());
                                System.out.println("Agencia: " + contaPoupancaNova.getAgencia());
                                System.out.println("Senha: " + contaPoupancaNova.getSenha());
                                System.out.println("Tipo de conta: " + contaPoupancaNova.getTipoConta());
                                System.out.println("------------------------------------");
                            }
                            //Outra pergunta
                            System.out.println("\nDeseja sair do programa?");
                            System.out.println("1 - Sim");
                            System.out.println("2 - Nao");
                            sairYesNo = in.nextInt();

                            if (sairYesNo == 1) {
                                System.out.println("Saindo do programa...");
                                sair = true;
                                break;
                            } else if (sairYesNo != 1 && sairYesNo != 2) {
                                System.out.println("Opcao invalida, saindo do programa...");
                            } else {
                                ShowMenu();
                                System.out.print("Entre com a opcao desejada:");
                                escolhaMenu = in.nextInt();
                            }
                            break;
                        }
                    } else {
                        System.err.println("CPF nao localizado!\n");
                        break;
                    }
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    System.out.println("Saindo...");
                    sair = true;
                    break;
                default:
                    System.out.println("Opcao escolhida invalida!");
                    System.out.println("Selecione novamente: ");
                    escolhaMenu = in.nextInt();
                    break;
            }
        }
    }
}
