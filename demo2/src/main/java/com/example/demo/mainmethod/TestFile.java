package com.example.demo.mainmethod;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import com.example.demo.common.constants.CommonConstant;

public class TestFile {

	public void readFile(String convertFilePath) {

		File readFile = new File(convertFilePath);
		BufferedReader br = null;

		try {

			br = new BufferedReader(new InputStreamReader(new FileInputStream(readFile), CommonConstant.SHIFT_JIS));

			StringBuffer valueSb = null;
			String text = null;
			while ((text = br.readLine()) != null) {

				String[] fileDataText = text.split(",");

				valueSb = new StringBuffer();
				for (String value : fileDataText) {
					valueSb.append(value);
					valueSb.append(",");
				}
			}

			System.out.println(valueSb.toString());

		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
