package cn.com.ssdut.forum.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.com.ssdut.forum.dao.SimpleDao;
import cn.com.ssdut.forum.service.SysService;

@Repository
public class SysServiceImpl implements SysService{
	
	@Autowired
	private SimpleDao simpleDao;
	public SimpleDao getSimpleDao() {
		return simpleDao;
	}
	public void setSimpleDao(SimpleDao simpleDao) {
		this.simpleDao = simpleDao;
	}

	@Override
	public Map<String, Object> login(Map<String, Object> reqs) {
		// TODO Auto-generated method stub
		String sql = "select * from user_info where user_name=:user_name and password=:password";
		List<Map<String, Object>> list = simpleDao.queryForList(sql, reqs);
		Map<String, Object> result = new HashMap<String, Object>();
		if(list.size() != 1)
			result.put("result", "fail");
		else {
			result = list.get(0);
			result.put("result", "success");
		}
		return result;
	}
}
