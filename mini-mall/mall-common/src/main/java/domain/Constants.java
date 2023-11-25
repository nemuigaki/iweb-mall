package domain;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author sadalsuud
 * @Blog www.sadalsuud.cn
 * @Date 23/11/2023
 * @Package domain
 */
public class Constants {
    /**
     * Ids 生成策略枚举
     */
    public enum Ids {
        /**
         * 雪花算法
         */
        SnowFlake,
        /**
         * 日期算法
         */
        ShortCode,
        /**
         * 随机算法
         */
        RandomNumeric
    }

    public enum PaymentUrl {
        Url,
        BASE64
    }

    public enum OrderState {
        Canceled(0, "交易取消"),
        Created(10, "订单创建, 未付款"),
        Paid(20, "已付款, 待发货"),
        Delivered(30, "已发货"),
        TransactionSuccessful(40, "交易成功, 等待用户确认"),
        TransactionClosure(50, "交易关闭");

        private Integer code;
        private String info;

        OrderState(Integer code, String info) {
            this.code = code;
            this.info = info;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        private static final Map<Integer, OrderState> stateMap = new HashMap<>();
        static {
            for (OrderState value : OrderState.values()) {
                stateMap.put(value.getCode(), value);
            }
        }
        public static OrderState getState(int code) {
            return stateMap.get(code);
        }
    }
}
