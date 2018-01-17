package com.hf.springmvc.dao;

import java.util.List;
import java.util.Map;


public interface BaseDao {
	List<Object> findAll(String tableName);
	List<Object> findByParams(String tableName,Map<String, String> maps);
}
