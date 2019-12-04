package com.fh.project.basic.enumclass;

import java.util.HashMap;
import java.util.Map;

/**
 * 仓库数据源。
 *
 * @author fenghao
 * @version v1.0.0
 * @since 2019-11-04 11:00
 */

public enum WarehouseEnum {
    /**
     * 上海仓0，广州仓1，深圳仓2，武汉仓3，北京仓4，成都仓5
     */
    SH_WAREHOUSE(0,"上海仓"),
    GZ_WAREHOUSE(1,"广州仓"),
    SZ_WAREHOUSE(2,"深圳仓"),
    WH_WAREHOUSE(3,"武汉仓"),
    BJ_WAREHOUSE(4,"北京仓"),
    CD_WORKHOUSE(5,"成都仓");

    /**
     * id
     */
    Integer id;
    /**
     * 描述
     */
    String describe;

    WarehouseEnum(Integer id, String describe) {
        this.id = id;
        this.describe = describe;
    }

    public Integer getId() {
        return id;
    }

    public String getDescribe() {
        return describe;
    }

    public static Map<Integer, String> map = new HashMap<>();

    static {
        map.put(SH_WAREHOUSE.getId(),SH_WAREHOUSE.getDescribe());
        map.put(GZ_WAREHOUSE.getId(),GZ_WAREHOUSE.getDescribe());
        map.put(SZ_WAREHOUSE.getId(),SZ_WAREHOUSE.getDescribe());
        map.put(WH_WAREHOUSE.getId(),WH_WAREHOUSE.getDescribe());
        map.put(BJ_WAREHOUSE.getId(),BJ_WAREHOUSE.getDescribe());
        map.put(CD_WORKHOUSE.getId(),CD_WORKHOUSE.getDescribe());
    }

    public static String getDesc(Integer value) {
        return map.get(value);
    }


    public static void main(String[] args) {
        WarehouseEnum[] values = WarehouseEnum.values();
        for(WarehouseEnum warehouseEnum : values){
            System.out.println(warehouseEnum);
        }
        WarehouseEnum warehouseEnum = WarehouseEnum.valueOf("SH_WAREHOUSE");
        System.out.println(warehouseEnum);
    }
}
