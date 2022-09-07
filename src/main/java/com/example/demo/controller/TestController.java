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
    public List GetUserFromDB() {
        String sql = "select  * from user";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        return list;
    }
}
