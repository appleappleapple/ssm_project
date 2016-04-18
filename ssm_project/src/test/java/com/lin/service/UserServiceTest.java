package com.lin.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lin.baseTest.SpringTestCase;
import com.lin.domain.User;
import com.lin.util.PagedResult;

/**
 * 功能概要：UserService单元测试
 * 
 * @author linbingwen
 * @since  2015年9月28日 
 */
public class UserServiceTest extends SpringTestCase	{
	@Resource
	private UserService userService;
	Logger logger = LoggerFactory.getLogger(UserServiceTest.class);
	
	@Test
	public void selectUserByIdTest(){
		User user = userService.selectUserById(10);
        logger.debug("查找结果" + user);
	}
	
	@Test
	public void selectUserByUserName() {
		List<User> list = userService.selectUserByUserName("apple");
        logger.debug("查找结果" + list);
	}
	
	/**
	 * 分页测试
	 * @author linbingwen
	 * @since  2015年10月22日
	 */
	@Test
	public void queryByPage(){
		 PagedResult<User>  pagedResult = userService.queryByPage(null,1,10);//null表示查全部	
		 logger.debug("查找结果" + pagedResult);

	}
	

}
