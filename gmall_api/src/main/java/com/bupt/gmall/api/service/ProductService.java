package com.bupt.gmall.api.service;

import com.bupt.gmall.api.bean.PmsBaseSaleAttr;
import com.bupt.gmall.api.bean.PmsProductImage;
import com.bupt.gmall.api.bean.PmsProductInfo;
import com.bupt.gmall.api.bean.PmsProductSaleAttr;

import java.util.List;

public interface ProductService {
    List<PmsProductInfo> getSpuList(String catalog3Id);

    List<PmsBaseSaleAttr> getBaseSaleAttrList();

    void saveSpuInfo(PmsProductInfo pmsProductInfo);

    List<PmsProductSaleAttr> getSpuSaleAttrList(String spuId);

    List<PmsProductImage> getSpuImageList(String spuId);
}
