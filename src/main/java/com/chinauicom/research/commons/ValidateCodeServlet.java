package com.chinauicom.research.commons;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinauicom.research.commons.constant.WcsSessionConstant;

/**
 *<p>File: ValidateCodeServlet.java</p>
 *<p>Description: 系统图片验证码生成Servlet类</p>
 *<p>Company: 从兴技术有限公司</p>
 *<p>Author: 刘高林</p>
 *<p>Version: 1.0,2014-3-24 下午8:34:36,刘高林,Ins</p>
 *
 */
public class ValidateCodeServlet extends HttpServlet {

	private static final long serialVersionUID = -6816540956945089845L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		//设置输出内容为图像，格式为jpeg
		res.setContentType("image/jpg");
		try {
			RandomGraphic r = RandomGraphic.createInstance(4);
			String charValue = r.randAlpha();
			//将字符串的值保留在session中，便于和用户手工输入的验证码比较
			req.getSession().setAttribute(WcsSessionConstant.SESSION_VALIDATE_CODE, charValue);
			//将内容输出到响应客户端对象的输出流中，生成的图片中包含4个字符
			r.draw(charValue, RandomGraphic.GRAPHIC_JPEG, res.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

