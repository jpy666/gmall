package com.bupt.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bupt.gmall.api.bean.PmsBaseSaleAttr;
import com.bupt.gmall.api.bean.PmsProductImage;
import com.bupt.gmall.api.bean.PmsProductInfo;
import com.bupt.gmall.api.bean.PmsProductSaleAttr;
import com.bupt.gmall.api.service.ProductService;
import com.bupt.gmall.manage.util.UploadUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>Title:ProductController</p>
 * <p>Description:</P>
 * <p>Company:hhu.edu.cn</p>
 *
 * @Author 北京邮电大学.金培源
 * @Date 2020/10/16 14:45
 * Version 1.0
 */
@RestController
@CrossOrigin
public class ProductController {
    @Reference
    private ProductService productService;

    @RequestMapping("spuList")
    public List<PmsProductInfo> getSpuList(String catalog3Id) {
        return productService.getSpuList(catalog3Id);
    }

    @RequestMapping("baseSaleAttrList")
    public List<PmsBaseSaleAttr> getBaseSaleAttrList() {
        return productService.getBaseSaleAttrList();
    }

    @RequestMapping("fileUpload")
    public String fileUpload(@RequestParam("file") MultipartFile multipartFile) {
        String fileUrl = UploadUtil.uploadImage(multipartFile);
        return fileUrl;
    }

    @RequestMapping("saveSpuInfo")
    public String saveSpuInfo(@RequestBody PmsProductInfo pmsProductInfo) {
        productService.saveSpuInfo(pmsProductInfo);
        return "success";
    }

    @RequestMapping("spuSaleAttrList")
    public List<PmsProductSaleAttr> getSpuSaleAttrList(String spuId) {
        List<PmsProductSaleAttr> spuSaleAttrList = productService.getSpuSaleAttrList(spuId);
        System.out.println(spuSaleAttrList);
        return spuSaleAttrList;
    }
    @RequestMapping("spuImageList")
    public List<PmsProductImage> getSpuImageList(String spuId) {
        return productService.getSpuImageList(spuId);
    }
}
