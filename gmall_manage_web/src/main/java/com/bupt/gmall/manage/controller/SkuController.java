package com.bupt.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bupt.gmall.api.bean.PmsSkuInfo;
import com.bupt.gmall.api.service.SkuService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Title:SkuController</p>
 * <p>Description:</P>
 * <p>Company:hhu.edu.cn</p>
 *
 * @Author 北京邮电大学.金培源
 * @Date 2020/10/20 19:50
 * Version 1.0
 */
@RestController
@CrossOrigin
public class SkuController {
    @Reference
    private SkuService skuService;

    @RequestMapping("saveSkuInfo")
    public String saveSkuInfo(@RequestBody PmsSkuInfo pmsSkuInfo) {
        String skuDefaultImg = pmsSkuInfo.getSkuDefaultImg();
        if(StringUtils.isEmpty(skuDefaultImg)) {
            pmsSkuInfo.setSkuDefaultImg(pmsSkuInfo.getPmsSkuImageList().get(0).getImgUrl());
        }
        System.out.println(pmsSkuInfo);
        skuService.saveSkuInfo(pmsSkuInfo);
        return "success";
    }
}
