package cn.com.higinet.dl.joa.service.impl;


import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.higinet.dl.joa.common.IdUtil;
import cn.com.higinet.dl.joa.dao.SimpleDao;
import cn.com.higinet.dl.joa.service.ForumService;
@Service("forumService")
public class ForumServiceImpl implements ForumService {
	@Autowired
	private SimpleDao joaSimpleDao;

	public SimpleDao getJoaSimpleDao() {
		return joaSimpleDao;
	}

	public void setJoaSimpleDao(SimpleDao joaSimpleDao) {
		this.joaSimpleDao = joaSimpleDao;
	}

	@Override
	public String addTopic(Map<String, Object> reqs) {
		// TODO Auto-generated method stub
		String result = "success";
		String topicId = IdUtil.uuid();
		java.util.Date date = new java.util.Date();
		Date createTime =  new Date(date.getTime());
		reqs.put("topicId", topicId);
		reqs.put("digest", 2);
		reqs.put("createTime", createTime);
		try {
			String sql="insert into tp_topic (topicId, userId, createTime,digest)"
					+ " values(:userId,:userName,:createTime,:digest)";
			joaSimpleDao.executeUpdate(sql, reqs);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result = "failed";
		}
		return result;
	}

	@Override
	public String removeTopic(Map<String, Object> reqs) {
		// TODO Auto-generated method stub
		String result = "success";
		String sql = "delete from tp_topic where topicId=:topicId";
	
		try {
			joaSimpleDao.executeUpdate(sql, reqs);
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result = "failed";
		}
		return result;
	}
	



	@Override
	public List<Map<String, Object>> getAllForum() {
		// TODO Auto-generated method stub
        String sql = "select * from tp_forum ";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(null, null);
		
		return joaSimpleDao.queryForList(sql, params);
	}

	@Override
	public String addPost(Map<String, Object> reqs) {
		// TODO Auto-generated method stub
		String result = "success";
		String postId = IdUtil.uuid();
		java.util.Date date = new java.util.Date();
		Date createTime =  new Date(date.getTime());
		reqs.put("postId", postId);
	
		reqs.put("createTime", createTime);
		try {
			String sql="insert into tp_post (postId, userId, createTime,postTitle,postText)"
					+ " values(:postId,:userId,:createTime,:postTitle,:postText)";
			joaSimpleDao.executeUpdate(sql, reqs);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result = "failed";
		}
		return result;
	}

	@Override
	public String addForum(Map<String, Object> reqs) {
		// TODO Auto-generated method stub
		String result = "success";
		String forumId = IdUtil.uuid();
		
		reqs.put("forumId", forumId);
		
		try {
			String sql="insert into tp_forum (forumId, forumName, forumDesc)"
					+ " values(:forumId,:forumName,:forumDesc)";
			joaSimpleDao.executeUpdate(sql, reqs);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result = "failed";
		}
		return result;
	}

	@Override
	public String removeForum(Map<String, Object> reqs) {
		// TODO Auto-generated method stub
		String result = "success";
		String sql = "delete from tp_forum where forumId=:forumId";
	
		try {
			joaSimpleDao.executeUpdate(sql, reqs);
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result = "failed";
		}
		return result;
	}

	@Override
	public List<Map<String, Object>> getAllTopic() {
		// TODO Auto-generated method stub
	     String sql = "select * from tp_topic ";
			
			Map<String, Object> params = new HashMap<String, Object>();
			params.put(null, null);
			
			return joaSimpleDao.queryForList(sql, params);
	}
}
