package cn.com.higinet.dl.joa.service.impl;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import cn.com.higinet.dl.joa.common.IdUtil;
import cn.com.higinet.dl.joa.dao.SimpleDao;
import cn.com.higinet.dl.joa.service.ForumService;

@Service("ForumService")
public class ForumServiceImpl implements ForumService{
	
	private SimpleDao joaSimpleDao;
	
	public void setJoaSimpleDao(SimpleDao joaSimpleDao) {
		this.joaSimpleDao = joaSimpleDao;
	}
	public SimpleDao getJoaSimpleDao() {
		return joaSimpleDao;
	}
	
	@Override
	public String addTopic(Map<String, Object> map) {
		// TODO Auto-generated method stub
		String result="success";
		String topicId = IdUtil.uuid();
		map.put("topicId", topicId);
		int digest = 2;
		try{
		String sql ="insert into tp_topic values(:digest)";
		joaSimpleDao.executeUpdate(sql, map);
		}
		catch(Exception e){
			e.printStackTrace();
			result="failed";
		}
		return result;
	}

	@Override
	public void removeTopic() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addPost() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addForum() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeForum() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Map<String, Object>> getAllForum() {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public List<Map<String, Object>> getAllPost() {
		// TODO Auto-generated method stub
		
		
		
		return null;
	}

	@Override
	public List<Map<String, Object>> getAllPost(String userId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
