package com.iweb.mall.portal.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @Author sadalsuud
 * @Blog www.sadalsuud.cn
 * @Date 26/11/2023
 * @Package com.iweb.mall.portal.domain
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsDetails {
    private String goodsId;
    private String goodsName;
    private String goodsIntro;
    private String goodsCoverImg;
    private String sellingPrice;
    private String tag;
}
