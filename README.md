# Banco
- O Banco
- Lucas ajudou, precisei de ajuda para relembrar de uma boa parte;
- Levei mais de 2 horas para conluir tudo.
- Usei arrayList.
  
  ---
- Banco.java
  - public void deposito(int idCli, double dep){  
        clientes.get(idCli).receberDeposito(dep);
    } 
    - Função que realiza o depósito na conta do cliente, idCli é o número da conta, dep é o valor do depósito.
  - public void transferir(int idCliRemetente, int idCliDestinatario, double trans){
        if(clientes.get(idCliRemetente).getSaldo() >= trans){
            clientes.get(idCliDestinatario).receberDeposito(trans);
            clientes.get(idCliRemetente).removerSaldo(trans);
        }else
            System.out.println("Remetente sem saldo suficiente.");
    } 
       - Função que realiza a transferência entre duas contas, idCliRemetente é o número da conta de quem vai realizar o depósito, idCliDestinatario é o número da conta de quem vai receber o dinheiro, trans é o valor que vai ser transferido,  nessa função era necessário ter um controle de decisão, o idCliRemetente não tivesse o saldo, com isso teria um aviso "Remetente sem saldo suficiente".

  - public  void sacar(int idCli, double sac) {
        if(sac <= clientes.get(idCli).getSaldo())
            clientes.get(idCli).removerSaldo(sac);
    }else
            System.out.println("Sem saldo!!!");

    - Função que realiza o saque da conta, o usuário entra com o número da conta, com o valor do saque, como o saldo é do cliente e não do Banco, na classe Cliente tem uma função que remove o saldo, mas antes tem a verificação se tem saldo, se não tiver, avisa "Sem saldo!!!".

   - public void addCliente(Cliente cl){
        clientes.add(cl);
    }
      - Função que adiciona clientes.
  -  public void showCliente(){
        for(int i =0; i< clientes.size(); i++)
            System.out.println(clientes.get(i).toString());
    }
       - Função que mostra todos os usuários. 

- Cliente.java

  - public void receberDeposito(double dep){
        saldo += dep;
    }
     - Função que recebe o depósito e coloca no saldo.
 - public void removerSaldo(double money){
        saldo -= money;
    }
  - Função que remove o saldo.
- Como saldo é um atributo do cliente, por isso achei necessário fazer essas funções na classe Cliente.   
