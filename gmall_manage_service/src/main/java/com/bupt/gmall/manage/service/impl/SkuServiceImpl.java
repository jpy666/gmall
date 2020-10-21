package com.bupt.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.bupt.gmall.api.bean.PmsSkuAttrValue;
import com.bupt.gmall.api.bean.PmsSkuImage;
import com.bupt.gmall.api.bean.PmsSkuInfo;
import com.bupt.gmall.api.bean.PmsSkuSaleAttrValue;
import com.bupt.gmall.api.service.SkuService;
import com.bupt.gmall.manage.mapper.PmsSkuAttrValueMapper;
import com.bupt.gmall.manage.mapper.PmsSkuImageMapper;
import com.bupt.gmall.manage.mapper.PmsSkuInfoMapper;
import com.bupt.gmall.manage.mapper.PmsSkuSaleAttrValueMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>Title:SkuServiceImpl</p>
 * <p>Description:</P>
 * <p>Company:hhu.edu.cn</p>
 *
 * @Author 北京邮电大学.金培源
 * @Date 2020/10/20 19:53
 * Version 1.0
 */
@Service
public class SkuServiceImpl implements SkuService {
    @Autowired
    private PmsSkuInfoMapper pmsSkuInfoMapper;

    @Autowired
    private PmsSkuAttrValueMapper pmsSkuAttrValueMapper;

    @Autowired
    private PmsSkuSaleAttrValueMapper pmsSkuSaleAttrValueMapper;

    @Autowired
    private PmsSkuImageMapper pmsSkuImageMapper;

    @Override
    public void saveSkuInfo(PmsSkuInfo pmsSkuInfo) {
        //保存基本信息
        pmsSkuInfoMapper.insert(pmsSkuInfo);
        System.out.println(pmsSkuInfo.getId() + "000000000000");
        //保存平台属性列表
        List<PmsSkuAttrValue> pmsSkuAttrValueList = pmsSkuInfo.getPmsSkuAttrValueList();
        for (PmsSkuAttrValue pmsSkuAttrValue : pmsSkuAttrValueList) {
            pmsSkuAttrValue.setSkuId(pmsSkuInfo.getId());
            pmsSkuAttrValueMapper.insert(pmsSkuAttrValue);
        }

        //保存销售属性列表
        List<PmsSkuSaleAttrValue> pmsSkuSaleAttrValueList = pmsSkuInfo.getPmsSkuSaleAttrValueList();
        for (PmsSkuSaleAttrValue pmsSkuSaleAttrValue : pmsSkuSaleAttrValueList) {
            pmsSkuSaleAttrValue.setSkuId(pmsSkuInfo.getId());
            pmsSkuSaleAttrValueMapper.insert(pmsSkuSaleAttrValue);
        }

        //保存图片集合
        List<PmsSkuImage> pmsSkuImageList = pmsSkuInfo.getPmsSkuImageList();
        for (PmsSkuImage pmsSkuImage : pmsSkuImageList) {
            pmsSkuImage.setSkuId(pmsSkuInfo.getId());
            pmsSkuImageMapper.insert(pmsSkuImage);
        }
    }
}
