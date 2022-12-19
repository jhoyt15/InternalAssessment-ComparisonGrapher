import org.jfree.chart.ChartPanel;

import java.awt.BasicStroke;
import java.awt.Color;

import javax.swing.JFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYAreaRenderer;
import org.jfree.data.function.Function2D;
import org.jfree.data.function.NormalDistributionFunction2D;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.xy.XYDataset;



/*
 * This class creates the normal distribution graph using the JFreeChart library
 * This class also handles adding the markers to the graph
 */
public class Chart extends JFrame {
	XYDataset dataset;
	XYPlot plot;
	JFreeChart chart;
   public Chart(String applicationTitle , String chartTitle, BenchmarkData bm, CustomerData cd) 
   {
      Function2D graph = new NormalDistributionFunction2D(bm.getMedian(), getVar(bm));
      dataset = DatasetUtilities.sampleFunction2D(graph, bm.getMedian()*-3.0, bm.getMedian()*5.0, 100, "Normal Curve");
      
      ValueMarker marker1 = new ValueMarker(bm.getLowerMedian());
      marker1.setPaint(Color.black);
      marker1.setLabel("25th Percentile");
      marker1.setStroke(new BasicStroke(5.0f));
      ValueMarker marker2 = new ValueMarker(bm.getUpperMedian());
      marker2.setPaint(Color.black);
      marker2.setLabel("75th Percentile");
      marker2.setStroke(new BasicStroke(5.0f));
      ValueMarker marker3 = new ValueMarker(cd.getMedian());
      
      if(cd.getMedian() > bm.getUpperMedian())
    	  marker3.setPaint(Color.red);
      else
    	  marker3.setPaint(Color.blue);
      marker3.setStroke(new BasicStroke(5.0f));
      
      NumberAxis xAxis = new NumberAxis(null);
      NumberAxis yAxis = new NumberAxis(null);
      XYAreaRenderer renderer = new XYAreaRenderer();
      renderer.setPaint(Color.lightGray);
      xAxis.setRange(bm.getMedian()-(getVar(bm)*4),bm.getMedian()+(getVar(bm)*4));
      plot = new XYPlot(dataset, xAxis, yAxis, renderer);
      plot.addDomainMarker(marker1);
      plot.addDomainMarker(marker2);
      plot.addDomainMarker(marker3);
      
      
      
      chart = new JFreeChart(plot);
         
      ChartPanel chartPanel = new ChartPanel(chart);
      chartPanel.setPreferredSize(new java.awt.Dimension(1000 , 400));
      setContentPane(chartPanel);
   }

   /*
    * This method calculates one distribtion using the selected benchmark
    */
	
	public double getVar(BenchmarkData bm)
	{
		double x = bm.getUpperMedian();
		double y = bm.getMedian();
		double z = x-y;
		return z/.67;
	}
}