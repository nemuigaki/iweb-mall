package domain;

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
        RandomNumeric;
    }
}
