package com.example.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;


@RequestMapping("/user")
@RestController
public class TestController {

    @Autowired
    @RequestMapping("/GetUserList")
    public List GetUser() {
        List<Object> userList = new ArrayList<Object>();
        HashMap<String, Object> model = new HashMap<String, Object>();
        model.put("name", "sonder");
        model.put("age", 18);
        model.put("sex", "1");
        userList.add(model);
        return userList;
    }

    /** 用户列表查询 */
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @RequestMapping("/GetUserFromDB")
    public Object GetUserFromDB() {
        String sql = "select  * from user";
        System.out.println(jdbcTemplate.queryForList(sql));
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        System.out.println(list.isEmpty());
        return  getResult((list == null || list.isEmpty()) ? 0 : 1,list);
    }

    /** 添加用户 */
//    @Autowired
//    private  JdbcTemplate jdbcTemplate;
    @RequestMapping("/AddUser")
    public Object AddUser (String name, Number age, String sex) {
        String sql = "insert into user (name, age, sex) values (?,?,?);";
        int res = jdbcTemplate.update(sql, name, age, sex);
        return getResult(res, null);
    }

    /**
     * 封装的结果返回方法
     * @param res    是否成功
     * @param list   返回的数据
     * */

    private Object getResult(int res, List list) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        if(res > 0) {
            result.put("code", 200);
            result.put("msg", "操作成功");
        }
        if(res < 0) {
            result.put("code", 0);
            result.put("msg", "操作失败");
        }
        if(list != null && !list.isEmpty()) {
            result.put("list", list);
        }
        return result;
    }

    /** 删除用户*/
    @RequestMapping("/DelUser")
    public  Object DelUser(String name) {
        String sql = "DELETE  FROM  user WHERE name=?;";
        int res = jdbcTemplate.update(sql, name);
        return getResult(res, null);

    }
}
