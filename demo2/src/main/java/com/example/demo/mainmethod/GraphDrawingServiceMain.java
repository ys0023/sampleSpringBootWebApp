//package com.example.demo.mainmethod;
//
//import java.util.List;
//
//import com.example.demo.common.constants.CommonConstant;
//import com.example.demo.common.constants.enump.RadarChartKindEnum;
//import com.example.demo.common.data.dto.ChartInfo;
//import com.example.demo.common.data.dto.ChartVlaue;
//import com.example.demo.common.util.GraphUtil;
//import com.example.demo.common.util.MyWindowListener;
//
//public class GraphDrawingServiceMain {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		List<ChartVlaue> chartVlaueList = GraphUtil.createChartInfo(CommonConstant.USER_SKIL_INFO_FILE_PATH, "user0001");
//
//		for (ChartVlaue chartVlaue : chartVlaueList) {
//			System.out.println(chartVlaue.getValueLabel() + " : " + chartVlaue.getValue());
//		}
//
//		ChartInfo chartInfo = new ChartInfo();
//		chartInfo.setChartName("スキルチャート");
//		chartInfo.setChartLabel("ヤマダ");
//		chartInfo.setChartVlaueList(chartVlaueList);
//		chartInfo.setMaxValue(RadarChartKindEnum.SKIL_CHART.getMaxValue());
//
//		GraphDrawingService f = new GraphDrawingService(chartInfo);
//		f.addWindowListener(new MyWindowListener());
//		f.setVisible(true);
//
//	}
//
//}
