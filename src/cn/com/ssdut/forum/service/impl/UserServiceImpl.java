package cn.com.ssdut.forum.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.ssdut.forum.dao.SimpleDao;
import cn.com.ssdut.forum.service.UserService;

@Transactional
@Service("UserService")
public class UserServiceImpl implements UserService{
	
	private static final String TABLE = "tp_users";

	@Autowired
	private @Setter
	SimpleDao topicSimpleDao;
	public SimpleDao topicSimpleDao(){
		return topicSimpleDao;
	}
	public void setUserDao(SimpleDao topicSimpleDao){
		this.topicSimpleDao = topicSimpleDao;
	}
	
	

	
	@Override
	public boolean login(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Object register(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean user_register_samenametest(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return false;
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
