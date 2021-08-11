package locadora_onze;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Loja loja = new Loja();
        int opcao;
        do {

            System.out.println("");
            System.out.println("+++++++++++++++Pagina Inicial+++++++++++++++");
            System.out.println("");
            System.out.println("Selecione uma opcao");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Exibir Clientes");
            System.out.println("3 - Cadastrar Carros");
            System.out.println("4 - Exibir Carros");
            System.out.println("5 - Alterar Disponibilidade do Carro");
            System.out.println("6 - Fazer Pedido");
            System.out.println("7 - Exibir Pedidos");
            System.out.println("8 - Sair");
            opcao = ler.nextInt();
            clearBuffer(ler);
            switch (opcao) {

                case 1:
                    Cliente cliente = new Cliente();
                    cliente.cadastroCliente(loja);
                    loja.listaClientes.add(cliente);
                    break;
                case 2:
                    if (loja.listaClientes.isEmpty() == false) {
                        loja.exibirClientes();
                    } else {
                        System.out.println("Nenhum Cliente cadastrado");
                    }
                    break;
                case 3:
                    Carro carros = new Carro();
                    carros.cadastrarCarros(loja);
                    loja.listaCarros.add(carros);
                    break;

                case 4:
                    if (loja.listaCarros.isEmpty() == false) {
                        loja.exibirCarros();
                    } else {
                        System.out.println("Nenhum carro cadastrado");
                    }
                    break;

                case 5:
                    if (loja.listaCarros.isEmpty() == false) {
                        loja.alterarDisponibilidadeCarros();
                    } else {
                        System.out.println("Nenhum carro cadastrado");
                    }
                    break;
                case 6:
                    if (loja.listaCarros.isEmpty() == false && loja.listaClientes.isEmpty() == false) {
                        Pedido pedido = new Pedido();
                        pedido.escolherCliente(loja);
                        pedido.escolherCarro(loja);
                        pedido.escolherDias();
                        pedido.valorTotal();
                        pedido.configurarIdPedido(loja);
                        pedido.formaPagamento();
                        loja.listaPedidos.add(pedido);
                    } else {
                        System.out.println("Nenhum carro ou cliente cadastrado");
                    }
                    break;
                case 7:
                    if (loja.listaPedidos.isEmpty() == false) {
                        loja.exibirPedidos();
                    } else {
                        System.out.println("Nenhum pedido encontrado!");
                    }
                    break;
                case 8:
                    break;
                    
                default:
                    System.out.println("Opcao inválida!");
            }
        } while (opcao != 8);
    }
        private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
}
