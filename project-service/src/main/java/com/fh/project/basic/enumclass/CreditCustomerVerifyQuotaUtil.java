package com.fh.project.basic.enumclass;


import java.util.HashMap;
import java.util.Map;

public enum CreditCustomerVerifyQuotaUtil {


    AVAILABLE_TO_FROZEN(1) {
        @Override
        public void verify() {

        }
    },

    AVAILABLE_TO_USED(2) {
        @Override
        public void verify() {

        }
    },
    ;
    // 变更额度类型
    private final int type;

    public abstract void verify();

    private static Map<Integer, CreditCustomerVerifyQuotaUtil> map = new HashMap<Integer, CreditCustomerVerifyQuotaUtil>();

    static {
        for (CreditCustomerVerifyQuotaUtil legEnum : CreditCustomerVerifyQuotaUtil.values()) {
            map.put(legEnum.getType(), legEnum);
        }
    }

    public static CreditCustomerVerifyQuotaUtil getMethod(Integer type) {
        if (type > ChangeQuotaType.SHORT_FROZEN_TO_AVAILABLE.getType() || type < ChangeQuotaType.SHORT_AVAILABLE_TO_FROZEN.getType()) {
        }
        return map.get(type);
    }


    CreditCustomerVerifyQuotaUtil(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    /**
     * 变化额度的类别
     *
     * @author xiaobin
     * @create 2019年9月3日09:19:11
     */
    public enum Category{

        /**
         * 额度变化类别 --- 其他 --- 0
         */
        OTHER(0, "其他"),
        /**
         * 额度变化类别 --- 扣减可用额度 --- 1
         */
        REDUCE_AVAILABLE(1, "扣减可用额度"),
        /**
         * 额度变化类别 --- 扣减冻结额度 --- 2
         */
        REDUCE_FROZEN(2, "扣减冻结额度"),
        /**
         * 额度变化类别 --- 扣减已用额度 --- 3
         */
        REDUCE_USED(3, "扣减已用额度"),
        ;
        private Integer type;
        private String desc;

        Category(Integer type, String desc) {
            this.type = type;
            this.desc = desc;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }

    public static void main(String[] args) {
        // 调用
        CreditCustomerVerifyQuotaUtil.getMethod(1).verify();

        ChangeQuotaType available_to_frozen = ChangeQuotaType.valueOf("AVAILABLE_TO_FROZEN");
        System.out.println(available_to_frozen);
    }
}
