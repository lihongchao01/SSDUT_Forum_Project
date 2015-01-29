package cn.com.higinet.dl.joa.service;

import java.util.List;
import java.util.Map;

public interface ForumService {
	public String addTopic(Map<String, Object> map);
	
	public void removeTopic();
	
	public void addPost();
	
	public void addForum();
	
	public void removeForum();
	
	public List<Map<String, Object>> getAllForum();
	
	public List<Map<String, Object>> getAllPost(String userId);

	List<Map<String, Object>> getAllPost();
	
}
