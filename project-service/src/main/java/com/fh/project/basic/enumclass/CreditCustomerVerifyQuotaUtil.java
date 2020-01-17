package com.fh.project.basic.enumclass;


import java.util.HashMap;
import java.util.Map;

public enum CreditCustomerVerifyQuotaUtil {

    AVAILABLE_TO_FROZEN(1) {
        @Override
        public void verify() {
            System.out.println("枚举测试");
        }
    },

    AVAILABLE_TO_USED(2) {
        @Override
        public void verify() {
            System.out.println("枚举测试2");
        }
    },
    ;
    // 变更额度类型
    private final int type;

    public abstract void verify();

    // 定义map接收
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


    public static void main(String[] args) {
        // 调用
        CreditCustomerVerifyQuotaUtil.getMethod(1).verify();
    }
}
