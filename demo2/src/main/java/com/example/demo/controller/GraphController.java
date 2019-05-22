package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.common.constants.CommonConstant;
import com.example.demo.common.constants.enump.RadarChartKindEnum;
import com.example.demo.common.data.dto.ChartInfo;
import com.example.demo.common.data.dto.ChartVlaue;
import com.example.demo.common.data.dto.UserInfo;
import com.example.demo.common.util.CommonUtil;
import com.example.demo.common.util.GraphUtil;
import com.example.demo.controller.base.BaseController;
import com.example.demo.service.UserService;

/**
 * グラフコントローラ.
 */
@Controller
public class GraphController extends BaseController {

	/** ユーザServiceクラス. */
	@Autowired
	private UserService userService;
	
	/**
	 * ユーザスキル情報表示処理.
	 * 
	 * @param response HttpServletResponse
	 */
	@RequestMapping(value = "/show_user_skil", method = RequestMethod.POST)
	public void showUserSkil(HttpServletResponse response) {
		
		String userId = (String)session.getAttribute("userId");
		
		// ユーザ情報の取得
		UserInfo userInfo = userService.getUserInfo(userId);
		
		// TODO ユーザ詳細情報がない場合の処理追加
		

		// 読み込みファイルのフルPATH
		String readFilePath = CommonUtil.readFilePath(CommonConstant.USER_SKIL_INFO_FILE_NAME);

		// スキル情報を生成
		List<ChartVlaue> chartVlaueList = GraphUtil.createChartInfo(readFilePath, userId);

		// チャート生成情報の生成
		ChartInfo chartInfo = new ChartInfo();
		chartInfo.setChartName(RadarChartKindEnum.SKIL_CHART.getChartKind());
		chartInfo.setChartLabel(userInfo.getUserDetailInfo().getUserName());
		chartInfo.setChartVlaueList(chartVlaueList);
		chartInfo.setMaxValue(RadarChartKindEnum.SKIL_CHART.getMaxValue());

		JFreeChart chart = GraphUtil.createJFreeChart(chartInfo.getChartName(), chartInfo.getChartLabel(), 
																				chartVlaueList, chartInfo.getMaxValue());
		
	    // グラフ出力
	    try {
			response.setContentType("image/png");
			ChartUtilities.writeChartAsPNG(response.getOutputStream(), chart, 500, 500);
			
			response.getOutputStream().flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
