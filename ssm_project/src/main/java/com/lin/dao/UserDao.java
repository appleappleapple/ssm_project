package com.lin.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lin.domain.User;

/**
 * 功能概要：User的DAO类
 * 
 * @author linbingwen
 * @since 2015年9月28日
 */
public interface UserDao {
	
	/**
	 * 
	 * @author linbingwen
	 * @since 2015年9月28日
	 * @param userId
	 * @return
	 */
	 User selectUserById(Integer userId);
	
	 /**
	  * 
	  * @author linbingwen
	  * @since  2015年10月22日 
	  * @param userName
	  * @return
	  */
	 List<User> selectUserByUserName(@Param("userName") String userName);
	 
	 

}
