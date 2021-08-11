package locadora_onze;

import java.util.Scanner;

public abstract class Pagamento {

    private Boolean cartao = false;
    private String tipoPagamento;
    private Boolean dinheiro = false;
    private int qtdeParcela;

    //Início construct de Pagamento
    public Pagamento() {

    }
    //Fim construct de Pagamento

    //Início da seleção de forma de pagamento
    public void formaPagamento() {
        Scanner entrada = new Scanner(System.in);
        int escolha;
        do {
            System.out.println(" Escolha a forma de pagamento:");
            System.out.println("1 - Cartao");
            System.out.println("2 - Dinheiro");
            escolha = entrada.nextInt();
            clearBuffer(entrada);
            switch (escolha) {
                case 1:
                    this.cartao = true;
                    do {
                        System.out.println("Quantidade de parcelas: ");
                        System.out.println("1 - parcela: Debito");
                        System.out.println("2 a 5 - parcela: Credito");

                        this.qtdeParcela = entrada.nextInt();
                    } while (qtdeParcela <= 0 || qtdeParcela > 5);
                    if (qtdeParcela == 1) {
                        this.tipoPagamento = "Debito";
                    } else {
                        this.tipoPagamento = "Credito";
                    }
                    break;
                case 2:
                    this.dinheiro = true;
                    System.out.println("Pagamento no dinheiro confirmado!");
                    this.tipoPagamento = "Dinheiro";
                    break;
                default:
                    System.out.println("Opcao inválida!");
            }
        } while (escolha != 1 && escolha != 2);
    }

    //Fim seleção de forma de pagamento
    //Inicio encapsulamento atributos de Pagamento
    public Boolean getCartao() {
        return cartao;
    }

    public void setCartao(Boolean cartao) {
        this.cartao = cartao;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public Boolean getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(Boolean dinheiro) {
        this.dinheiro = dinheiro;
    }

    public int getQtdeParcela() {
        return qtdeParcela;
    }

    public void setQtdeParcela(int qtdeParcela) {
        this.qtdeParcela = qtdeParcela;
    }

    private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
}
