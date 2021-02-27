public class Cliente {
    
    private String nome;
    private int cpf;
    private int RG; 
    private double saldo;

    Cliente(String _nome, int _cpf, int _rg){
        this.nome = _nome;
        this.cpf = _cpf;
        this.RG = _rg;
    }


    public String getNome() {
        return this.nome;
    }

    public int getCpf() {
        return this.cpf;
    }

    public int getRG() {
        return this.RG;
    }

    public void receberDeposito(double dep){
        saldo += dep;
    }

    public void removerSaldo(double money){
        saldo -= money;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "{" +
            " nome='" + getNome() + "'" +
            ", cpf='" + getCpf() + "'" +
            ", RG='" + getRG() + "'" +
            ", saldo='" + getSaldo() + "'" +
            "}";
    }

}