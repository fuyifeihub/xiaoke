package com.shinesend.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "test", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
public class Test {
	protected HttpServletRequest request;  
    protected HttpServletResponse response;
	@ModelAttribute
	public void setReqAndRes(HttpServletRequest request,
			HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}	
@RequestMapping("login.do")
@ResponseBody	
public String login(String username,String pass){
	
	if("".equals(username)){
		return "请输入用户名";
	}
	else if("admin".equals(username)&&"admin".equals(pass)){
		request.getSession().setAttribute("username", username);
		return "ture";
	}
	else if("fyf".equals(username)&&"fyf".equals(pass)){
		request.getSession().setAttribute("username", username);
		return "ture";
	}else{
		return "用户名或密码错误";
	}
	
}
@RequestMapping("getusername.do")
@ResponseBody
public String getUserName(){
	Object attribute = request.getSession().getAttribute("username");
	return String.valueOf(attribute);
}
}
