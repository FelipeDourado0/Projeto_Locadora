package locadora_onze;

import java.util.Random;
import java.util.Scanner;

public class Pedido extends Pagamento{

    private int idPedido;
    private int quantidadeDias;
    private float valorTotal;
    private int idCliente;
    private Cliente cliente;
    private Carro carro;
    private Pagamento pagamento;

    //Início construct de Pedido
    public Pedido() {

    }
    //Fim construct de Pedido

    //Início encapsulamento atributos de Pedido
    public int getQauntidadeDias() {
        return quantidadeDias;
    }
    public void setQauntidadeDias(int qauntidadeDias) {
        this.quantidadeDias = qauntidadeDias;
    }

    public float getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getIdPedido() {
        return idPedido;
    }
    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getQuantidadeDias() {
        return quantidadeDias;
    }
    public void setQuantidadeDias(int quantidadeDias) {
        this.quantidadeDias = quantidadeDias;
    }

    public int getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Carro getCarro() {
        return carro;
    }
    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    //Fim encapsulamento atributos de Carro
    public void escolherCliente(Loja loja) {
        Scanner sc = new Scanner(System.in);
        int confirm = 0;
        System.out.println("Escolha o cliente da lista a seguir: ");
        loja.exibirClientes();
        do {
            System.out.println("Digite o id do cliente: ");
            this.idCliente = sc.nextInt();
            clearBuffer(sc);
            for (int i = 0; i < loja.listaClientes.size(); i++) {
                if (idCliente == loja.listaClientes.get(i).getIdCliente()) {
                    confirm = 1;
                    this.cliente = loja.listaClientes.get(i);
                }
            }
            if (confirm != 1) {
                System.out.println("Cliente nao encontrado. Confirme o numero ou cadastre um novo cliente.");
            }
        } while (confirm != 1);
    }

    public void escolherDias() {
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite a quantidade de dias: ");
        this.quantidadeDias = ler.nextInt();
    }
 
    public void escolherCarro(Loja loja) {
        int idCarro;
        int confirm = -1;
        Scanner scs = new Scanner(System.in);
        System.out.println("Lista de carros: ");
        loja.exibirCarros();
        do {
            System.out.println("Escolha o carro digitando seu ID abaixo: ");
            idCarro = scs.nextInt();
            clearBuffer(scs);
            for (int i = 0; i < loja.listaCarros.size(); i++) {
                if (idCarro == loja.listaCarros.get(i).getIdCarro()) {
                    confirm = 1;
                    this.carro = loja.listaCarros.get(i);
                    this.carro.setDisponibilidade(false);
                }
            }
            if (confirm != 1) {
                System.out.println("Carro nao encontrado. Confirme o numero ou cadastre um novo carro.");
            }
        } while (confirm != 1);
    }

    public void valorTotal() {
        this.valorTotal = (float) (this.carro.getValorDiaria() * this.quantidadeDias);
    }

    public void realizaPedido(Loja loja) {
        escolherCliente(loja);
        escolherDias();
        escolherCarro(loja);
        valorTotal();
    }

    public void configurarIdPedido(Loja loja) {
        Random rand = new Random();
        int op = 1;
        do {
            this.idPedido = rand.nextInt(999999) + 1;
            if (loja.listaPedidos.isEmpty() == false) {
                for (int i = 0; i < loja.listaPedidos.size(); i++) {
                      if (idPedido == loja.listaPedidos.get(i).idPedido) {
                        op = 0;
                    } else if (op !=0){
                        op = 1;
                    }
                }
            } else {
                op = 1;
            }
        }while(op !=1);
    
    }
    
    public void pagamentosForma(){  
    }
    
    private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
    
}
