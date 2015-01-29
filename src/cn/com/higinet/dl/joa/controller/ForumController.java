package cn.com.higinet.dl.joa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import cn.com.higinet.dl.joa.service.ForumService;
@Controller("forumController")
public class ForumController {
	@Autowired
	private ForumService forumService;
	
	public ForumService getForumService(){
		return forumService;
	}
	
	public void setForumService(ForumService forumService){
		this.forumService = forumService;
	}
}
