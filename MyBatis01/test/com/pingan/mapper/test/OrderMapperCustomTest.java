package com.pingan.mapper.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.pingan.mapper.OrdersMapperCustom;
import com.pingan.pojo.Orders;
import com.pingan.pojo.OrdersCustom;
import com.pingan.pojo.User;
import com.pingan.utils.SqlSessionFactoryUtil;

public class OrderMapperCustomTest {

	@Test
	public void testFindOrderUser() throws Exception{
		SqlSession session = SqlSessionFactoryUtil.getSqlSession();
		
		OrdersMapperCustom omc = session.getMapper(OrdersMapperCustom.class);
		
		List<OrdersCustom> ocList = omc.findOrderUser();
		
		System.out.println(ocList.toString());
		
		session.close();
		
	}
	
	@Test
	public void testFindOrderUserMap() throws Exception{
		SqlSession session = SqlSessionFactoryUtil.getSqlSession();
		
		OrdersMapperCustom omc = session.getMapper(OrdersMapperCustom.class);
		
		List<Orders> ocList = omc.findOrderUserMap();
		
		System.out.println(ocList.toString());
		
		session.close();
		
	}
	
	
	@Test
	public void testFindOrdersAndDetailMap() throws Exception{
		SqlSession session = SqlSessionFactoryUtil.getSqlSession();
		
		OrdersMapperCustom omc = session.getMapper(OrdersMapperCustom.class);
		
		List<Orders> ocList = omc.findOrdersAndDetailMap();
		
		System.out.println(ocList.toString());
		
		session.close();
		
	}
	
	@Test
	public void testFindUserAndItemMap() throws Exception{
		SqlSession session = SqlSessionFactoryUtil.getSqlSession();
		
		OrdersMapperCustom omc = session.getMapper(OrdersMapperCustom.class);
		
		List<User> ocList = omc.findUserAndItemMap();
		
		System.out.println(ocList.toString());
		
		session.close();
	}
	
	
	@Test
	public void testFindOrderUserLazyLoading() throws Exception{
		SqlSession session = SqlSessionFactoryUtil.getSqlSession();
		
		OrdersMapperCustom omc = session.getMapper(OrdersMapperCustom.class);
		
		List<Orders> orderList = omc.findOrderUserLazyLoading();
		
		for(Orders order : orderList){
			User user = order.getUser();
			System.out.println(user);
		}
		
		session.close();
	}
	
}
