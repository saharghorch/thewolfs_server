package tn.esprit.thewolfs_server.presentation.mbeans;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartSeries;

import tn.esprit.thewolfs_server.entity.Trader;
import tn.esprit.thewolfs_server.services.TraderServiceLocal;

@ManagedBean
public class AnimateTraderBean implements Serializable{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LineChartModel animatedModel1;
	    private BarChartModel animatedModel2;
		@EJB
		private TraderServiceLocal traderServiceLocal;
	
	 
	    @PostConstruct
	    public void init() {
	        createAnimatedModels();
	    }
	 
	    public LineChartModel getAnimatedModel1() {
	        return animatedModel1;
	    }
	 
	    public BarChartModel getAnimatedModel2() {
	        return animatedModel2;
	    }
	 
	    private void createAnimatedModels() {
	        animatedModel1 = initLinearModel();
	        animatedModel1.setTitle("Line Chart");
	        animatedModel1.setAnimate(true);
	        animatedModel1.setLegendPosition("se");
	        Axis yAxis = animatedModel1.getAxis(AxisType.Y);
	        yAxis.setMin(10000);
	        yAxis.setMax(135000);
	         
	        animatedModel2 = initBarModel();
	        animatedModel2.setTitle("Traders' Levels");
	        animatedModel2.setAnimate(true);
	        animatedModel2.setLegendPosition("ne");
	        yAxis = animatedModel2.getAxis(AxisType.Y);
	        yAxis.setMin(0);
	        yAxis.setMax(8);
	    }
	     
	    private BarChartModel initBarModel() {
	        BarChartModel model = new BarChartModel();
	 
	        ChartSeries traders1 = new ChartSeries();
	        traders1.setLabel("Level One");
	        traders1.set("Trading Levels",traderServiceLocal.calculerLevel1() );
	        
	        ChartSeries traders2 = new ChartSeries();
	        traders2.setLabel("Level Two");
	        traders2.set("Level2",traderServiceLocal.calculerLevel2() );
	        
	        ChartSeries traders3 = new ChartSeries();
	        traders3.setLabel("Level Three");
	        traders3.set("Level3",traderServiceLocal.calculerLevel3());
	      	 
	        model.addSeries(traders1);
	        model.addSeries(traders2);
	        model.addSeries(traders3);
	      
	        return model;
	    }
	     
	    private LineChartModel initLinearModel() {
	        LineChartModel model = new LineChartModel();
	 
	        
	        Trader t1,t2,t3,t4,t5,t6,t7,t8;
	        t1=traderServiceLocal.findTraderById(1);
	        t2=traderServiceLocal.findTraderById(3);
	        t3=traderServiceLocal.findTraderById(5);
	        t4=traderServiceLocal.findTraderById(6);
	        t5=traderServiceLocal.findTraderById(7);
	        t6=traderServiceLocal.findTraderById(8);
	        t7=traderServiceLocal.findTraderById(9);
	        t8=traderServiceLocal.findTraderById(10);
	        
	        LineChartSeries series1 = new LineChartSeries();
	        series1.setLabel("Series 1");
	       
	        series1.set(1, t1.getSolde());
	        series1.set(2, t2.getSolde());
	        series1.set(3, t3.getSolde());
	        series1.set(4, t4.getSolde());
	        series1.set(5, t5.getSolde());
	        series1.set(6, t6.getSolde());
	        series1.set(7, t7.getSolde());
	        series1.set(8, t8.getSolde());
	 
	        LineChartSeries series2 = new LineChartSeries();
	        series2.setLabel("Series 2");
	 
	        series2.set(1, 20000);
	        series2.set(2, 30000);
	        series2.set(3, 25000);
	        series2.set(4, 70000);
	        series2.set(5, 90000);
	 
	        model.addSeries(series1);
	        model.addSeries(series2);

	        System.out.println(t1.getSolde());
	    
	        return model;
	        }

}
