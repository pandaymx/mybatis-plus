package com.ymx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ymx.pojo.User;
import com.ymx.service.UserService;
import com.ymx.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author panda
* @description 针对表【user】的数据库操作Service实现
* @createDate 2023-04-08 10:52:11
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




