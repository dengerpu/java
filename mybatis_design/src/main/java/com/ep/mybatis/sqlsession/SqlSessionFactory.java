package com.ep.mybatis.sqlsession;

public interface SqlSessionFactory {

    /*
    * 用于打开一个新的Session对象
    * */
    SqlSession openSession();
}
