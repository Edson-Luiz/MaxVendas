import javax.sound.midi.SysexMessage;
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Main extends JFrame {
    public static void main(String[] args){

        //TEXTO DE APRESENTAÇÃO
        System.out.println("\nApresentamos a você um novo programa que irá ajudá-lo a decidir qual produto é mais vantajoso para se vender: o Comparador de Produtos.\n" +
                "Com o Comparador de Produtos, você pode facilmente comparar a quantidade e o preço de dois produtos diferentes, permitindo que você tome uma decisão informada sobre qual produto é mais vantajoso para se vender.\n" +
                "Este programa é especialmente útil para pessoas que trabalham com vendas, de forma ambulante.\n" +
                "O Comparador de Produtos é fácil de usar, basta escolher a opção com ou sem investimento inicial e inserir os dados dos produtos que deseja comparar, como a quantidade e o preço de\n cada um, e o programa irá calcular e mostrar qual dos produtos é mais vantajoso para se vender.\n" +
                "Com o Comparador de Produtos, você pode tomar decisões mais informadas e maximizar seus lucros. Experimente agora e descubra qual produto é o melhor para se vender!");


        //DECLARAÇÃO DAS VÁRIAVEIS
        Scanner sc = new Scanner(System.in);

        Produto p1 = new Produto();
        Produto p2 = new Produto();

        int tempo = 0, num = 0;
        double lucroA = 0, lucroB = 0, porcentB = 0, porcentA = 0, investInicial = 0, lucroAnualA = 0, lucroAnualB = 0;

        //INICIO DO MENU
        System.out.println("");
        System.out.print("|----------------------MENU----------------------|\n");
        System.out.print("| Opção 1 - Comparar com investimento incial     |\n");
        System.out.print("| Opção 2 - Comparar sem investimento inicial    |\n");
        System.out.print("| Opção 3 - Sair                                 |\n");
        System.out.print("|------------------------------------------------|\n");
        System.out.print("Digite uma opção: ");
        num = sc.nextInt();

        //INICIO DO SWITCH-CASE
        switch (num) {

            //CASO 1 QUANDO A COMPARAÇÃO É COM INVESTIMENTO INICIAL
            case 1:
                try {

                    //SOLICITANDO O INVESTIMENTO INICIAL AO USUÁRIO
                    System.out.println("\nQual será o seu investimento inicial ?");
                    investInicial = sc.nextDouble();

                    //SOLICITANDO AS INFORMAÇÕES DO PRODUTO AO USUÁRIO
                    System.out.println("\nPRODUTO 1");
                    System.out.println("\nDigite a quantidade do produto 1: ");
                    p1.setQtde(sc.nextInt());
                    if (p1.getQtde() <= 0) {
                        throw new QuantidadeException(p1.getQtde());
                    }

                    p1.setPreco_compra(investInicial / p1.getQtde());
                    if (p1.getPreco_compra() < 0) {
                        throw new NumerosNegativos(p1.getPreco_compra());
                    }
                    if ((p1.getQtde() * p1.getPreco_compra()) > investInicial) {
                        System.out.println("AVISO: O valor pago ultrapassou do investimento inicial");
                    }

                    System.out.println("O valor unitário do produto é: " + p1.getPreco_compra() + " R$");
                    System.out.println("\nDigite o preço de venda do produto 1 (un): ");
                    p1.setPreco_venda(sc.nextDouble());
                    if (p1.getPreco_venda() < 0) {
                        throw new NumerosNegativos(p1.getPreco_venda());
                    }

                //TRATAMENTO DE EXCEÇÕES
                } catch (QuantidadeException e) {
                    System.out.println("ERRO: A quantidade DEVE ser maior que zero!");
                } catch (NumerosNegativos e){
                    System.out.println("ERRO: O valor inserido DEVE ser positivo!");

                }

                lucroA = (p1.getQtde() * p1.getPreco_venda()) - (p1.getQtde() * p1.getPreco_compra());
                porcentA = (lucroA * 100) / (p1.getQtde() * p1.getPreco_compra());

                try {

                    //SOLICITANDO AS INFORMAÇÕES DO PRODUTO AO USUÁRIO
                    System.out.println("\nPRODUTO 2");
                    System.out.println("\nDigite a quantidade do produto 2: ");
                    p2.setQtde(sc.nextInt());
                    if (p2.getQtde() <= 0) {
                        throw new QuantidadeException(p1.getQtde());
                    }

                    p2.setPreco_compra(investInicial / p2.getQtde());
                    if (p2.getPreco_compra() < 0) {
                        throw new NumerosNegativos(p2.getPreco_compra());
                    }
                    if ((p2.getQtde() * p2.getPreco_compra()) > investInicial) {
                        System.out.println("AVISO: O valor pago ultrapassou do investimento inicial");
                    }

                    System.out.println("O valor unitário do produto é: " + p2.getPreco_compra() + " R$");
                    System.out.println("\nDigite o preço de venda do produto 2 (un): ");
                    p2.setPreco_venda(sc.nextDouble());
                    if (p2.getPreco_venda() < 0) {
                        throw new NumerosNegativos(p2.getPreco_venda());
                    }

                //TRATAMENTO DE EXCEÇÕES
                } catch (QuantidadeException e) {
                    System.out.println("ERRO: A quantidade DEVE ser maior que zero!");
                } catch (NumerosNegativos e){
                    System.out.println("ERRO: O valor inserido DEVE ser positivo!");

                }

                System.out.println("\nEm quantos dias você pretende vender estes produtos ?");
                tempo = sc.nextInt();

                //CÁLCULOS
                lucroB = (p2.getQtde() * p2.getPreco_venda()) - (p2.getQtde() * p2.getPreco_compra());
                porcentB = (lucroB * 100) / (p2.getQtde() * p2.getPreco_compra());

                lucroAnualA = (365 / tempo) * lucroA;
                lucroAnualB = (365 / tempo) * lucroB;

                //IMPRIMINDO O RELATÓRIO AO USUÁRIO
                System.out.print("|--------------------------------------------------------------RELATÓRIO P1---------------------------------------------------------------|\n");
                System.out.print("| Quantidade: " + p1.getQtde() + " unidades\n");
                System.out.print("| Valor de compra: " + p1.getPreco_compra() + " R$\n");
                System.out.print("| Valor de venda: " + p1.getPreco_venda() + " R$\n");
                System.out.print("| Lucro bruto: " + lucroA + " R$\n");
                System.out.print("| Porcentagem de lucro: " + porcentA + "%\n");
                System.out.print("| Se você vender esta quantidade de produto a cada " + tempo + " dias em um ano você irá ter um lucro anual de " + lucroAnualA + " R$\n");
                System.out.print("|-----------------------------------------------------------------------------------------------------------------------------------------|\n");
                System.out.println("");
                System.out.print("|--------------------------------------------------------------RELATÓRIO P2---------------------------------------------------------------|\n");
                System.out.print("| Quantidade: " + p2.getQtde() + " unidades\n");
                System.out.print("| Valor de compra: " + p2.getPreco_compra() + " R$\n");
                System.out.print("| Valor de venda: " + p2.getPreco_venda() + " R$\n");
                System.out.print("| Lucro bruto: " + lucroB + " R$\n");
                System.out.print("| Porcentagem de lucro: " + porcentB + "%\n");
                System.out.print("| Se você vender esta quantidade de produto a cada " + tempo + " dias em um ano você irá ter um lucro anual de " + lucroAnualB + " R$\n");
                System.out.print("|-----------------------------------------------------------------------------------------------------------------------------------------|\n");


                if (porcentA > porcentB) {
                    System.out.print("\nA porcentagem de lucro do P1 é melhor para você");
                    if (lucroA < lucroB) {
                        System.out.print(", mas o lucro bruto de P2 é melhor para você.");

                    } else {
                        System.out.print(", e o lucro bruto também.");
                    }

                } else if (porcentB > porcentA) {
                    System.out.print("\nA porcentagem de lucro P2 é melhor para você");
                    if (lucroA > lucroB) {
                        System.out.print(", mas o lucro bruto de P1 é melhor para você.");

                    } else {
                        System.out.print(", e o lucro bruto também.");
                    }
                } else {
                    System.out.println("\nO lucro de P1 e P2 são iguais");
                }

                new GraficoBarra(lucroA, lucroB);

                break;

            //CASO 2 QUANDO A COMPARAÇÃO É SEM INVESTIMENTO INICIAL
            case 2:

                try {

                    //SOLICITANDO AS INFORMAÇÕES DO PRODUTO AO USUÁRIO
                    System.out.println("\nPRODUTO 1");
                    System.out.println("\nDigite a quantidade do produto 1: ");
                    p1.setQtde(sc.nextInt());
                    if (p1.getQtde() <= 0) {
                        throw new QuantidadeException(p1.getQtde());
                    }

                    System.out.println("\nDigite o preço de compra produto 1 (un): ");
                    p1.setPreco_compra(sc.nextDouble());
                    if (p1.getPreco_compra() < 0) {
                        throw new NumerosNegativos(p1.getPreco_compra());
                    }

                    System.out.println("\nDigite o preço de venda do produto 1 (un): ");
                    p1.setPreco_venda(sc.nextDouble());
                    if (p1.getPreco_venda() < 0) {
                        throw new NumerosNegativos(p1.getPreco_venda());
                    }
                //TRATAMENTO DE EXCEÇÕES
                } catch (QuantidadeException e) {
                    System.out.println("ERRO: A quantidade DEVE ser maior que zero!");
                } catch (NumerosNegativos e){
                    System.out.println("ERRO: O valor inserido DEVE ser positivo!");

                }

                lucroA = (p1.getQtde() * p1.getPreco_venda()) - (p1.getQtde() * p1.getPreco_compra());
                porcentA = (lucroA * 100) / (p1.getQtde() * p1.getPreco_compra());

                try {

                    //SOLICITANDO AS INFORMAÇÕES DO PRODUTO AO USUÁRIO
                    System.out.println("\nPRODUTO 2");
                    System.out.println("\nDigite a quantidade do produto 2: ");
                    p2.setQtde(sc.nextInt());
                    if (p2.getQtde() <= 0) {
                        throw new QuantidadeException(p1.getQtde());
                    }

                    System.out.println("\nDigite o preço de compra produto 2 (un): ");
                    p2.setPreco_compra(sc.nextDouble());
                    if (p2.getPreco_compra() < 0) {
                        throw new NumerosNegativos(p2.getPreco_compra());
                    }

                    System.out.println("\nDigite o preço de venda do produto 2 (un): ");
                    p2.setPreco_venda(sc.nextDouble());
                    if (p2.getPreco_venda() < 0) {
                        throw new NumerosNegativos(p2.getPreco_venda());
                    }
                    //TRATAMENTO DE EXCEÇÕES
                } catch (QuantidadeException e) {
                    System.out.println("ERRO: A quantidade DEVE ser maior que zero!");
                } catch (NumerosNegativos e){
                    System.out.println("ERRO: O valor inserido DEVE ser positivo!");

                }

                System.out.println("\nEm quantos dias você pretende vender estes produtos ?");
                tempo = sc.nextInt();

                //CALCULOS
                lucroB = (p2.getQtde() * p2.getPreco_venda()) - (p2.getQtde() * p2.getPreco_compra());
                porcentB = (lucroB * 100) / (p2.getQtde() * p2.getPreco_compra());

                lucroAnualA = (365 / tempo) * lucroA;
                lucroAnualB = (365 / tempo) * lucroB;

                //IMPRIMINDO RELATÓRIO AO USUÁRIO
                System.out.print("|--------------------------------------------------------------RELATÓRIO P1---------------------------------------------------------------|\n");
                System.out.print("| Quantidade: " + p1.getQtde() + " unidades\n");
                System.out.print("| Valor de compra: " + p1.getPreco_compra() + " R$\n");
                System.out.print("| Valor de venda: " + p1.getPreco_venda() + " R$\n");
                System.out.print("| Lucro bruto: " + lucroA + " R$\n");
                System.out.print("| Porcentagem de lucro: " + porcentA + "%\n");
                System.out.print("| Se você vender esta quantidade de produto a cada " + tempo + " dias em um ano você irá ter um lucro anual de " + lucroAnualA + " R$\n");
                System.out.print("|-----------------------------------------------------------------------------------------------------------------------------------------|\n");
                System.out.println("");
                System.out.print("|--------------------------------------------------------------RELATÓRIO P2---------------------------------------------------------------|\n");
                System.out.print("| Quantidade: " + p2.getQtde() + " unidades\n");
                System.out.print("| Valor de compra: " + p2.getPreco_compra() + " R$\n");
                System.out.print("| Valor de venda: " + p2.getPreco_venda() + " R$\n");
                System.out.print("| Lucro bruto: " + lucroB + " R$\n");
                System.out.print("| Porcentagem de lucro: " + porcentB + "%\n");
                System.out.print("| Se você vender esta quantidade de produto a cada " + tempo + " dias em um ano você irá ter um lucro anual de " + lucroAnualB + " R$\n");
                System.out.print("|-----------------------------------------------------------------------------------------------------------------------------------------|\n");


                if (porcentA > porcentB) {
                    System.out.print("\nA porcentagem de lucro do P1 é melhor para você");
                    if (lucroA < lucroB) {
                        System.out.print(", mas o lucro bruto de P2 é melhor para você.");

                    } else {
                        System.out.print(", e o lucro bruto também.");
                    }

                } else if (porcentB > porcentA) {
                    System.out.print("\nA porcentagem de lucro P2 é melhor para você");
                    if (lucroA > lucroB) {
                        System.out.print(", mas o lucro bruto de P1 é melhor para você.");

                    } else {
                        System.out.print(", e o lucro bruto também.");
                    }
                } else {
                    System.out.println("\nO lucro de P1 e P2 são iguais");
                }

                new GraficoBarra(lucroA, lucroB);
                break;

            case 3:
                break;

            default:

                System.out.println("Opção inválida!");
                break;

        }

    }

}
