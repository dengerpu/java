package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import com.itheima.utils.TransactionManger;

import java.util.List;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl2 implements IAccountService{

    private IAccountDao accountDao;
    private TransactionManger txManger;

    public void setTxManger(TransactionManger txManger) {
        this.txManger = txManger;
    }

    public void setAccountDao(IAccountDao accountDao) {

        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAllAccount() {
        List<Account> accounts = null;
        try {
            //1.开启事务
            txManger.beginTransaction();
            //2.执行操作
            accounts = accountDao.findAllAccount();
            //3.提交事务
            txManger.commit();

        } catch (Exception e) {
            //5.回滚操作
            txManger.rollback();

        } finally {
            //6.释放连接
            txManger.release();
        }
        //4.返回结果
        return accounts;
    }

    @Override
    public Account findAccountById(Integer accountId) {
        Account account = null;
        try {
            //1.开启事务
            txManger.beginTransaction();
            //2.执行操作
            account = accountDao.findAccountById(accountId);
            //3.提交事务
            txManger.commit();

        } catch (Exception e) {
            //5.回滚操作
            txManger.rollback();

        } finally {
            //6.释放连接
            txManger.release();
        }
        //4.返回结果
        return account;
    }

    @Override
    public void saveAccount(Account account) {

        try {
            //1.开启事务
            txManger.beginTransaction();
            //2.执行操作
            accountDao.saveAccount(account);
            //3.提交事务
            txManger.commit();

        } catch (Exception e) {
            //5.回滚操作
            txManger.rollback();

        } finally {
            //6.释放连接
            txManger.release();
        }


    }

    @Override
    public void updateAccount(Account account) {
        try {
            //1.开启事务
            txManger.beginTransaction();
            //2.执行操作
            accountDao.updateAccount(account);
            //3.提交事务
            txManger.commit();

        } catch (Exception e) {
            //5.回滚操作
            txManger.rollback();

        } finally {
            //6.释放连接
            txManger.release();
        }

    }

    @Override
    public void deleteAccount(Integer acccountId) {
        try {
            //1.开启事务
            txManger.beginTransaction();
            //2.执行操作
            accountDao.deleteAccount(acccountId);
            //3.提交事务
            txManger.commit();

        } catch (Exception e) {
            //5.回滚操作
            txManger.rollback();

        } finally {
            //6.释放连接
            txManger.release();
        }

    }


    /*
    * 转账
    * */
    public void tranfer(String srcName, String targetName, float money) {

        try {
            //1.开启事务
            txManger.beginTransaction();
            //2.执行操作

            //2.1.查询转出用户
            Account src = accountDao.findAccountName(srcName);
            //2.2.查询转入用户
            Account target = accountDao.findAccountName(targetName);
            //2.3.更改转出用户金额
            src.setMoney(src.getMoney()-money);
            //2.4.更改转入用户金额
            target.setMoney(target.getMoney()+money);
            //2.5.保存转出用户信息
            accountDao.updateAccount(src);
          //  int i =1/0;
            //2.6.保存转入用户信息
            accountDao.updateAccount(target);

            //3.提交事务
            txManger.commit();

        } catch (Exception e) {
            //5.回滚操作
            txManger.rollback();
            e.printStackTrace();

        } finally {
            //6.释放连接
            txManger.release();
        }





    }
}
