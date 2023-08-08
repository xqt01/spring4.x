package com.smart.service;

import com.smart.dao.ForumDao;
import com.smart.domain.Forum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * 手动设置编程式的事务管理
 */
@Service
public class ForumService1 {
    public ForumDao forumDao;
    public TransactionTemplate template;

    public void addForum(final Forum forum) {
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
                forumDao.addForum(forum);
            }
        });
    }

    @Autowired
    public void setForumDao(ForumDao forumDao) {
        this.forumDao = forumDao;
    }

    @Autowired
    public void setTemplate(TransactionTemplate template) {
        this.template = template;
    }
}
