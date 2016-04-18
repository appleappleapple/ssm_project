package com.lin.service;

import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.lin.domain.User;
import com.lin.util.PagedResult;

/**
 * 功能概要：UserService接口类
 * 
 * @author linbingwen
 * @since  2015年9月28日 
 */
public interface UserService {
	
	User selectUserById(Integer userId);
	
	List<User> selectUserByUserName(String userName);
	
	/**
	 * 
	 * @author linbingwen
	 * @since  2015年10月23日 
	 * @param userName 查询条件，可为空
	 * @param pageNo 查询条件，可为空，默认取1
	 * @param pageSize 查询条件，可为空，默认取10
	 * @return
	 */
	PagedResult<User> queryByPage(String userName,Integer pageNo,Integer pageSize);

}
