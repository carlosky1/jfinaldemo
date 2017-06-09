package com.jfinal.controller;

import com.jfinal.core.Controller;

public class GetParameterController extends Controller{
	public void get1(){
		int id=getParaToInt(0);//通过索引值接受get请求的方式
		System.out.println(id);
		setAttr("msg","接收成功");
		renderFreeMarker("param.html");
	}
	public void get2(){
		String id=getPara(1);//通过索引值接受get请求的方式
		System.out.println(id);
		String id1=getPara(2);
		System.out.println(id1);
		
		setAttr("msg","接收成功");
		renderFreeMarker("param.html");
	}
	public void post(){
		String username= getPara("username");//这种接收方式比较常用
		String userpwd= getPara("userpwd");
		System.out.println(username);
		System.out.println(userpwd);
		setAttr("msg","接收成功");
		renderFreeMarker("param.html");
	}
	public void index(){
		//当页面和方法一致时，会自动跳转到此页面
		//renderFreeMarker("index.html");
	}
}
