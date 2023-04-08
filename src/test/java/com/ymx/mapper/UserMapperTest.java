package com.ymx.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ymx.pojo.User;
import com.ymx.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper um;
    @Test
    void test(){
        // 查询全部
        // 查询列表，null表示没有多余条件，相当于where为null
        List<User> users = um.selectList(null);
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    void test2(){
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
        HashMap<String, Object> map = new HashMap<>();
        map.put("age","18");
        // 根据列来进行查询
        System.out.println(um.selectByMap(map));
    }

    @Test
    void test5() {
        // 设置一个查询器，然后添加where条件>=21
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.ne("age","21");
        // 查询记录条数
        System.out.println(um.selectCount(qw));
    }

    @Test
    void test6() {
        // 返回一个map集合
        List<Map<String, Object>> maps = um.selectMaps(null);
        System.out.println(maps);
    }

    @Test
    void test7() {
        // 只返回第一个字段的值
        List<Object> objects = um.selectObjs(null);
        System.out.println(objects);
    }

    @Test
    void test8() {
        // 先获取分页信息 1表示第几页，size表示大小
        Page<User> page = um.selectPage(new Page<>(1, 2), null);
        System.out.println(page.getRecords());
    }

    @Test
    void test9() {
        // map集合
        System.out.println(um.selectMapsPage(new Page<>(2, 2), null).getRecords());
    }

    @Test
    void test10() {
        // 只会查询一条记录
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq("id","1");
        User user = um.selectOne(qw);
        System.out.println(user);
    }

    @Test
    void test11() {
        User user = new User();
        user.setName("迪迦");
        user.setAge(30000000);
        user.setEmail("dijia@diqiu.com");
        um.insert(user);

        System.out.println(um.selectOne(new QueryWrapper<User>().eq("name", "迪迦")));
    }

    @Test
    void test12() {
// 删除（根据ID 批量删除）
//        int deleteBatchIds(@Param(Constants.COLLECTION) Collection<? extends Serializable> idList);
//// 根据 ID 删除
//        int deleteById(Serializable id);
//// 根据 columnMap 条件，删除记录
//        int deleteByMap(@Param(Constants.COLUMN_MAP) Map<String, Object> columnMap);
        um.delete(new QueryWrapper<User>().eq("id","1644546089612140546"));
    }
    //// 根据 whereWrapper 条件，更新记录
    //int update(@Param(Constants.ENTITY) T updateEntity, @Param(Constants.WRAPPER) Wrapper<T> whereWrapper);
    //// 根据 ID 修改
    //int updateById(@Param(Constants.ENTITY) T entity);

    @Test
    void test13() {
        User user = um.selectById(1);
        user.setAge(55);
        um.update(user, null);
        // um.updateById(user); 两者等价
    }
}
