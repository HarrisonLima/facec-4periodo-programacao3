import java.util.Random;

public abstract class Conta {
    private int agencia, conta;
    private String senha, tipoConta;

    public Conta(){
        super();
    }

    public int getAgencia() {
        return 123;
    }

    public int getConta() {
        return conta;
    }

    public String getSenha() {
        return senha;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public int NumeroConta(){
        setConta(0);
        while (getConta() < 100000) {
            Random random = new Random();
            setConta(random.nextInt(999999));
            return getConta();
        }
        return 0;
    }
}
