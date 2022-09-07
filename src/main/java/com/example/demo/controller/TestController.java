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

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @RequestMapping("/GetUserFromDB")
    public Object GetUserFromDB() {
        String sql = "select  * from user";
        System.out.println(jdbcTemplate.queryForList(sql));
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        HashMap<String, Object> result = new HashMap<String, Object>();
        System.out.println(list.isEmpty());
        return  getResult(result, (list == null || list.isEmpty()) ? 0 : 1,list);
    }

    /**
     * 添加用户
     * @param name
     * @return code 200 成功 0 失败 msg 描述
     */
//    @Autowired
//    private  JdbcTemplate jdbcTemplate;
    @RequestMapping("/AddUser")
    public Object AddUser (String name, Number age, String sex) {
        String sql = "insert into user (name, age, sex) values (?,?,?);";
        HashMap<String, Object> result = new HashMap<String, Object>();
        int res = jdbcTemplate.update(sql, name, age, sex);
        return getResult(result, res, null);
    }

    private Object getResult(HashMap<String, Object> result, int res, List list) {
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

    /**
     * 删除用户
     * @param name
     * return true
     */
    @RequestMapping("/DelUser")
    public  Object DelUser(String name) {
        String sql = "DELETE  FROM  user WHERE name=?;";
        HashMap<String, Object> result = new HashMap<String, Object>();
        int res = jdbcTemplate.update(sql, name);
        return getResult(result, res, null);

    }
}
