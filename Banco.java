import java.util.ArrayList;
import java.util.Scanner;
class Banco{

    private int numConta;
    private int contasCriadas;
    private int idDeAcao;
    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    @Override
    public String toString() {
        return "{" +
            " numConta='" + getNumConta() + "'" + "}";
    }

    public int getContasCriadas() {
        return this.contasCriadas;
    }

    public void setContasCriadas(int contasCriadas) {
        this.contasCriadas = contasCriadas;
    }

    public int getNumConta() {
        return this.numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public int getIdDeAcao() {
        return this.idDeAcao;
    }

    public void setIdDeAcao(int idDeAcao) {
        this.idDeAcao = idDeAcao;
    }

    public void deposito(int idCli, double dep){
        clientes.get(idCli).receberDeposito(dep);
    }

    public void transferir(int idCliRemetente, int idCliDestinatario, double trans){
        if(clientes.get(idCliRemetente).getSaldo() >= trans){
            clientes.get(idCliDestinatario).receberDeposito(trans);
            clientes.get(idCliRemetente).removerSaldo(trans);
            //return;
        }else
            System.out.println("Remetente sem saldo suficiente.");
    }
    
    public  void sacar(int idCli, double sac) {
        if(sac <= clientes.get(idCli).getSaldo())
            clientes.get(idCli).removerSaldo(sac);
        else
            System.out.println("Sem saldo!!!");
    }

    public void addCliente(Cliente cl){
        clientes.add(cl);
    }

    public void showCliente(){
        for(int i =0; i< clientes.size(); i++)
            System.out.println(clientes.get(i).toString());
    }

    public static void main(String[] args) {
        Banco bc = new Banco();
        Scanner sc = new Scanner(System.in);
        while(true){
            String comando = sc.nextLine();
            String[] partes = comando.split(" ");
            System.out.println("$"+ comando);

            if(partes[0].equals("sac")){
                bc.sacar(Integer.parseInt(partes[1]), Double.parseDouble(partes[2]));
            }else if(partes[0].equals("addCli")){
                bc.addCliente(new Cliente (partes[1],Integer.parseInt(partes[2]), Integer.parseInt(partes[3])));
            }else if(partes[0].equals("show")){
                bc.showCliente();
            }else if(partes[0].equals("transf")){
                bc.transferir(Integer.parseInt(partes[1]), Integer.parseInt(partes[2]), Double.parseDouble(partes[3]));
            }else if(partes[0].equals("dep")){
                bc.deposito(Integer.parseInt(partes[1]), Double.parseDouble(partes[2]));
            }else{
                System.out.println("comando INVALIDO!!!");
            }
        }
    }
}