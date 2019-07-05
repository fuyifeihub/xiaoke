package com.shinesend.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping(value = "test", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
public class Test {

@RequestMapping("login.do")
@ResponseBody	
public String login(HttpServletRequest request ,String username,String pass){
	String usernametrim="";
	for(int i=0;i<username.length();i++){
		char char1=username.charAt(i);
		if(' '!=char1){
			usernametrim+=	char1;
		}	
	}
	
	if("".equals(usernametrim)){
		return "请输入用户名";
	}
	else if("admin".equals(usernametrim)&&"admin".equals(pass)){
		request.getSession().setAttribute("username", usernametrim);
		return "ture";
	}
	else if("fyf".equals(usernametrim)&&"fyf".equals(pass)){
		request.getSession().setAttribute("username", usernametrim);
		return "ture";
	}else{
		return "用户名或密码错误";
	}
	
}
@RequestMapping("getusername.do")
@ResponseBody
public String getUserName(HttpServletRequest request){
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Object attribute = request.getSession().getAttribute("username");
	
	return String.valueOf(attribute);
}
}
