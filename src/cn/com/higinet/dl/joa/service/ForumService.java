package cn.com.higinet.dl.joa.service;

import java.util.List;
import java.util.Map;

public interface ForumService {
	public String addTopic(Map<String, Object> reqs);
	
	public String  removeTopic(Map<String, Object> reqs);
	
	public String addPost(Map<String, Object> reqs);
	
	public String addForum(Map<String, Object> reqs);
	
	public String removeForum(Map<String, Object> reqs);
	
	public List<Map<String, Object>> getAllForum();
	
	public List<Map<String, Object>> getAllTopic();

}
