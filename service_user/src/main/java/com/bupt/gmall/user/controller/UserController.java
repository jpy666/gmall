package com.bupt.gmall.user.controller;

import com.bupt.gmall.api.bean.UmsMember;
import com.bupt.gmall.api.bean.UmsMemberReceiveAddress;
import com.bupt.gmall.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>Title:UserController</p>
 * <p>Description:</P>
 * <p>Company:hhu.edu.cn</p>
 *
 * @Author 北京邮电大学.金培源
 * @Date 2020/10/13 17:41
 * Version 1.0
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("getUmsMemberReceiveAddress")
    public List<UmsMemberReceiveAddress> getUmsMemberReceiveAddress(String memberId) {
        return userService.getUmsMemberReceiveAddress(memberId);
    }
    @RequestMapping("getAllUser")
    public List<UmsMember> getAllUser() {
        List<com.bupt.gmall.api.bean.UmsMember> users = userService.getAllUser();
        return users;
    }
    @RequestMapping("/index")
    public String index() {
        return "hello";
    }
}
