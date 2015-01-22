package cn.com.ssdut.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.com.ssdut.forum.service.NewsService;
import cn.com.ssdut.forum.view.Model;

@Controller("newsController")
@RequestMapping("/news/operate")
public class NewsController {

	@Autowired
	private NewsService newsService;

	@RequestMapping(value="/test", method=RequestMethod.GET)
	public String test(){
		return "others/test";
	}
	
	@RequestMapping(value="/enter", method=RequestMethod.GET)
	public String newsEnter(){
		return "news_manage/news_index";
	}
	@RequestMapping(value="/getMain", method=RequestMethod.POST)
	public Model getMainNews(){
		Model model = new Model();
		model.setList(newsService.listMainNews());
		return model;
	}
}
