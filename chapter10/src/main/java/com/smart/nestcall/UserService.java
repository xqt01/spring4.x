package com.smart.nestcall;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @author 陈雄华
 * @version 1.0
 */
@Service("userService")
public class UserService extends BaseService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ScoreService scoreService;

    /**
     * 该方法嵌套调用了本类的其他方法及其他服务类的方法
     */
    public void logon(String userName) {
        System.out.println("before userService.updateLastLogonTime...");
        // 本服务类的其他方法
        updateLastLogonTime(userName);
        System.out.println("after userService.updateLastLogonTime...");

        System.out.println("before scoreService.addScore...");
        // 其他服务类的方法
        scoreService.addScore(userName, 20);
        System.out.println("after scoreService.addScore...");
    }

    public void updateLastLogonTime(String userName) {
        String sql = "UPDATE t_user u SET u.last_logon_time = ? WHERE user_name =?";
        jdbcTemplate.update(sql, System.currentTimeMillis(), userName);
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("nestcall/applicatonContext.xml");
        UserService service = (UserService) ctx.getBean("userService");

        JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        BasicDataSource basicDataSource = (BasicDataSource) jdbcTemplate.getDataSource();
        //插入一条记录，初始分数为10
        jdbcTemplate.execute("INSERT INTO t_user(user_name,password,score,last_logon_time) VALUES('tom','123456',10," + System.currentTimeMillis() + ")");

        //调用工作在无事务环境下的服务类方法,将分数添加20分
        System.out.println("before userService.logon method...");
        service.logon("tom");
        System.out.println("after userService.logon method...");

        jdbcTemplate.execute("DELETE FROM t_user WHERE user_name='tom'");
    }
}
