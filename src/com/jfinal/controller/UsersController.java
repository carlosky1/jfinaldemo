package com.jfinal.controller;

import com.jfinal.core.Controller;
import com.jfinal.model.Users;

public class UsersController extends Controller {
	//显示Users列表
	public void index(){
		renderFreeMarker("index.html");
	}
	public void addUsers(){
		renderFreeMarker("addusers.html");	
	}
	public void doAddUsers(){//处理增加记录的方法
	
		Users users=getModel(Users.class);//jfial必杀技：getmodel，快速开发全靠它
//		Users users=getModel(Users.class,"u"); //把usersform中users改成 u【别名】
		//System.out.println(users);
		users.set("userpwd", "1234");
		boolean flag=users.save();
		if(flag){redirect("/users/");}renderText("");
		}
	public void queryUsersById(){//按照id查询记录
		
	}
	public void deleteById(){
		
	}
	public void updateUsers(){
		
	}
}
