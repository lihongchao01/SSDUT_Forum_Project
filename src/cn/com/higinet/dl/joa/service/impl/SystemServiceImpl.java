package cn.com.higinet.dl.joa.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import cn.com.higinet.dl.joa.dao.SimpleDao;
import cn.com.higinet.dl.joa.service.SystemService;

public class SystemServiceImpl implements SystemService{
	
	@Autowired
	private SimpleDao joaSimpleDao;

	public SimpleDao getJoaSimpleDao() {
		return joaSimpleDao;
	}

	public void setJoaSimpleDao(SimpleDao joaSimpleDao) {
		this.joaSimpleDao = joaSimpleDao;
	}

	public List<Map<String, Object>> getSearchList(Map<String, Object> reqs) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		
		String sql = "select * from tp_users where userType = 2";
		Map<String, Object> map = new HashMap<String, Object>();
		list = joaSimpleDao.queryForList(sql, map);
		return list;
	}
}
