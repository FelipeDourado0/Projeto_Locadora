package locadora_onze;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Carro {

    private String marca;
    private String modelo;
    private String cor;
    private int ano;
    private double quilometragem;
    private String placa;
    private double valorDiaria;
    private int idCarro;
    boolean disponibilidade;
    private int disponivel;// vai configurar a disponibilidade booleana

    //Início construct de Carro
    public Carro(String marca, String modelo, String cor, int ano, float quilometragem, String placa, float valorDiaria, boolean disponibilidade) {
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.ano = ano;
        this.quilometragem = quilometragem;
        this.placa = placa;
        this.valorDiaria = valorDiaria;
        this.disponibilidade = disponibilidade;
    }
    //Fim construct de Carro   

    Carro() {
        
    }

    //Inicio encapsulamento atributos de Carro
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(float quilometragem) {
        this.quilometragem = quilometragem;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(float valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public int getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(int disponivel) {
        this.disponivel = disponivel;
    }

    public int getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(int idCarro) {
        this.idCarro = idCarro;
    }

    //Fim encapsulamento atributos de Carro 
    //Método lista de Carros
    /**
     *
     */
    public void cadastrarCarros(Loja loja) {
        Scanner teclado = new Scanner(System.in);
        teclado.useLocale(Locale.ENGLISH);
        Random rand = new Random();
        System.out.println("Insira os dados do Carro");

        this.idCarro = rand.nextInt(999999) + 1;
        Random random = new Random();
        int op = 1;
        do {
            this.idCarro = rand.nextInt(999999) + 1;
            if (loja.listaCarros.isEmpty() == false) {
                for (int i = 0; i < loja.listaCarros.size(); i++) {
                    if (idCarro == loja.listaCarros.get(i).idCarro) {
                        op = 0;
                    } else if (op !=0){
                        op = 1;
                    }
                }
            } else {
                op = 1;
            }
        }while(op !=1);
        
        System.out.println("Marca: ");
        this.marca = teclado.nextLine();

        System.out.println("Modelo: ");
        this.modelo = teclado.nextLine();

        System.out.println("Cor: ");
        this.cor = teclado.nextLine();

        System.out.println("Ano: ");
        this.ano = teclado.nextInt();

        System.out.println("Quilometragem: ");
        this.quilometragem = teclado.nextDouble();
        clearBuffer(teclado);

        System.out.println("Placa: ");
        this.placa = teclado.nextLine();

        System.out.println("ValorDiaria: ");
        this.valorDiaria = teclado.nextDouble();

        System.out.println("Disponivel? 1 - sim ou 2 - nao ");
        do {
            this.disponivel = teclado.nextInt();
            if (disponivel > 2 || disponivel < 1) {
                System.out.println("Digite 1 - para sim ou 2 - para nao");
            } else if (disponivel == 1) {
                this.disponibilidade = true;
            } else {
                this.disponibilidade = false;
            }

        } while (disponivel > 2 || disponivel < 1);

    }

    //metodo para limpeza de buffer
    private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
}
