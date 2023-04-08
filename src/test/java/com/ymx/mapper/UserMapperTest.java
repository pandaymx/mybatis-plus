package com.ymx.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.ymx.pojo.User;
import com.ymx.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper um;
    @Test
    public void test(){
        // 查询全部
        List<User> users = um.selectList(null);
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    public void test2(){
        // 根据id查询
        User user = um.selectById(1);
        System.out.println(user);
    }

    @Test
    void test3() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        // 多id查询
        List<User> users = um.selectBatchIds(list);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    void test4() {
        um.select
    }
}
