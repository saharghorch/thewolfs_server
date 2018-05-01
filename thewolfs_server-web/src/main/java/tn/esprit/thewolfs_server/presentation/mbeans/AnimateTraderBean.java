package tn.esprit.thewolfs_server.presentation.mbeans;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.OhlcChartModel;
import org.primefaces.model.chart.OhlcChartSeries;

import tn.esprit.thewolfs_server.entity.Trader;
import tn.esprit.thewolfs_server.services.TraderServiceLocal;

@ManagedBean
public class AnimateTraderBean implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private OhlcChartModel animatedModel1;
	private BarChartModel animatedModel2;
	private List<Trader> listTraderLevelOne;
	private List<Trader> listTraderLevelTwo;
	private List<Trader> listTraderLevelThree;
	@EJB
	private TraderServiceLocal traderServiceLocal;

	public AnimateTraderBean() {
		listTraderLevelOne = new ArrayList<>();
		listTraderLevelTwo = new ArrayList<>();
		listTraderLevelThree = new ArrayList<>();
	}

	@PostConstruct
	public void init() {
		createAnimatedModels();
		listTraderLevelOne = traderServiceLocal.findTraverLevel1();
		listTraderLevelTwo = traderServiceLocal.findTraverLevel2();
		listTraderLevelThree = traderServiceLocal.findTraverLevel3();

	}

	public OhlcChartModel getAnimatedModel1() {
		return animatedModel1;
	}

	public BarChartModel getAnimatedModel2() {
		return animatedModel2;
	}

	private void createAnimatedModels() {
		animatedModel1 = initLinearModel();
		animatedModel1.setTitle("Traders' Solde");
		animatedModel1.setAnimate(true);
		animatedModel1.setLegendPosition("se");
		Axis yAxis = animatedModel1.getAxis(AxisType.Y);
		// yAxis.setMin(10000);
		// yAxis.setMax(135000);
		// test OHLC

		animatedModel1.setCandleStick(true);
		animatedModel1.getAxis(AxisType.X).setLabel("Traders");
		animatedModel1.getAxis(AxisType.Y).setLabel("Solde Value");

		// BAr

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
		traders1.set("Trading Levels", traderServiceLocal.calculerLevel1());

		ChartSeries traders2 = new ChartSeries();
		traders2.setLabel("Level Two");
		traders2.set("Level2", traderServiceLocal.calculerLevel2());

		ChartSeries traders3 = new ChartSeries();
		traders3.setLabel("Level Three");
		traders3.set("Level3", traderServiceLocal.calculerLevel3());

		model.addSeries(traders1);
		model.addSeries(traders2);
		model.addSeries(traders3);

		return model;
	}

	private OhlcChartModel initLinearModel() {
		// LineChartModel model = new LineChartModel();

		/*
		 * Trader t1,t2,t3,t4,t5,t6,t7,t8;
		 * t1=traderServiceLocal.findTraderById(1);
		 * t2=traderServiceLocal.findTraderById(3);
		 * t3=traderServiceLocal.findTraderById(5);
		 * t4=traderServiceLocal.findTraderById(6);
		 * t5=traderServiceLocal.findTraderById(7);
		 * t6=traderServiceLocal.findTraderById(8);
		 * t7=traderServiceLocal.findTraderById(9);
		 * t8=traderServiceLocal.findTraderById(10);
		 */
		// LineChartSeries series1 = new LineChartSeries();
		// series1.setLabel("Series 1");
		/*
		 * series1.set(1, t1.getSolde()); series1.set(2, t2.getSolde());
		 * series1.set(3, t3.getSolde()); series1.set(4, t4.getSolde());
		 * series1.set(5, t5.getSolde()); series1.set(6, t6.getSolde());
		 * series1.set(7, t7.getSolde()); series1.set(8, t8.getSolde());
		 */
		/*
		 * LineChartSeries series2 = new LineChartSeries();
		 * series2.setLabel("Series 2");
		 * 
		 * series2.set(1, 20000); series2.set(2, 30000); series2.set(3, 25000);
		 * series2.set(4, 70000); series2.set(5, 90000);
		 * 
		 * 
		 * 
		 * //new
		 * 
		 * 
		 * 
		 * LineChartSeries series1 = new LineChartSeries();
		 * series1.setLabel("Series 1"); listTraderLevelOne=
		 * traderServiceLocal.findTraverLevel1(); for(int
		 * i=0;i<listTraderLevelOne.size();i++) { Trader t=
		 * listTraderLevelOne.get(i); series1.set(i, t.getSolde());
		 * 
		 * }
		 * 
		 * 
		 * model.addSeries(series1); model.addSeries(series2); return model;
		 */

		animatedModel1 = new OhlcChartModel();
		listTraderLevelOne = traderServiceLocal.findTraverLevel1();
		for (int i = 0; i <41; i++) {
			
			
			animatedModel1.add(new OhlcChartSeries(i, 120d, Math.random() * 50 + 110,
					Math.random() * 20 + 80, Math.random() * 80 + 80));
			//animatedModel1.add(new OhlcChartSeries(i,,50d,100d,5000d));
		}

		return animatedModel1;
	}


}
