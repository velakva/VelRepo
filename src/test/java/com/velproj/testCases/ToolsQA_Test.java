package com.velproj.testCases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import com.velproj.pageObjects.ToolsQa;

public class ToolsQA_Test extends BaseClass {
@Test
public void browseTest() throws InterruptedException, AWTException, IOException{
	ToolsQa tools=new ToolsQa(driver);
	//tools.takeScr3();
	tools.browse();
	tools.uploadFile("C:\\Users\\Lenovo\\Desktop\\VEL.png");
}
}
