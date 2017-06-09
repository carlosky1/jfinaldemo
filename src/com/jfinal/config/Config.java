package com.jfinal.config;


import com.jfinal.controller.GetParameterController;
import com.jfinal.controller.HelloController;
import com.jfinal.controller.UsersController;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.model.Users;
import com.jfinal.plugin.activerecord.ActiveRecordException;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;

public class Config extends JFinalConfig{

	@Override
	public void configConstant(Constants me) {
		loadPropertyFile("dbconfig.txt");//加载数据库配置信息
		me.setDevMode(getPropertyToBoolean("devMode",true));
		me.setViewType(ViewType.FREE_MARKER);
	}

	@Override
	public void configRoute(Routes me) {
		me.add("/",HelloController.class);
		me.add("/param",GetParameterController.class);
		me.add("/users",UsersController.class);
	}

	@Override
	public void configEngine(Engine me) {
		
		
	}

	@Override
	public void configPlugin(Plugins me) {
		String decPassword=getProperty("password");
		String decUser=getProperty("user");
		DruidPlugin druid=new DruidPlugin(getProperty("jdbcUrl"),decUser,decPassword);
		me.add(druid);//添加连接池
		ActiveRecordPlugin arp=new ActiveRecordPlugin(druid);
		me.add(arp);//接入ActiveRecord插件
		arp.addMapping("t_user", Users.class);//将实体和表映射
	}

	@Override
	public void configInterceptor(Interceptors me) {
		//me.add(new SessionInViewInterceptor());
		
	}

	@Override
	public void configHandler(Handlers me) {
		me.add(new ContextPathHandler("contextPath"));//设置上下文路径
	}

}
