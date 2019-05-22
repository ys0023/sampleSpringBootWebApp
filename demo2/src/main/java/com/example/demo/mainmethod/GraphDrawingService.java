package com.example.demo.mainmethod;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.List;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.SpiderWebPlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;

import com.example.demo.common.data.dto.ChartInfo;
import com.example.demo.common.data.dto.ChartVlaue;

public class GraphDrawingService extends JFrame {

	private static final long serialVersionUID = 300225314345929915L;

	public GraphDrawingService(ChartInfo chartInfo) {

		this.setTitle(chartInfo.getChartName());
		this.setBounds(100, 100, 700, 500);

		JPanel p = new JPanel();
		p.add(this.spiderWebPlot(chartInfo.getChartName(), chartInfo.getChartLabel(), chartInfo.getChartVlaueList(), chartInfo.getMaxValue()));

		Container cp = getContentPane();
		cp.add(p, BorderLayout.NORTH);

		Properties prop = System.getProperties();
		prop.put("java.awt.headless", "true");
	}

	public JPanel spiderWebPlot(String chartName, String label, List<ChartVlaue> chartVlaueList, int maxValue) {

		DefaultCategoryDataset ds = new DefaultCategoryDataset();

		for (ChartVlaue chartVlaue : chartVlaueList) {
			ds.addValue(chartVlaue.getValue(), label, chartVlaue.getValueLabel());
		}

		SpiderWebPlot plot = new SpiderWebPlot(ds);
		JFreeChart fc = new JFreeChart(chartName, TextTitle.DEFAULT_FONT, plot, true);
		
		// 目盛り最大値を設定
		plot.setMaxValue(maxValue);

		ChartPanel cp = new ChartPanel(fc);
		return cp;
	}
}
