package cn.com.ssdut.forum.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.ssdut.forum.dao.*;

public class MySQLSimpleDaoImpl extends AbstractSimpleDao {
	/**
	 * 分页SQL语句模板
	 */

	private static final String SPLIT_PAGE_SQL = "select * from (${SQL}) as TEMP_PGS limit :__offset , :__limit";
	
	/**
	 * 组合查询条件
	 * @param params 参数Map
	 * @param pageindex 分页页数
	 * @param pagesize 分页大小
	 * @return 包含分页参数的Map
	 */
	private Map<String, Object> makeConditions(Map<String, ?> params, int pageindex, int pagesize){
		//pageindex必须大于等于1
		if(params.containsKey("__limit") || params.containsKey("__offset")){
			throw new IllegalArgumentException("common defined param name can not be cover![__limit or __offset].");
		}
		/*
		if(pageindex <= 0 || pagesize <= 0){
			throw new IllegalArgumentException("pageindex and pagesize must be positive integer.");
		}
		*/
		/*
		if(pageindex < 0 || pagesize <= 0){
			throw new IllegalArgumentException("pageindex and pagesize must be positive integer.");
		}
		*/
		
		
		Map<String, Object> p = new HashMap<String, Object>();
		p.putAll(params);
		//int offset = (pageindex - 1) * pagesize;
		int offset = Integer.parseInt(params.get("start").toString());
		p.put("__limit", pagesize);
		p.put("__offset", offset);
		
		return p;
	}

	public <T> Page<T> pageQuery(String sql, Map<String, ?> params,
			int pageindex, int pagesize, Order order, Class<T> c) {
		
		DomainWrap<T> dw = new DomainWrap<T>(c);
		Map<String, Object> p = makeConditions(params, pageindex, pagesize);
		
		long totalCount = count(sql, params);
		
		sql += order.toSqlString();
		String execSql = SPLIT_PAGE_SQL.replaceAll("\\$\\{SQL\\}", sql);
		List<T> pageList = getNamedParameterJdbcTemplate().query(execSql, p, dw);
		
		Page<T> page = new Page<T>();
		//page.setSize(pagesize);
		//page.setLimit(pagesize);
		//page.setIndex(pageindex);
		//page.setStart(pageindex-1);
		page.setTotal(totalCount);
		page.setList(pageList);
		
		return page;
	}

	public Page<Map<String, Object>> pageQuery(String sql,
			Map<String, ?> params, int pageindex, int pagesize, Order order) {
		
		Map<String, Object> p = makeConditions(params, pageindex, pagesize);

		long totalCount = count(sql, params);
		
		sql += order.toSqlString();
		String execSql = SPLIT_PAGE_SQL.replaceAll("\\$\\{SQL\\}", sql);
		List<Map<String, Object>> pageList = queryForList(execSql, p);
	
	
		//重要的代码！！
		Page<Map<String, Object>> page = new Page<Map<String, Object>>();
		//page.setSize(pagesize);
		//page.setIndex(pageindex);
		
		//page.setStart((pageindex-1)*pagesize);
		//page.setLimit(page.getStart()+pageList.size());
		
		page.setTotal(totalCount);
		if(params.get("page")!=null) {
			page.setPage(Integer.parseInt(params.get("page").toString()));
		}
		else {
			page.setPage(1);  //默认是第一页
		}
		
		
		page.setList(pageList);
		
		//page.setPage(pageindex);
		
		
		return page;
	}

}
