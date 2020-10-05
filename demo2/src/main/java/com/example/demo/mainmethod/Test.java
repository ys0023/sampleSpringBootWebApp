package com.example.demo.mainmethod;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.example.demo.common.constants.CommonConstant;

public class Test {
	
	public static final String ROOT_PATH = "WebContext\\WEB-INF\\datafile\\";

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

//		String fileName = CommonConstant.ADMIN_USER_INFO_PATH;
//		String fileName = "C:\\workspace\\sampleSpringBootWebApp\\demo2\\WebContext\\WEB-INF\\datafile\\admin_user_info_data.txt";
		String fileName = "admin_user_info_data.txt";
		
        Path path = Paths.get(fileName);
        String filePath = path.toAbsolutePath().toString();
        String convertFilePath = filePath.replaceAll(fileName, "");
        String readFilePath = convertFilePath + ROOT_PATH + fileName;
        System.out.println("pass : " + convertFilePath + ROOT_PATH + fileName);
        
        
        TestFile testFile = new TestFile();
        testFile.readFile(readFilePath);
        

	}

}
