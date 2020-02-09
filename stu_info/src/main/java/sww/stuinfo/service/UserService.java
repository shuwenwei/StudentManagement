package sww.stuinfo.service;

import sww.stuinfo.pojo.User;
import sww.stuinfo.pojo.UserInfo;


public interface UserService {

    public User getUserByUsername(String username);

    public UserInfo getUserInfoByUsername(String username);

}
