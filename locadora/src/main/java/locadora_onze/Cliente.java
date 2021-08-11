package locadora_onze;

import java.util.Random;
import java.util.Scanner;

public class Cliente {

    private String nomeCliente;
    private String cpfCliente;
    private String telefoneCliente;
    private String enderecoCliente;
    private int idCliente;
    private Carro carro;

    //Início construct de Cliente
    public Cliente() {

    }

    public Cliente(String nomeCliente, String cpfCliente, String telefoneCliente, String enderecoCliente) {
        this.nomeCliente = nomeCliente;
        this.cpfCliente = cpfCliente;
        this.telefoneCliente = telefoneCliente;
        this.enderecoCliente = enderecoCliente;
    }
    //Fim construct de Cliente 

    //Inicio encapsulamento atributos do Cliente
    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    public String getEnderecoCliente() {
        return enderecoCliente;
    }

    public void setEnderecoCliente(String enderecoCliente) {
        this.enderecoCliente = enderecoCliente;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    //Fim encapsulamento atributos do Cliente

    //Leitura dados do CLiente
    public void cadastroCliente(Loja loja) {
        Scanner teclado = new Scanner(System.in);
        Random rand = new Random();
        int op = 1;
        do {
            this.idCliente = rand.nextInt(999999) + 1;
            if (loja.listaClientes.isEmpty() == false) {
                for (int i = 0; i < loja.listaClientes.size(); i++) {
                    if (idCliente == loja.listaClientes.get(i).idCliente) {
                        op = 0;
                    } else if (op != 0) {
                        op = 1;
                    }
                }
            } else {
                op = 1;
            }
        } while (op != 1);
        System.out.println("Nome: ");
        this.nomeCliente = teclado.nextLine();

        System.out.println("CPF: ");
        this.cpfCliente = teclado.nextLine();

        System.out.println("Telefone: ");
        this.telefoneCliente = teclado.nextLine();

        System.out.println("Endereco: ");
        this.enderecoCliente = teclado.nextLine();
    }
    //Fim leitura dados do Cliente
}
