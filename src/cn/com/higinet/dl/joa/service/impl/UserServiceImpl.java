	package cn.com.higinet.dl.joa.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.higinet.dl.joa.common.IdUtil;
import cn.com.higinet.dl.joa.dao.SimpleDao;
import cn.com.higinet.dl.joa.service.UserService;

@Service("userService")
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
		String result = "success";
		String userId=IdUtil.uuid();
		map.put("userType", 2);
		map.put("userId", userId);
		
		String sql="insert into tp_users (userId, userName, userPwd, userType,realName)"
				+ " values(:userId,:userName,:userPwd,:userType,:realName)";
		joaSimpleDao.executeUpdate(sql, map);
	
		return "success";
	}
	
	@Override
	public boolean user_register_samenametest(Map<String, Object> reqs) {
		// TODO Auto-generated method stub
		String sql="select userName from tp_users where userName=:userName";
		if(joaSimpleDao.count(sql, reqs)==1 )
		{	
			return true;
		}
		else{
			return false;
		}	
	}
	@Override
	public void loginEnsure(String userName) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Map<String, Object> getUserAccountInfo(String userId) {
		// TODO Auto-generated method stub
		String sql = "select userId,userName,realName where userId=:userId";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		return joaSimpleDao.queryForList(sql, params).get(0);
	}
	@Override
	public Map<String, Object> getUserInfoDetail(Map<String, Object> reqs) {
		// TODO Auto-generated method stub
		return joaSimpleDao.retrieve("tp_users", reqs);
	}
	@Override
	public String userInfoSave(Map<String, Object> reqs,
			Map<String, Object> conds) {
		// TODO Auto-generated method stub
		 String result = "success";
	        try {
	        	joaSimpleDao.update("tp_users", reqs, conds);
	        } catch(Exception exception) {
	        	exception.printStackTrace();
	        	result = "failed";
	        }
	        return result;
	}
	@Override
	public int  getUserType(String userId) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		Map<String, Object> result = joaSimpleDao.retrieve("tp_users", map);
		if(null != result) {
			return Integer.parseInt( result.get("USERTYPE").toString());
		}
		else {
			return 0;
		}
	}
	@Override
	public List<Map<String, Object>> getUserList() {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		String sql = "select * from tp_users where userType = 2";
		Map<String, Object> map = new HashMap<String, Object>();
		list = joaSimpleDao.queryForList(sql, map);
		return list;
	}
	@Override
	public String getPassword(Map<String, Object> reqs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String userDelete(Map<String, Object> reqs, Map<String, Object> conds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean user_login(Map<String, Object> map) {
		// TODO Auto-generated method stub
		String sql = "select * from tp_users where userName=:userName and userPwd=:userPwd";
		List<Map<String, Object>> user = joaSimpleDao.queryForList(sql, map);
		if(user.size() == 1) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Map<String, Object> getUserInfo(Map<String, Object> map) {
		// TODO Auto-generated method stub
		String sql="select * from tp_users where userId=:userId";
		return joaSimpleDao.queryForList(sql, map).get(0);
	}

	@Override
	public List<Map<String, Object>> getAllUser(int userType) {
		// TODO Auto-generated method stub
		String sql = "select * from tp_users where userType=2";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userType", userType);
		return joaSimpleDao.queryForList(sql, params);
	}

	@Override
	public String addUser(Map<String, Object> reqs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteUser(Map<String, Object> reqs) {
		// TODO Auto-generated method stub
		String result = "success";
		String sql = "delete from tp_users where userId=:userId";
	
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
	public Map<String, Object> getUserDetail(Map<String, Object> reqs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String editUser(Map<String, Object> reqs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUserIdByUsername(String userName) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("userName", userName);
		String sql = "select * from tp_users where userName=:userName";
		List<Map<String, Object>> list = joaSimpleDao.queryForList(sql, map);
		return list.get(0).get("userId").toString();
	}
	@Override
	public String getUserNameByUserId(String userId) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		String sql = "select *from tp_users where userId=:userId";
		List<Map<String, Object>> list = joaSimpleDao.queryForList(sql, map);
		return list.get(0).get("userName").toString();
		
	}

	@Override
	public String getRealNameByUserId(String userId) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String, Object>();
		//Map<String,Object> reqs = new HashMap<String, Object>();
		map.put("userId", userId);
		String sql = "select * from tp_users where userId=:userId";
		//reqs =joaSimpleDao.retrieve("tp_users",map);
		List<Map<String, Object>> list = joaSimpleDao.queryForList(sql, map);
		return list.get(0).get("realName").toString();
	}

	@Override
	public String getUsePwdByUserId(String userId) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		String sql = "select *from tp_users where userId = :userId";
		List<Map<String, Object>> list = joaSimpleDao.queryForList(sql, map);
		return list.get(0).get("userPwd").toString();
	}
}

	
