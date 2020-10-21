package com.bupt.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bupt.gmall.api.bean.PmsBaseCatalog1;
import com.bupt.gmall.api.bean.PmsBaseCatalog2;
import com.bupt.gmall.api.bean.PmsBaseCatalog3;
import com.bupt.gmall.api.service.CatalogService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>Title:ManageConntroller</p>
 * <p>Description:</P>
 * <p>Company:hhu.edu.cn</p>
 *
 * @Author 北京邮电大学.金培源
 * @Date 2020/10/15 20:53
 * Version 1.0
 */
@RestController
@CrossOrigin
public class CatalogController {
    @Reference
    private CatalogService catalogService;

    @RequestMapping("getCatalog1")
    public List<PmsBaseCatalog1> getCatalog1() {
        return catalogService.getCatalog1();
    }

    @RequestMapping("getCatalog2")
    public List<PmsBaseCatalog2> getCatalog2(String catalog1Id) {
        return catalogService.getCatalog2(catalog1Id);
    }

    @RequestMapping("getCatalog3")
    public List<PmsBaseCatalog3> getCatalog3(String catalog2Id) {
        return catalogService.getCatalog3(catalog2Id);
    }
}
