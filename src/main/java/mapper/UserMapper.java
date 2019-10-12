package mapper;

import entity.User;

import java.util.List;

public interface UserMapper {
    public int insertUser(User user)throws Exception;
    public int updateUser(User user);
    public int deleteUser(Integer id);
    public User selectUserById(Integer id);
    public List<User> selectAllUser();

}
