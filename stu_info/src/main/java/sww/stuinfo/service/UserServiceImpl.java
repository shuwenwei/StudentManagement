package sww.stuinfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sww.stuinfo.mapper.UserMapper;
import sww.stuinfo.pojo.User;
import sww.stuinfo.pojo.UserInfo;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }

    @Override
    public UserInfo getUserInfoByUsername(String username) {
        return userMapper.getUserInfoByUsername(username);
    }
}
