package com.iweb.mall.portal.util;

import cn.hutool.cache.impl.TimedCache;
import cn.hutool.core.date.DateUnit;
import com.iweb.mall.portal.domain.CarouselDetails;
import com.iweb.mall.portal.domain.GoodsDetails;
import com.iweb.mall.portal.domain.OrderDetails;
import domain.Constants;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.SynchronousQueue;

/**
 * @Description
 * @Author sadalsuud
 * @Blog www.sadalsuud.cn
 * @Date 22/11/2023
 * @Package com.iweb.mall.portal.util
 */
public class CacheUtil {
    private CacheUtil() {
    }

    public static TimedCache<String, String> authCodeCache = new TimedCache<>(DateUnit.SECOND.getMillis() * 60);

    public static TimedCache<String, OrderDetails> orderDetailsCache = new TimedCache<>(DateUnit.DAY.getMillis() * 5);

    public static Map<String, SynchronousQueue<Map<Constants.PaymentUrl, String>>> payMap = new ConcurrentHashMap<>();

    public static TimedCache<String, Enum<Constants.OrderState>> stateMap = new TimedCache<>(DateUnit.MINUTE.getMillis() * 30);

    public static Map<String, Object> goodsMock = new ConcurrentHashMap<>();

    static {
        ArrayList<CarouselDetails> carousels = new ArrayList<>();
        CarouselDetails details = new CarouselDetails();
        details.setCarouselUrl("https://newbee-mall.oss-cn-beijing.aliyuncs.com/images/banner-mate60.png");
        carousels.add(details);
        details.setCarouselUrl("https://newbee-mall.oss-cn-beijing.aliyuncs.com/images/banner-matex5.png");
        carousels.add(details);
        details.setCarouselUrl("https://newbee-mall.oss-cn-beijing.aliyuncs.com/images/banner-p60-pro-white.png");
        carousels.add(details);
        goodsMock.put("carousels", carousels);

        ArrayList<GoodsDetails> hotGoodses = new ArrayList<>();
        hotGoodses.add(new GoodsDetails("10918", "Apple AirPods (第三代)", "AirPods第三代搭载空间音频和自适应均衡...", "https://newbee-mall.oss-cn-beijing.aliyuncs.com/images/MME73_AV4_GEO_CN.jpeg", "1399", "美妙新声"));
        hotGoodses.add(new GoodsDetails("10908", "HUAWEI Mate 40 Pro 全网通5G手机 8GB...", "5nm麒麟9000旗舰芯片 | 超感光徕卡电...", "https://newbee-mall.oss-cn-beijing.aliyuncs.com/images/mate40-white.png", "6488", "跃见非凡"));
        hotGoodses.add(new GoodsDetails("10906", "Apple iPhone12 Pro (A2408) 128...", "A14仿生芯片，6.1英寸超视网膜XDR显示...", "https://newbee-mall.oss-cn-beijing.aliyuncs.com/images/iphone-12-pro-blue-hero.png", "8499", "自我再飞跃"));
        hotGoodses.add(new GoodsDetails("10902", "华为 HUAWEI P40 冰霜银 全网通5G手机", "麒麟990 5G SoC芯片 5000万超感...", "https://newbee-mall.oss-cn-beijing.aliyuncs.com/images/p40-silver.png", "4299", "超感知影像"));
        goodsMock.put("hotGoodses", hotGoodses);

        ArrayList<GoodsDetails> newGoodses = new ArrayList<>();
        newGoodses.add(new GoodsDetails("10933", "【旗舰新品】HUAWEI/华为Mate50 Pro 昆仑破晓...", "曲面屏超光变XMAGE影像鸿蒙3.0拍照摄影...", "https://newbee-mall.oss-cn-beijing.aliyuncs.com/images/mate-50-pro-black.png", "7899", "领势而上"));
        newGoodses.add(new GoodsDetails("10931", "iPhone 14 Pro 暗紫色 512G", "A16仿生芯片，4800万像素主摄，超瓷晶面...", "https://newbee-mall.oss-cn-beijing.aliyuncs.com/images/iphone-14-pro-purple.jpg", "10599", "强力出圈"));
        newGoodses.add(new GoodsDetails("10932", "华为Mate50 Pro 昆仑霞光 512G", "曲面屏超光变XMAGE影像鸿蒙3.0拍照摄影...", "https://newbee-mall.oss-cn-beijing.aliyuncs.com/images/mate-50-pro-light.png", "7899", "领势而上"));
        newGoodses.add(new GoodsDetails("10934", "Apple MacBook Pro 13英寸 16G+512...", "m2 芯片 8核中央处理器 10核图形处理器", "https://newbee-mall.oss-cn-beijing.aliyuncs.com/images/mbp-m2-202206.jpg", "10799", "超机动，硬实力"));
        newGoodses.add(new GoodsDetails("10921", "HUAWEI P50 Pro 4G全网通 8GB+512GB...", "麒麟9000芯片,万象双环设计", "https://newbee-mall.oss-cn-beijing.aliyuncs.com/images/p50-gold.png", "7488", "万象新生"));
        goodsMock.put("newGoodses", newGoodses);

        ArrayList<GoodsDetails> recommendGoodses = new ArrayList<>();
        recommendGoodses.add(new GoodsDetails("10922", "HUAWEI P50 雪域白", "骁龙888,4G全网通,原色双影像单元,万象...", "https://newbee-mall.oss-cn-beijing.aliyuncs.com/images/p50-white.png", "4488", "万象新生"));
        recommendGoodses.add(new GoodsDetails("10922", "华为FreeBuds Pro无线耳机", "主动降噪真无线蓝牙耳机/入耳式耳机/环境音/...", "https://newbee-mall.oss-cn-beijing.aliyuncs.com/images/freebuds-pro.png", "749", "动态降噪 听我想听"));
        recommendGoodses.add(new GoodsDetails("10922", "iPhone 14 Pro 金色 512G", "A16仿生芯片，4800万像素主摄，超瓷晶面...", "https://newbee-mall.oss-cn-beijing.aliyuncs.com/images/iphone-14-pro-gold.jpg", "10599", "强力出圈"));
        recommendGoodses.add(new GoodsDetails("10922", "HUAWEI MatePad Pro 12.6英寸", "8+256GB WIFI曜石灰 麒麟9000...", "https://newbee-mall.oss-cn-beijing.aliyuncs.com/images/matepad-pro.png", "4699", "创造无界"));
        recommendGoodses.add(new GoodsDetails("10922", "MacBook Pro 16英寸 M1 Pro芯片", "16G 512G 银色。M1Pro和M1Ma...", "https://newbee-mall.oss-cn-beijing.aliyuncs.com/images/mbp16-silver-select-202110_GEO_CN.jpeg", "18999", "强者的强"));
        goodsMock.put("recommendGoodses", recommendGoodses);

        ArrayList<GoodsDetails> allGoodsList = new ArrayList<>();
        allGoodsList.addAll(hotGoodses);
        allGoodsList.addAll(newGoodses);
        allGoodsList.addAll(recommendGoodses);
        goodsMock.put("allGoods", allGoodsList);
    }

}
