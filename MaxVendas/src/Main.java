import java.util.Scanner;

public class Main extends Exception {
    public static void main(String[] args){

        System.out.println("\nApresentamos a você um novo programa que irá ajudá-lo a decidir qual produto é mais vantajoso para se vender: o Comparador de Produtos.\n" +
                "Com o Comparador de Produtos, você pode facilmente comparar a quantidade e o preço de dois produtos diferentes, permitindo que você tome uma decisão informada sobre qual produto é mais vantajoso para se vender.\n" +
                "Este programa é especialmente útil para pessoas que trabalham com vendas, seja em uma loja física ou online.\nCom ele, você pode facilmente comparar produtos similares, como diferentes marcas de um mesmo produto ou diferentes tamanhos de embalagem, para determinar qual produto oferece a melhor relação custo-benefício.\n" +
                "O Comparador de Produtos é fácil de usar, basta inserir os dados dos produtos que deseja comparar, como a quantidade e o preço de cada um, e o programa irá calcular e mostrar qual dos produtos é mais vantajoso para se vender.\n" +
                "Além disso, o Comparador de Produtos oferece uma interface intuitiva e fácil de usar, o que o torna acessível a qualquer pessoa, independentemente do seu nível de experiência em tecnologia.\n" +
                "Com o Comparador de Produtos, você pode tomar decisões mais informadas e maximizar seus lucros. Experimente agora e descubra qual produto é o melhor para se vender!");



        Scanner sc = new Scanner(System.in);

        Produto p1 = new Produto();
        Produto p2 = new Produto();
        double lucroA = 0, lucroB = 0, porcentB = 0, porcentA = 0, roiA = 0, roiB = 0, investInicial = 0;
        System.out.println("\nOs preços devem ter valores positivos e a quantidade deve ser maior que zero!!\n");
        System.out.println("\n=====================================================================================================================================================================================");

        try {
            System.out.println("Qual será o seu investimento inicial ?");
            investInicial = sc.nextDouble();
            System.out.println("\nDigite a quantidade do produto 1: ");
            p1.setQtde(sc.nextInt());
            if(p1.getQtde() <= 0){
                throw new QuantidadeException(p1.getQtde());
            }
            System.out.println("\nDigite o preço de compra do produto 1: ");
            p1.setPreco_compra(sc.nextDouble());
            if(p1.getPreco_compra() < 0){
                throw new NumerosNegativos(p1.getPreco_compra());
            }
            System.out.println("\nDigite o preço de venda do produto 1: ");
            p1.setPreco_venda(sc.nextDouble());
            if(p1.getPreco_venda() < 0){
                throw new NumerosNegativos(p1.getPreco_venda());
            }
        }catch (QuantidadeException | NumerosNegativos e){
            System.out.println("Aconteceu um erro!");
            e.printStackTrace();
        }

        lucroA = (p1.getQtde() * p1.getPreco_venda()) - (p1.getQtde() * p1.getPreco_compra());
        porcentA = (lucroA*100)/(p1.getQtde() * p1.getPreco_compra());
        roiA = (lucroA - (p1.getQtde() * p1.getPreco_compra())/(p1.getQtde() * p1.getPreco_compra()));

        try {
            System.out.println("\nDigite a quantidade do produto 2: ");
            p2.setQtde(sc.nextInt());
            if(p2.getQtde() <= 0){
                throw new QuantidadeException(p1.getQtde());
            }
            System.out.println("\nDigite o preço de compra do produto 2: ");
            p2.setPreco_compra(sc.nextDouble());
            if(p2.getPreco_compra() < 0){
                throw new NumerosNegativos(p2.getPreco_compra());
            }
            System.out.println("\nDigite o preço de venda do produto 2: ");
            p2.setPreco_venda(sc.nextDouble());
            if(p2.getPreco_venda() < 0){
                throw new NumerosNegativos(p2.getPreco_venda());
            }
        }catch(QuantidadeException | NumerosNegativos e){
            System.out.println("Aconteceu um erro!");
            e.printStackTrace();
        }
        lucroB = (p2.getQtde() * p2.getPreco_venda()) - (p2.getQtde() * p2.getPreco_compra());
        porcentB = (lucroB*100)/(p2.getQtde() * p2.getPreco_compra());
        roiB = (lucroB - (p2.getQtde() * p2.getPreco_compra())/(p2.getQtde() * p2.getPreco_compra()));

        System.out.println("\n=====================================================================================================================================================================================");

        System.out.println("Lucro bruto");
        System.out.println("P1: " + lucroA);
        System.out.println("P2: " + lucroB);

        System.out.println("\nPorcentagem de lucro");
        System.out.println("P1: " + porcentA);
        System.out.println("P2: " + porcentB);

        System.out.println("\nRetorno sobre o investimento");
        System.out.println("P1: " + roiA);
        System.out.println("P2: " + roiB);


//        if(porcentA > porcentB){
//            System.out.println("\nA porcentagem de lucro do P1 é melhor para você!");
//            //System.out.println("O P2 precisa melhorar em: " + (100-porcentB) + "% para ter o mesmo lucro que o P1");
//
//
//        } else if(porcentB > porcentA){
//            System.out.println("\nA porcentagem de lucro P2 é melhor para você!");
//            //System.out.println("O P1 precisa melhorar em: " + (100-porcentA) + "%");
//
//        } else{
//            System.out.println("\nO lucro de P1 e P2 são iguais");
//        }
//
    }

}
