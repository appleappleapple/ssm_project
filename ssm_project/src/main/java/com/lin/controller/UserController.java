package com.lin.controller;


import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.Page;
import com.lin.domain.User;
import com.lin.service.UserService;
import com.lin.util.PagedResult;

/**
 * 功能概要：UserController
 * 
 * @author linbingwen
 * @since  2015年9月28日 
 */
@Controller
public class UserController extends BaseController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Resource
	private UserService userService;
	
	@RequestMapping("/")  
    public ModelAndView getIndex(){    
		ModelAndView mav = new ModelAndView("index"); 
		User user = userService.selectUserById(1);
	    mav.addObject("user", user); 
        return mav;  
    }  
	
	/**
	 * 显示首页
	 * @author linbingwen
	 * @since  2015年10月23日 
	 * @return
	 */
	@RequestMapping("/bootstrapTest1")  
	public String bootStrapTest1(){
		return "bootstrap/bootstrapTest1";
	}
	
    /**
     * 分页查询用户信息
     * @author linbingwen
     * @since  2015年10月23日 
     * @param page
     * @return
     */
    @RequestMapping(value="/list.do", method= RequestMethod.POST)
    @ResponseBody
    public String list(Integer pageNumber,Integer pageSize ,String userName) {
		logger.info("分页查询用户信息列表请求入参：pageNumber{},pageSize{}", pageNumber,pageSize);
		try {
			PagedResult<User> pageResult = userService.queryByPage(userName, pageNumber,pageSize);
    	    return responseSuccess(pageResult);
    	} catch (Exception e) {
			return responseFail(e.getMessage());
		}
    }
}
