package com.bupt.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bupt.gmall.api.bean.PmsBaseAttrInfo;
import com.bupt.gmall.api.bean.PmsBaseAttrValue;
import com.bupt.gmall.api.service.AttrService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>Title:AttrController</p>
 * <p>Description:</P>
 * <p>Company:hhu.edu.cn</p>
 *
 * @Author 北京邮电大学.金培源
 * @Date 2020/10/16 9:31
 * Version 1.0
 */
@RestController
@CrossOrigin
public class AttrController {
    @Reference
    private AttrService attrService;

    @RequestMapping("attrInfoList")
    public List<PmsBaseAttrInfo> getAttrInfoList(String catalog3Id) {
        System.out.println(catalog3Id);
        return attrService.getAttrInfoList(catalog3Id);
    }

    @RequestMapping("getAttrValueList")
    public List<PmsBaseAttrValue> getAttrValueList(String attrId) {
        return attrService.getAttrValueList(attrId);
    }

    @RequestMapping("saveAttrInfo")
    public String saveAttrInfo(@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo) {
        attrService.saveAttrInfo(pmsBaseAttrInfo);
        return "success";
    }
}
