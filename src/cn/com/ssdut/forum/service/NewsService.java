package cn.com.ssdut.forum.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface NewsService {

	public List<Map<String, Object>> listMainNews();

}
