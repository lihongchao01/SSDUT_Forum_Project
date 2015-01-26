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


	public Map<String, Object> getUserAccountInfo(String userId);

	public Map<String, Object> getUserInfoDetail(Map<String, Object> reqs);

	public String userInfoSave(Map<String, Object> reqs, Map<String, Object> conds);


	public String getUserType(String userId);

	public List<Map<String, Object>> getUserList();

	Map<String, Object> getUserInfo(Map<String, Object> map);

	public String getPassword(Map<String, Object> reqs);

}