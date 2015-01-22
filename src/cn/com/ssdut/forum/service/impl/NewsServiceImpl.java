package cn.com.ssdut.forum.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.com.ssdut.forum.dao.SimpleDao;
import cn.com.ssdut.forum.service.NewsService;

@Repository
public class NewsServiceImpl implements NewsService{

	@Autowired
	private SimpleDao newsSimpleDao;

	public SimpleDao getNewsSimpleDao() {
		return newsSimpleDao;
	}

	public void setNewsSimpleDao(SimpleDao newsSimpleDao) {
		this.newsSimpleDao = newsSimpleDao;
	}

	@Override
	public List<Map<String, Object>> listMainNews() {
		// TODO Auto-generated method stub
		String sql = "select * from news_info order by publish_time desc limit 4";
		return newsSimpleDao.queryForList(sql, new HashMap<String, Object>());
	}
}
