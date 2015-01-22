package cn.com.ssdut.forum.service;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface SysService {

	public Map<String, Object> login(Map<String, Object> reqs);

}
