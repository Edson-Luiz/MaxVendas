import javax.sound.midi.SysexMessage;
import java.util.Scanner;

public class Main extends Exception {
    public static void main(String[] args) {

        System.out.println("\nApresentamos a você um novo programa que irá ajudá-lo a decidir qual produto é mais vantajoso para se vender: o Comparador de Produtos.\n" +
                "Com o Comparador de Produtos, você pode facilmente comparar a quantidade e o preço de dois produtos diferentes, permitindo que você tome uma decisão informada sobre qual produto é mais vantajoso para se vender.\n" +
                "Este programa é especialmente útil para pessoas que trabalham com vendas, seja em uma loja física ou online.\nCom ele, você pode facilmente comparar produtos similares, como diferentes marcas de um mesmo produto ou diferentes tamanhos de embalagem, para determinar qual produto oferece a melhor relação custo-benefício.\n" +
                "O Comparador de Produtos é fácil de usar, basta inserir os dados dos produtos que deseja comparar, como a quantidade e o preço de cada um, e o programa irá calcular e mostrar qual dos produtos é mais vantajoso para se vender.\n" +
                "Além disso, o Comparador de Produtos oferece uma interface intuitiva e fácil de usar, o que o torna acessível a qualquer pessoa, independentemente do seu nível de experiência em tecnologia.\n" +
                "Com o Comparador de Produtos, você pode tomar decisões mais informadas e maximizar seus lucros. Experimente agora e descubra qual produto é o melhor para se vender!");


        Scanner sc = new Scanner(System.in);

        Produto p1 = new Produto();
        Produto p2 = new Produto();

        int tempo = 0, num = 0;
        double lucroA = 0, lucroB = 0, porcentB = 0, porcentA = 0, investInicial = 0, lucroAnualA = 0, lucroAnualB = 0;

//        System.out.println("\nOs preços devem ter valores positivos e a quantidade deve ser maior que zero!!\n");
//        System.out.println("\n=====================================================================================================================================================================================");
        System.out.println("\n=====MENU=====");
        System.out.println("1- COMPARAR COM INVESTIMENTO INICIAL");
        System.out.println("2- COMPARAR SEM INVESTIMENTO INICIAL");
        System.out.println("0- FINALIZAR");
        System.out.println("Escolha a opção desejada: ");
        num = sc.nextInt();

        switch (num) {

            case 1:
                try {

                    System.out.println("Qual será o seu investimento inicial ?");
                    investInicial = sc.nextDouble();

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


                } catch (QuantidadeException | NumerosNegativos e) {
                    System.out.println("Aconteceu um erro!");
                    e.printStackTrace();
                }

                lucroA = (p1.getQtde() * p1.getPreco_venda()) - (p1.getQtde() * p1.getPreco_compra());
                porcentA = (lucroA * 100) / (p1.getQtde() * p1.getPreco_compra());

                try {

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

                } catch (QuantidadeException | NumerosNegativos e) {
                    System.out.println("Aconteceu um erro!");
                    e.printStackTrace();
                }

                System.out.println("\nEm quantos dias você pretende vender estes produtos ?");
                tempo = sc.nextInt();

                lucroB = (p2.getQtde() * p2.getPreco_venda()) - (p2.getQtde() * p2.getPreco_compra());
                porcentB = (lucroB * 100) / (p2.getQtde() * p2.getPreco_compra());

                lucroAnualA = (365 / tempo) * lucroA;
                lucroAnualB = (365 / tempo) * lucroB;

                System.out.println("\n=====RELATÓRIO=====");

                System.out.println("Sobre o produto 1");
                System.out.println("Quantidade: " + p1.getQtde());
                System.out.println("Valor de compra: " + p1.getPreco_compra() + " R$");
                System.out.println("Valor de venda: " + p1.getPreco_venda() + " R$");
                System.out.println("Lucro bruto: " + lucroA + " R$");
                System.out.println("Porcentagem de lucro: " + porcentA + "%");
                System.out.println("Se você vender esta quantidade de produto a cada " + tempo + " dias em um ano você irá ter um lucro anual de " + lucroAnualA + " R$");

                System.out.println("\nSobre o produto 2");
                System.out.println("Quantidade: " + p2.getQtde());
                System.out.println("Valor de compra: " + p2.getPreco_compra() + " R$");
                System.out.println("Valor de venda: " + p2.getPreco_venda() + " R$");
                System.out.println("Lucro bruto: " + lucroB + " R$");
                System.out.println("Porcentagem de lucro: " + porcentB + "%");
                System.out.println("Se você vender esta quantidade de produto a cada " + tempo + " dias em um ano você irá ter um lucro anual de " + lucroAnualB + " R$");

                System.out.println("=================");


                if (porcentA > porcentB) {
                    System.out.print("\nA porcentagem de lucro do P1 é melhor para você");
                    if (lucroA < lucroB) {
                        System.out.print(", mas o lucro bruto de P2 é melhor para você.");

                    } else {
                        System.out.print(", e o lucro bruto também.");
                    }

                } else if (porcentB > porcentA) {
                    System.out.print("\nA porcentagem de lucro P2 é melhor para você!");
                    if (lucroA > lucroB) {
                        System.out.print(", mas o lucro bruto de P1 é melhor para você.");

                    } else {
                        System.out.print(", e o lucro bruto também.");
                    }
                } else {
                    System.out.println("\nO lucro de P1 e P2 são iguais");
                }

//                if (lucroA > lucroB) {
//                    double a = 0, b = 0, c = 0;
//                    a = porcentA / 100;
//                    b = 1 + a;
//                    c = p2.getPreco_venda() * b;
//                    System.out.println("\nPara o P2 ter o mesmo lucro de P1 o valor de venda precisa ser de " + c + " R$");
//                } else if (lucroB > lucroA) {
//                    double a = 0, b = 0, c = 0;
//                    a = porcentB / 100;
//                    b = 1 + a;
//                    c = p1.getPreco_venda() * b;
//                    System.out.println("Para o P1 ter o mesmo lucro de P2 o valor de venda precisa ser de " + c + " R$");
//
//                }

                break;

            case 2:

                try {

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

                } catch (QuantidadeException | NumerosNegativos e) {
                    System.out.println("Aconteceu um erro!");
                    e.printStackTrace();
                }

                lucroA = (p1.getQtde() * p1.getPreco_venda()) - (p1.getQtde() * p1.getPreco_compra());
                porcentA = (lucroA * 100) / (p1.getQtde() * p1.getPreco_compra());

                try {

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

                } catch (QuantidadeException | NumerosNegativos e) {
                    System.out.println("Aconteceu um erro!");
                    e.printStackTrace();
                }

                System.out.println("\nEm quantos dias você pretende vender estes produtos ?");
                tempo = sc.nextInt();

                lucroB = (p2.getQtde() * p2.getPreco_venda()) - (p2.getQtde() * p2.getPreco_compra());
                porcentB = (lucroB * 100) / (p2.getQtde() * p2.getPreco_compra());

                lucroAnualA = (365 / tempo) * lucroA;
                lucroAnualB = (365 / tempo) * lucroB;

                System.out.println("\n=====RELATÓRIO=====");

                System.out.println("Sobre o produto 1");
                System.out.println("Quantidade: " + p1.getQtde());
                System.out.println("Valor de compra: " + p1.getPreco_compra() + " R$");
                System.out.println("Valor de venda: " + p1.getPreco_venda() + " R$");
                System.out.println("Lucro bruto: " + lucroA + " R$");
                System.out.println("Porcentagem de lucro: " + porcentA + "%");
                System.out.println("Se você vender esta quantidade de produto a cada " + tempo + " dias em um ano você irá ter um lucro anual de " + lucroAnualA + " R$");

                System.out.println("\nSobre o produto 2");
                System.out.println("Quantidade: " + p2.getQtde());
                System.out.println("Valor de compra: " + p2.getPreco_compra() + " R$");
                System.out.println("Valor de venda: " + p2.getPreco_venda() + " R$");
                System.out.println("Lucro bruto: " + lucroB + " R$");
                System.out.println("Porcentagem de lucro: " + porcentB + "%");
                System.out.println("Se você vender esta quantidade de produto a cada " + tempo + " dias em um ano você irá ter um lucro anual de " + lucroAnualB + " R$");

                System.out.println("=================");


                if (porcentA > porcentB) {
                    System.out.print("\nA porcentagem de lucro do P1 é melhor para você");
                    if (lucroA < lucroB) {
                        System.out.print(", mas o lucro bruto de P2 é melhor para você.");

                    } else {
                        System.out.print(", e o lucro bruto também.");
                    }

                } else if (porcentB > porcentA) {
                    System.out.print("\nA porcentagem de lucro P2 é melhor para você!");
                    if (lucroA > lucroB) {
                        System.out.print(", mas o lucro bruto de P1 é melhor para você.");

                    } else {
                        System.out.print(", e o lucro bruto também.");
                    }
                } else {
                    System.out.println("\nO lucro de P1 e P2 são iguais");
                }

//                if (lucroA > lucroB) {
//                    double a = 0, b = 0, c = 0;
//                    a = porcentA / 100;
//                    b = 1 + a;
//                    c = p2.getPreco_venda() * b;
//                    System.out.println("\nPara o P2 ter o mesmo lucro de P1 o valor de venda precisa ser de " + c + " R$");
//                } else if (lucroB > lucroA) {
//                    double a = 0, b = 0, c = 0;
//                    a = porcentB / 100;
//                    b = 1 + a;
//                    c = p1.getPreco_venda() * b;
//                    System.out.println("Para o P1 ter o mesmo lucro de P2 o valor de venda precisa ser de " + c + " R$");
//
//                }
                break;

            case 0:
                break;

            default:

                System.out.println("Opção inválida!");
                break;

        }

    }

}
