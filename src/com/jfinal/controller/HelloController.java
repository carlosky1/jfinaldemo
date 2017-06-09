package com.jfinal.controller;

import com.jfinal.core.Controller;

public class HelloController extends Controller{
	//展示hello视图
	public void index(){ 
		String msg="welcome to JFinal!!";
		setAttr("hellojfinal", msg);
		
		renderFreeMarker("hello.html");//渲染你跳转的页面
	}
	
}
