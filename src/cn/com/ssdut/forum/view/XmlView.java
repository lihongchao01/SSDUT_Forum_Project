package cn.com.ssdut.forum.view;

import java.util.*;
import java.io.*;

import org.dom4j.*;
import org.dom4j.io.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.View;

//调用此类，必须在model中有document, XML DOM4J文档对象
//调用之前，需要设置document对象的属性
//document.setXMLEncoding("UTF-8");
public class XmlView implements View {

	@Override
	public String getContentType() {
		return "application/xml; charset=utf-8";
	}

	
	
	@Override
	public void render(Map<String, ?> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	
		if (request.getProtocol().equals("HTTP/1.0")) {
			// HTTP 1.0
			response.setHeader("Pragma", "no-cache");
		} else {
			// HTTP 1.1 or later
			response.setHeader("Cache-Control", "no-cache");
		}
			
		Document document = (Document) model.get("document");
		
		OutputStreamWriter osw = new OutputStreamWriter(response.getOutputStream(), "UTF-8");
		OutputFormat of = new OutputFormat();
		of.setEncoding("UTF-8"); // 设置编码
		of.setIndent(true); // 设置XML元素缩进格式
		of.setIndent("    "); // 设置缩进空白字符串为4个空白符
		of.setNewlines(true); // 分行存储
		
		XMLWriter writer = new XMLWriter(osw, of);
		
		writer.write(document);
		writer.close();
		
		response.getOutputStream().close();
	}

}
