import java.util.Scanner;

public class Programa {
    static void main() {
        Scanner ler = new Scanner(System.in);

        Banco[] contas = new Banco[10];

        int opcao, totContas = 0;
        Banco usuarioLogado = null;

        String menu = """
                1- Criar conta
                2- Login
                3- Depositar
                4- Sacar
                5- Transferir valor
                6- Mostrar as informações da sua conta
                7- Sair
                """;

        do {
            System.out.println(menu);
            System.out.println("Qual opção você deseja realizar? (1-7): ");
            opcao = ler.nextInt();

            switch (opcao){
                case 1:

                    System.out.println("=============\nCRIANDO CONTA\n=============");

                    ler.nextLine();

                    if (totContas < contas.length) {
                        System.out.println("Diga o nome completo do titular: ");
                        String nome = ler.nextLine();

                        System.out.println("Diga uma senha para sua conta: ");
                        String senha = ler.nextLine();

                        System.out.println("Confirme a senha: ");
                        String confirmarSenha = ler.nextLine();

                        while (!confirmarSenha.equals(senha)){
                            System.out.println("Erro! Senhas não coincidem!\n");
                            System.out.println("Confirme a senha novamente: ");
                            confirmarSenha = ler.nextLine();
                        }

                        System.out.println("1- CPF\n2- EMAIL\n3- TELEFONE\n4- RG\nQual das opções você quer para sua chave: ");
                        int tipoChave = ler.nextInt();
                        ler.nextLine();

                        String minhaChave = "";

                        switch (tipoChave) {

                            case 1:

                                while (!minhaChave.matches("\\d{11}")) {
                                    System.out.print("Digite seu CPF: ");
                                    minhaChave = ler.nextLine();
                                }

                                break;

                            case 2:

                                while (!minhaChave.contains("@")) {
                                    System.out.println("Digite seu email: ");
                                    minhaChave = ler.nextLine();
                                }

                                break;

                            case 3:
                                while (!minhaChave.matches("\\d{10,11}")) {
                                    System.out.println("Digite seu telefone: ");
                                    minhaChave = ler.nextLine();
                                }

                                break;

                            case 4:

                                while (!minhaChave.matches("\\d{9}")) {
                                    System.out.println("Digite seu rg: ");
                                    minhaChave = ler.nextLine();
                                }

                                break;

                            default:
                                System.out.println("Tipo inválido!");
                        }

                        System.out.println("Confirme a chave: ");
                        String confirmarChave = ler.nextLine();

                        while (!confirmarChave.equals(minhaChave)){
                            System.out.println("Erro! Chaves não coincidem!\n");
                            System.out.println("Confirme a chave novamente: ");
                            confirmarChave = ler.nextLine();
                        }

                        contas[totContas] = new Banco(nome, senha, minhaChave);

                        System.out.println("Conta criada com sucesso!\n ");
                        System.out.println("Número da conta: " + contas[totContas].getConta());

                        totContas++;

                    }else
                        System.out.println("Limite de contas atingido! ");

                    break;

                case 2:

                    ler.nextLine();

                    System.out.println("Diga o nº da conta (ex: 1000-0): ");
                    String numConta = ler.nextLine();

                    int indiceLogin = buscarConta_por_NumConta(contas, numConta, totContas);

                    if (indiceLogin != -1){
                        int tentativas = 3;

                        while (tentativas > 0){
                            System.out.println("Diga a senha da sua conta: ");
                            String senha = ler.nextLine();

                            if (contas[indiceLogin].autenticar(senha)){
                                usuarioLogado = contas[indiceLogin];
                                System.out.println("Login realizado com sucesso!");
                                break;
                            }else {
                                tentativas--;
                                System.out.printf("Senha incorreta.\n Tentativas restantes: %d ", tentativas);
                            }
                        }
                        if (tentativas == 0)
                            System.out.println("Conta bloqueada temporariamente! ");
                    }else
                        System.out.println("Conta não encontrada! ");

                    break;

                case 3:

                    if (usuarioLogado != null){
                        System.out.print("Valor para depositar: ");
                        double valor = ler.nextDouble();

                        usuarioLogado.depositar(valor);
                    }else
                        System.out.println("Você precisa fazer o login primeiro! ");

                    break;

                case 4:

                    if (usuarioLogado != null) {
                        System.out.print("Valor para saque: ");
                        double valor = ler.nextDouble();

                        usuarioLogado.sacar(valor);
                    }else
                        System.out.println("Você precisa fazer o login primeiro! ");

                    break;

                case 5:

                    if (usuarioLogado != null) {
                        ler.nextLine();

                        System.out.print("Diga a chave da pessoa que você quer transferir: ");
                        String destino = ler.nextLine();

                        int indiceDestino = buscarConta_por_Chave(contas, destino, totContas);

                        if (indiceDestino != -1){
                            System.out.print("Valor: ");
                            double valor = ler.nextDouble();

                            usuarioLogado.transferir(contas[indiceDestino], valor);

                        }else
                            System.out.println("Conta de destino não encontrada! ");

                    }else
                        System.out.println("Você precisa fazer o login primeiro! ");

                    break;

                case 6:

                    if (usuarioLogado != null)
                        usuarioLogado.mostrarInformacaoConta();
                    else
                        System.out.println("Você precisa fazer o login primeiro! ");

                    break;

                case 7:

                    usuarioLogado = null;
                    System.out.println("Obrigado por acessar o nosso banco!\nFechando app...");

                    break;

                default:

                    System.out.println("Opção inválida!\nEscolha entre (1-5)!!! ");
            }
        }while(opcao != 7);

        ler.close();
    }

    public static int buscarConta_por_NumConta(Banco[] contas, String numConta, int totalContas) {
        for (int i = 0; i < totalContas; i++) {
            if (contas[i].getConta().equals(numConta)) {
                return i;
            }
        }
        return -1;
    }

    public static int buscarConta_por_Chave(Banco[] contas, String chave, int totalContas) {
        for (int i = 0; i < totalContas; i++) {
            if (contas[i].getChave().equals(chave)) {
                return i;
            }
        }
        return -1;
    }

}
