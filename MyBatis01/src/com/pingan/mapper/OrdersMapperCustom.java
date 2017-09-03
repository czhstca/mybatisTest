package com.pingan.mapper;

import java.util.List;

import com.pingan.pojo.Orders;
import com.pingan.pojo.OrdersCustom;
import com.pingan.pojo.User;

public interface OrdersMapperCustom {

	/**
	 * 根据订单的用户id查询这张订单和其拥有者的信息(一对一查询,一个订单只能被一个人拥有)
	 * @return
	 * @throws Exception
	 */
	public List<OrdersCustom> findOrderUser() throws Exception;
	
	/**
	 * 根据订单的用户id查询这张订单和其拥有者的信息(使用resultMap映射关联关系)
	 * @return
	 * @throws Exception
	 */
	public List<Orders> findOrderUserMap() throws Exception;
	
	/**
	 * 查询订单及订单明细和相关用户信息(一对多查询,使用resultMap映射)
	 * @return
	 * @throws Exception
	 */
	public List<Orders> findOrdersAndDetailMap() throws Exception;
	
	/**
	 * 查询用户及其购买的所有商品信息(多对多查询,使用resultMap映射)
	 * @return
	 * @throws Exception
	 */
	public List<User> findUserAndItemMap() throws Exception;
	
	/**
	 * 查询订单信息，并延迟加载订单相关的用户信息
	 * @return
	 * @throws Exception
	 */
	public List<Orders> findOrderUserLazyLoading() throws Exception;
	
}
