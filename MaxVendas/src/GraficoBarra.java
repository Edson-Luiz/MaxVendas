import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;

public class GraficoBarra extends JFrame {

    public GraficoBarra(double n1, double n2){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Gráfico Barra");
        setSize(950,700);
        setLocationRelativeTo(null);
        criarGrafico(n1,n2);
        setVisible(true);
    }

    public void criarGrafico(double n1, double n2){
        DefaultCategoryDataset barra = new DefaultCategoryDataset();
        barra.setValue(n1, "Produto 1", "");
        barra.setValue(n2, "Produto 2", "");

        JFreeChart grafico = ChartFactory.createBarChart("Lucro por produto","Produtos","Lucro bruto",barra, PlotOrientation.VERTICAL, true,true,false);
        ChartPanel painel = new ChartPanel(grafico);
        add(painel);
    }

}
