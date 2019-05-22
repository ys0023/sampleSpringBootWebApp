package com.example.demo.common.data.dto;

import java.util.List;

/**
 * チャート生成情報クラス.
 */
public class ChartInfo {
	
	/**　 チャート名. */
	private String chartName;
	
	/**　 チャートラベル. */
	private String chartLabel;
	
	/**　 目盛り最大値. */
	private int maxValue;

	/**　 値の保持リスト. */
	private List<ChartVlaue> chartVlaueList;
	
	public String getChartName() {
		return chartName;
	}

	public void setChartName(String chartName) {
		this.chartName = chartName;
	}

	public String getChartLabel() {
		return chartLabel;
	}

	public void setChartLabel(String chartLabel) {
		this.chartLabel = chartLabel;
	}
	
	public int getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(int maxValue) {
		this.maxValue = maxValue;
	}

	public List<ChartVlaue> getChartVlaueList() {
		return chartVlaueList;
	}

	public void setChartVlaueList(List<ChartVlaue> chartVlaueList) {
		this.chartVlaueList = chartVlaueList;
	}
	
}