package cn.com.ssdut.forum.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;




@Service
public interface UserService {
		

	

	

	
	public boolean login(Map<String, Object> map);

	public Object register(Map<String, Object> map);

	public boolean user_register_samenametest(Map<String, Object> map);

	public void loginEnsure(String username);
	
	
	
	public String getIDByUsername(String username);

	public Map<String, Object> getUserAccountInfo(String user_id);

	public Map<String, Object> getUserInfoDetail(Map<String, Object> reqs);

	public String userInfoSave(Map<String, Object> reqs, Map<String, Object> conds);


	public String getUserType(String user_id);

	public List<Map<String, Object>> getUserList();

	

	public String getPassword(Map<String, Object> reqs);

}
