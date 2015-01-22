package cn.com.ssdut.forum.dao;

import java.util.Map;

import org.springframework.jdbc.core.ColumnMapRowMapper;

import cn.com.ssdut.forum.common.*;

/**
 * 对数据库数据记录的包装
 * 不区分键值大小写(转为大写)
 * @see org.springframework.jdbc.core.ColumnMapRowMapper
 */
public class MapRowMapper extends ColumnMapRowMapper {

	@Override
	protected Map<String, Object> createColumnMap(int columnCount) {
		return new LowerCaseHashMap<String, Object>(columnCount);
		//return new CaseInsensitiveHashMap<String, Object>(columnCount);
	}
}
