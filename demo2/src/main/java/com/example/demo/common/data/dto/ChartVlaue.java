package com.example.demo.common.data.dto;

/**
 * チャート値クラス.
 */
public class ChartVlaue {
	
	/**　 値のラベル. */
	private String valueLabel;
	
	/**　 チャート値. */
	private double value;

	public String getValueLabel() {
		return valueLabel;
	}

	public void setValueLabel(String valueLabel) {
		this.valueLabel = valueLabel;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}



}