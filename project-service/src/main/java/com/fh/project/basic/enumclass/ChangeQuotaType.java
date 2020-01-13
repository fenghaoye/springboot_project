package com.fh.project.basic.enumclass;


/**
 * 变化额度类型
 *
 * @author daiqi
 * @create 2019-06-15 14:57
 */
public enum ChangeQuotaType{
    // 1:总额度-冻结额度 2:总额度-已用额度 3:冻结额度-已用额度 4:已用-冻结 5:已用-总额度 6:冻结->总额度
    AVAILABLE_TO_FROZEN(1, Category.REDUCE_AVAILABLE, "可用额度到冻结额度"),
    AVAILABLE_TO_USED(2, Category.REDUCE_AVAILABLE, "可用额度到已用额度"),
    FROZEN_TO_USED(3, Category.REDUCE_FROZEN, "冻结额度到已用额度"),
    USED_TO_FROZEN(4, Category.REDUCE_USED, "已用额度到冻结额度"),
    USED_TO_AVAILABLE(5, Category.REDUCE_USED, "已用额度到可用额度"),
    FROZEN_TO_AVAILABLE(6, Category.REDUCE_FROZEN, "冻结额度到可用额度"),
    DIRECT_ADD_FIXED_TOTAL(7, Category.OTHER, "直接增加固定总额度"),
    DIRECT_ADD_TEMP_TOTAL(8, Category.OTHER, "直接增加临时总额度"),
    DIRECT_DEDUCTION_FIXED_TOTAL(9, Category.OTHER, "直接扣减固定总额度"),
    DIRECT_DEDUCTION_TEMP_TOTAL(10, Category.OTHER, "直接扣减临时总额度"),
    /**
     * 短租临时额度扣减规则
     * 1、优先使用固定额度，固定额度使用完后使用临时额度，需要判断有效期
     * 2、订单退换货，优先扣减临时已使用、冻结短租额度，扣减完后再扣减固定已用、冻结额度--退换货不需要判断短租时间
     */
    SHORT_AVAILABLE_TO_FROZEN(11, Category.REDUCE_AVAILABLE, "短租可用额度到冻结额度"),
    SHORT_AVAILABLE_TO_USED(12, Category.REDUCE_AVAILABLE, "短租可用额度到已用额度"),
    SHORT_FROZEN_TO_USED(13, Category.REDUCE_FROZEN, "短租冻结额度到已用额度"),
    SHORT_USED_TO_FROZEN(14, Category.REDUCE_USED, "短租已用额度到冻结额度"),
    SHORT_USED_TO_AVAILABLE(15, Category.REDUCE_USED, "短租已用额度到可用额度"),
    SHORT_FROZEN_TO_AVAILABLE(16, Category.REDUCE_FROZEN, "短租冻结额度到可用额度"),


    ;
    private Integer type;
    private Category category;
    private String desc;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    ChangeQuotaType(Integer type, Category category, String desc) {
        this.type = type;
        this.category = category;
        this.desc = desc;
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

}
