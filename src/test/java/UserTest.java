import entity.User;
import mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserTest {
    private static SqlSessionFactory sqlSessionFactory;
    public static void main(String[] args) throws IOException {
        String resource = "mybaits.cfg.xml";
        InputStream inputStream = null;
        inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        insertUser();

    }

    private static void insertUser(){
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("欧阳");
        user.setPassword("1234");
        user.setSex("男");
        user.setAddress("贵阳");
        try{
            mapper.insertUser(user);
            session.commit();
        }catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        session.close();
    }

    private static void updateUser(){
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.selectUserById(1);
        user.setUsername("超人");
        mapper.updateUser(user);
        session.commit();
        session.close();
    }

    private static void deleteUser(){
        SqlSession session =sqlSessionFactory.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.deleteUser(1);
        session.commit();
        session.close();

    }
    private static void selectUserById(){
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.selectUserById(1);
        session.commit();
        System.out.println(user.getUsername()+""+user.getPassword());
        session.close();
    }
    private static void selectAllUser(){
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> users = mapper.selectAllUser();
        session.commit();
        for (User user:users
             ) {
                System.out.println(user.getUsername()+""+user.getAddress());
        }
        session.close();

    }
}
