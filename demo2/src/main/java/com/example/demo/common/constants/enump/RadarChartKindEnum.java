package com.example.demo.common.constants.enump;

/**
 * レーダチャート種類Enum.
 */
public enum RadarChartKindEnum {
	
	SKIL_CHART("1", "スキルチャート", 5),
    ;

	/**  コード値. */
    private final String code;
    
	/**  チャート名. */
    private final String chartKind;
    
	/**  目盛り最大値. */
    private final int maxValue;

    private RadarChartKindEnum(final String code, final String chartKind, final int maxValue) {
       this.code = code;
       this.chartKind = chartKind;
       this.maxValue = maxValue;
    }

    public String getCode() {
        return this.code;
    }
    
    public String getChartKind() {
        return this.chartKind;
    }
    
    public int getMaxValue() {
        return this.maxValue;
    }

}
