package com.example.demo.common.util;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.SpiderWebPlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;

import com.example.demo.common.constants.CommonConstant;
import com.example.demo.common.data.dto.ChartVlaue;
import com.example.demo.common.data.dto.FileDataInfo;
import com.example.demo.service.DataFileService;

/**
 * グラフUtilクラス
 */
public class GraphUtil extends JFrame {

	/** シリアルID */
	private static final long serialVersionUID = 300225314345929915L;
	
	public static JFreeChart createJFreeChart(String chartName, String label, List<ChartVlaue> chartVlaueList, int maxValue) {

		DefaultCategoryDataset ds = new DefaultCategoryDataset();

		for (ChartVlaue chartVlaue : chartVlaueList) {
			ds.addValue(chartVlaue.getValue(), label, chartVlaue.getValueLabel());
		}

		SpiderWebPlot plot = new SpiderWebPlot(ds);
		JFreeChart fc = new JFreeChart(chartName, TextTitle.DEFAULT_FONT, plot, true);
		
		// 目盛り最大値を設定
		plot.setMaxValue(maxValue);
		
		return fc;
	}
	
	/**
	 * チャート情報生成処理.
	 * <p>
	 * 指定したユーザ、PATHのファイル情報を基にチャート情報を生成する。<br>
	 * </p>
	 * 
	 * @value filePath ファイルPATH
	 * @value userId 対象ユーザID
	 * @return チャート生成情報
	 */
	public static List<ChartVlaue> createChartInfo(String filePath, String userId) {

		// ヘッダー情報有でファイル情報を取得
		DataFileService dataFileService = new DataFileService();
		FileDataInfo fileDataInfo = dataFileService.getFileData(filePath, CommonConstant.FILE_HEADER_EXIST);

		List<ChartVlaue> chartVlaueList = new ArrayList<ChartVlaue>();

		List<String> fileDataList = fileDataInfo.getFileDataList();
		for (int i = 0; i < fileDataList.size(); i++) {
			
			String fileData = fileDataList.get(i);
			String[] userSkilInfo = fileData.split(",");

			// 対象のユーザのみの情報を生成する
			String fileUserId = userSkilInfo[0];
			if (!fileUserId.equals(userId)) {
				continue;
			}
			
			String[] fileHederInfo = fileDataInfo.getFileHeaderInfo().split(",");
			
			// 1項目目はユーザIDなので「1」から処理
			for (int j = 1; j < userSkilInfo.length; j++) {

				String fileHederStr = fileHederInfo[j];
				String skilPoint = userSkilInfo[j];

				ChartVlaue chartVlaue = new ChartVlaue();
				chartVlaue.setValueLabel(fileHederStr);
				chartVlaue.setValue(Double.valueOf(skilPoint));
				chartVlaueList.add(chartVlaue);
			}
		}
		return chartVlaueList;
	}
	

}
