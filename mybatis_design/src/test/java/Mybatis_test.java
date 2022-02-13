import com.ep.dao.UserDao;
import com.ep.daomain.User;
import com.ep.mybatis.io.Resources;
import com.ep.mybatis.sqlsession.SqlSession;
import com.ep.mybatis.sqlsession.SqlSessionFactory;
import com.ep.mybatis.sqlsession.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Mybatis_test {
    public static void main(String[] args) {

        try {
            //1.读取配置文件
            InputStream in = Resources.getResourceAsStream("SqlMapconfig.xml");
            //2.创建SqlSessionFactory的构建者对象
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            //3.使用构建者创建工厂对象SqlSessionFactory
            SqlSessionFactory factory = builder.build(in);
            //4.使用SqlSessionFactory生产SqlSession对象
            SqlSession session = factory.openSession();
            //5.使用SqlSession创建dao接口的代理对象
            UserDao userDao = session.getMapper(UserDao.class);
            //6.使用代理对象执行查询所有方法
            List<User> users = userDao.findAll();
            for (User user : users){
                System.out.println(user);
            }
            //7.释放资源
            session.close();
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
