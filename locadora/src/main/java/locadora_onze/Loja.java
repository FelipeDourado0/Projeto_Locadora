package locadora_onze;

import java.util.ArrayList;
import java.util.Scanner;

public class Loja extends Pedido {

    //Lista de clientes da loja
    ArrayList<Cliente> listaClientes = new ArrayList();
    //lista de carros cadastrados
    ArrayList<Carro> listaCarros = new ArrayList();
    //lista de pedidos feitos
    ArrayList<Pedido> listaPedidos = new ArrayList();
//Construtor padrao

    public Loja() {

    }

//Inicio encapsulamento atributos do Loja
    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public ArrayList<Carro> getListaCarros() {
        return listaCarros;
    }

    public void setListaCarros(ArrayList<Carro> listaCarros) {
        this.listaCarros = listaCarros;
    }

    public ArrayList<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(ArrayList<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    public ArrayList<Cliente> getClientes() {
        return listaClientes;
    }

    // exibir carros cadastrados
    public void exibirCarros() {

        for (int i = 0; i < listaCarros.size(); i++) {
            System.out.println("Id carro         : id:" + listaCarros.get(i).getIdCarro());
            System.out.println("Marca            :" + listaCarros.get(i).getMarca());
            System.out.println("Modelo           :" + listaCarros.get(i).getModelo());
            System.out.println("Cor              :" + listaCarros.get(i).getCor());
            System.out.println("Ano              :" + listaCarros.get(i).getAno());
            System.out.println("Quilometragem    :" + listaCarros.get(i).getQuilometragem() + " quilometros rodados");
            System.out.println("Placa            :" + listaCarros.get(i).getPlaca());
            System.out.println("Valor diario     : R$ " + listaCarros.get(i).getValorDiaria() + " reais");
            if (listaCarros.get(i).isDisponibilidade() == true) {
                System.out.println("Disponibilidade  : Disponivel");
            } else {
                System.out.println("Disponibilidade  : Indisponivel");
            }
            System.out.println("");
        }
    }

    public void exibirClientes() {
        for (int i = 0; i < listaClientes.size(); i++) {
            System.out.println("Id Cliente   : id:" + listaClientes.get(i).getIdCliente());
            System.out.println("Nome         :" + listaClientes.get(i).getNomeCliente());
            System.out.println("Telefone     :" + listaClientes.get(i).getTelefoneCliente());
            System.out.println("+----------------------------------------------------------+");
        }

    }

    public void alterarDisponibilidadeCarros() {
        int idCar;
        int mudar;
        int sair = 0;
        Scanner teclado = new Scanner(System.in);
        do {
            System.out.println("Escolha o ID do carro que voce deseja alterar a disponibilidade");
            exibirCarros();
            idCar = teclado.nextInt();

            for (int i = 0; i < listaCarros.size(); i++) {
                if (idCar == listaCarros.get(i).getIdCarro()) {
                    if (listaCarros.get(i).isDisponibilidade() == true) {
                        System.out.println("Deseja mudar a disponibilidade do carro para ocupado?");
                        System.out.println("1 - Sim | 2 - Nao");
                        mudar = teclado.nextInt();
                        if (mudar == 1 || mudar == 2) {
                            listaCarros.get(i).setDisponibilidade(false);
                            sair = 1;
                        }
                    } else {
                        System.out.println("Deseja mudar a disponibilidade do carro para Disponivel?");
                        System.out.println("1 - Sim | 2 - Nao");
                        mudar = teclado.nextInt();
                        if (mudar == 1 || mudar == 2) {
                            listaCarros.get(i).setDisponibilidade(true);
                            sair = 1;
                        }
                    }
                } else {
                    System.out.println("ID do carro nao encontrado. Tente novamente.");
                }
            }
        } while (sair != 1);
    }
    
    public void exibirPedidos(){
        for(int i=0; i < listaPedidos.size();i++){
            System.out.println("----------- PEDIDOS ---------------");
            System.out.println("Numero do pedido       : " + listaPedidos.get(i).getIdPedido());
            System.out.println("Nome do cliente        : " + listaPedidos.get(i).getCliente().getNomeCliente());
            System.out.println("ID do Cliente          : " + listaPedidos.get(i).getCliente().getIdCliente());
            System.out.println("Nome do carro          : " + listaPedidos.get(i).getCarro().getModelo());
            System.out.println("ID do carro            : " + listaPedidos.get(i).getCarro().getIdCarro());
            System.out.println("Quantidade de dias     : " + listaPedidos.get(i).getQauntidadeDias());
            System.out.println("Diaria do carro        : " + listaPedidos.get(i).getCarro().getValorDiaria());
            System.out.println("Tipo de pagamento      : " + listaPedidos.get(i).getTipoPagamento());
            if(listaPedidos.get(i).getCartao() == true)
            System.out.println("Quantidade de parcelas : " + listaPedidos.get(i).getQtdeParcela());
            System.out.println("Valor Total            : " + listaPedidos.get(i).getValorTotal());
            System.out.println("+---------------------------------------------------+");
        }
    }
}
//Fim encapsulamento atributos do Loja   
