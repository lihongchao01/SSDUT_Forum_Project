package cn.com.ssdut.forum.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.ssdut.forum.common.IdUtil;
import cn.com.ssdut.forum.dao.SimpleDao;
import cn.com.ssdut.forum.service.UserService;

@Transactional
@Service("UserService")
public class UserServiceImpl implements UserService{
	

		@Autowired
		private SimpleDao joaSimpleDao;

		public SimpleDao getJoaSimpleDao() {
			return joaSimpleDao;
		}

		public void setJoaSimpleDao(SimpleDao joaSimpleDao) {
			this.joaSimpleDao = joaSimpleDao;
		}
		
	
	

	
	@Override
	public boolean login(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Object register(Map<String, Object> map) {
		// TODO Auto-generated method stub
		String userId=IdUtil.uuid();
		map.put("userType", 2);
		map.put("userId", userId);
		
		String sql="insert into tp_users (userId, userName, userPwd, userType)"
				+ " values(:userId,:userName,:userPwd,:userType)";
		joaSimpleDao.executeUpdate(sql, map);
	
		return "success";
	}
	@Override
	public boolean user_register_samenametest(Map<String, Object> reqs) {
		// TODO Auto-generated method stub
		String sql="select username from db_user where username=:username";
		if(joaSimpleDao.count(sql, reqs)==1 )
		{	
			return true;
		}
		else{
			return false;
		}	
	}
	@Override
	public void loginEnsure(String username) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getIDByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Map<String, Object> getUserAccountInfo(String user_id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Map<String, Object> getUserInfoDetail(Map<String, Object> reqs) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String userInfoSave(Map<String, Object> reqs,
			Map<String, Object> conds) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getUserType(String user_id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Map<String, Object>> getUserList() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getPassword(Map<String, Object> reqs) {
		// TODO Auto-generated method stub
		return null;
	}
}
