package cn.com.higinet.dl.joa.service;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

public interface UserService {
	
	boolean user_login(Map<String, Object> map);
	
	public boolean login(Map<String, Object> map);

	public Object register(Map<String, Object> map);

	public boolean user_register_samenametest(Map<String, Object> reqs);

	public void loginEnsure(String userName);
	
	
	public String userDelete(Map<String, Object> reqs, Map<String, Object> conds);
	
	public String getUserNameByUserId(String userId);

	public String getRealNameByUserId(String userId);
	
	public String getUsePwdByUserId(String userId);
	
	public Map<String, Object> getUserAccountInfo(String userId);

	public Map<String, Object> getUserInfoDetail(Map<String, Object> reqs);

	public String userInfoSave(Map<String, Object> reqs, Map<String, Object> conds);

    public String getUserIdByUsername(String userName);
    
	public int getUserType(String userId);

	public List<Map<String, Object>> getUserList();

	Map<String, Object> getUserInfo(Map<String, Object> map);

	public String getPassword(Map<String, Object> reqs);
	
	public List<Map<String, Object>> getAllUser(int usrType);

	public String addUser(Map<String, Object> reqs);

	public String deleteUser(Map<String, Object> reqs);

	public Map<String, Object> getUserDetail(Map<String, Object> reqs);

	public String editUser(Map<String, Object> reqs);
	

}