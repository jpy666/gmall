package com.bupt.gmall.api.service;

import com.bupt.gmall.api.bean.UmsMember;
import com.bupt.gmall.api.bean.UmsMemberReceiveAddress;

import java.util.List;

public interface UserService {

    List<UmsMember> getAllUser();

    List<UmsMemberReceiveAddress> getUmsMemberReceiveAddress(String memberId);
}
