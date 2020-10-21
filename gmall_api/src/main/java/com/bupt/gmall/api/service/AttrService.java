package com.bupt.gmall.api.service;

import com.bupt.gmall.api.bean.PmsBaseAttrInfo;
import com.bupt.gmall.api.bean.PmsBaseAttrValue;

import java.util.List;

public interface AttrService {
    List<PmsBaseAttrInfo> getAttrInfoList(String catalog3Id);

    List<PmsBaseAttrValue> getAttrValueList(String attrId);

    void saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);
}
