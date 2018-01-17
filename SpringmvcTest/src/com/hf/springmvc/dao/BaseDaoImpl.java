package com.hf.springmvc.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;


public class BaseDaoImpl implements BaseDao{
	@Autowired
	public SessionFactory sessionFactory;
	
	private List<String> valueList=null;
	@Override
	public List<Object> findAll(String tableName) {
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Object> all=null; 
		try {
			all=session.createQuery("from "+tableName).getResultList();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return all;
	}
	
	private String setParameterList(Map<String, String> maps){
		Set<String> set= maps.keySet();
		Iterator<String> iter=set.iterator();
		String keys="1=1";
		while(iter.hasNext()){
			String key=iter.next();
			keys=keys+"&"+key+"= ? ";
			String value=maps.get(key);
			valueList.add(value);
		}
		return keys;
	}
	
	@Override
	public List<Object> findByParams(String tableName,Map<String, String> maps) {
		valueList=new ArrayList<String>();
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Object> all=null; 
		try {
			String keys=setParameterList(maps);
			String hql="from "+tableName+" where "+keys;
			Query<Object> query=session.createQuery(hql);
			for(int i=0;i<valueList.size();i++){
				query.setParameter(i+1, valueList.get(i));
			}
			all=query.getResultList();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return all;
	}
}
