package com.pingan.utils;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryUtil {

	private static volatile SqlSessionFactory factory = null;
	
	private static final Class CLASS_LOCK = SqlSessionFactoryUtil.class;  //类级锁
	
	private SqlSessionFactoryUtil(){}  //私有化构造函数
	
	//公用方法，初始化sqlSessionFactory
	public static SqlSessionFactory initSqlSessionFactory(){
		String resource = "SqlMapConfig.xml";
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		if(factory == null){
			synchronized (CLASS_LOCK) {
				if(factory == null){
					factory = new SqlSessionFactoryBuilder().build(is);
				}
			}
		}

		return factory;
	}
	
	//创建SqlSession
	public static SqlSession getSqlSession(){
		if(factory == null){
			initSqlSessionFactory();
		}
		return factory.openSession();
	}
}
