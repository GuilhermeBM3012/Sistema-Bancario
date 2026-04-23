public class Banco {
    static int contadorConta = 1000;
    static int contadorAgencia = 1;

    private String nomeTitular;
    private int numeroContaBancaria;
    private double saldoConta;
    private int agencia;
    private int digito;
    private String senha;
    private String chave;


    public String getConta(){
        return numeroContaBancaria + "-" + digito;
    }

    public double getSaldoConta() {
        return saldoConta;
    }

    public String getChave(){
        return chave;
    }


    public Banco(String nomeTitular, String senha, String chave){
        this.nomeTitular = nomeTitular;
        this.senha = senha;
        this.numeroContaBancaria = contadorConta++;
        this.saldoConta = 0;
        this.agencia = contadorAgencia++;
        this.digito = calcularDigito(numeroContaBancaria);
        this.chave = chave;
    }


    public boolean autenticar(String senhaDigitada){
        return this.senha.equals(senhaDigitada);
    }


    private int calcularDigito(int numero) {
        return numero % 10;
    }


    public void depositar(double valor) {
        if (valor > 0) {
            saldoConta += valor;
            System.out.println("Depósito realizado! ");

        }else
            System.out.println("Valor inválido! ");
    }


    public boolean sacar(double valor){
        if (valor > getSaldoConta()) {
            System.out.println("Não foi possível fazer a retirada\nSaldo insuficiente! ");
            return false;

        }if (valor <= 0){
            System.out.println("Valor insuficiente! ");;
            return false;
        }

        saldoConta -= valor;
        System.out.println("Saque realizado! ");
        return true;
    }


    public void receberTransferencia(double valor) {
        this.saldoConta += valor;
    }

    public boolean transferir(Banco destino, double valor) {
        if (valor <= 0 || valor > 5000) {
            System.out.println("Valor inválido!");
            return false;

        }if(valor > getSaldoConta()) {
            System.out.println("Saldo insuficiente!");
            return false;

        }if (this == destino) {
            System.out.println("Não pode transferir para si mesmo");
            return false;
        }


        this.saldoConta -= valor;
        destino.receberTransferencia(valor);

        System.out.println("Transferência realizada com sucesso!");
        return true;
    }


    public void mostrarInformacaoConta(){
        System.out.printf("Titular: %s\nAgência: %d\nConta: %s\nChave: %s\nSaldo: %.2f", nomeTitular, agencia, getConta(), getChave(), getSaldoConta());
    }
}
