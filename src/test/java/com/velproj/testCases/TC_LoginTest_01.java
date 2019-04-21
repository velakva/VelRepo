package com.velproj.testCases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.velproj.pageObjects.LoginPage;
import com.velproj.utilities.XLUtils;

public class TC_LoginTest_01 extends BaseClass {
@Test(dataProvider="LoginData")
public void loginTest(String userName, String password) throws IOException, InterruptedException{
	LoginPage lp = new LoginPage(driver);
	lp.login(userName, password);
	if(driver.getTitle().equals("vel")){
		Assert.assertTrue(true);
	}else{
		captureScreen(driver,"TC_LoginTest_01");
		Assert.assertTrue(false);
	}
}
@DataProvider(name="LoginData")
public String[][] getData() throws IOException{
	String path=System.getProperty("user.dir")+"/src/test/java/com/velProj/testData/LoginData.xlsx";
	System.out.println("Path is "+path);
	int rownum=XLUtils.getRowCount(path, "loginData");
	int colNum=XLUtils.getColCount(path, "loginData");
	System.out.println("Row num & col num is "+rownum+" and "+colNum);
	String[][] data=new String[rownum][colNum];
	for(int i=1;i<=rownum;i++){
		for(int j=0;j<colNum;j++){
			data[i-1][j]=XLUtils.getExcelData(path, "loginData", i, j);
		}
	}
	return data;
}
}
