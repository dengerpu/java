package com.ep.mybatis.sqlsession.defaults;

import com.ep.mybatis.cfg.Configuration;
import com.ep.mybatis.sqlsession.SqlSession;
import com.ep.mybatis.sqlsession.SqlSessionFactory;

/*
* SqlSession接口的实现类
* */
public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private Configuration cfg;

    public DefaultSqlSessionFactory(Configuration cfg){
        this.cfg = cfg;
    }

    /**
     * 用于创建一个新的操作数据库对象
     * @return
     */
    public SqlSession openSession() {
        return new DefaultSqlSession(cfg);
    }

}
