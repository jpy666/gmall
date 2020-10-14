package com.bupt.gmall.user.entity;

import lombok.Data;

import javax.persistence.Id;

/**
 * <p>Title:UmsMemberReceiveAddress</p>
 * <p>Description:</P>
 * <p>Company:hhu.edu.cn</p>
 *
 * @Author 北京邮电大学.金培源
 * @Date 2020/10/13 21:12
 * Version 1.0
 */
@Data
public class UmsMemberReceiveAddress {
    @Id
    private String id;
    private String memberId;
    private String  name;
    private String  phoneNumber;
    private int defaultStatus;
    private String postCode;
    private String province;
    private String city;
    private String region;
    private String detailAddress;
}
