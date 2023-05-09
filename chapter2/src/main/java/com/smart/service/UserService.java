package com.smart.service;

import com.smart.dao.LoginLogDao;
import com.smart.dao.UserDao;
import com.smart.domain.LoginLog;
import com.smart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Service 服务层Bean
 */
@Service
public class UserService {
	private UserDao userDao;
	private LoginLogDao loginLogDao;

	/**
	 * 实际应用password一般可以用md5加密, 并比较加密后的md5. (虽然md5其实是有办法破解的, 暴力碰撞/彩虹表)
	 */
	public boolean hasMatchUser(String userName, String password) {
		int matchCount =userDao.getMatchCount(userName, password);
		return matchCount > 0;
	}
	
	public User findUserByUserName(String userName) {
		return userDao.findUserByUserName(userName);
	}

	/**
	 * 在事务中进行db操作
	 */
	@Transactional
    public void loginSuccess(User user) {
		user.setCredits(5 + user.getCredits());
		LoginLog loginLog = new LoginLog();
		loginLog.setUserId(user.getUserId());
		loginLog.setIp(user.getLastIp());
		loginLog.setLoginDate(user.getLastVisit());
        userDao.updateLoginInfo(user);
        loginLogDao.insertLoginLog(loginLog);
	}

	/**
	 * @Autowired 注入DAO层Bean
	 */
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * @Autowired 注入DAO层Bean
	 */
	@Autowired
	public void setLoginLogDao(LoginLogDao loginLogDao) {
		this.loginLogDao = loginLogDao;
	}
}
