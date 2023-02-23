import java.util.Scanner;

public class Main {
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

        System.out.println("\n=====================================================================================================================================================================================");

        System.out.println("\nDigite a quantidade do produto 1: ");
        p1.setQtde(sc.nextInt());
        System.out.println("\nDigite o preço de compra do produto 1: ");
        p1.setPreco_compra(sc.nextDouble());
        System.out.println("\nDigite o preço de venda do produto 1: ");
        p1.setPreco_venda(sc.nextDouble());

        System.out.println("\nDigite a quantidade do produto 2: ");
        p2.setQtde(sc.nextInt());
        System.out.println("\nDigite o preço de compra do produto 2: ");
        p2.setPreco_compra(sc.nextDouble());
        System.out.println("\nDigite o preço de venda do produto 2: ");
        p2.setPreco_venda(sc.nextDouble());


    }

}
