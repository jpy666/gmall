package com.bupt.gmall.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.bupt.gmall.api.bean.UmsMember;
import com.bupt.gmall.api.bean.UmsMemberReceiveAddress;
import com.bupt.gmall.api.service.UserService;
import com.bupt.gmall.user.mapper.UmsMemberReceiveAddressMapper;
import com.bupt.gmall.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>Title:UserServiceImpl</p>
 * <p>Description:</P>
 * <p>Company:hhu.edu.cn</p>
 *
 * @Author 北京邮电大学.金培源
 * @Date 2020/10/13 17:44
 * Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UmsMemberReceiveAddressMapper umsMemberReceiveAddressMapper;
    @Override
    public List<UmsMember> getAllUser() {
        return userMapper.selectAll();
    }

    @Override
    public List<UmsMemberReceiveAddress> getUmsMemberReceiveAddress(String memberId) {
        UmsMemberReceiveAddress umsMemberReceiveAddress = new UmsMemberReceiveAddress();
        umsMemberReceiveAddress.setMemberId(memberId);
        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses = umsMemberReceiveAddressMapper.select(umsMemberReceiveAddress);
        return umsMemberReceiveAddresses;
    }
}
