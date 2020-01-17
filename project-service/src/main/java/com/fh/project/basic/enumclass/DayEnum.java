package com.fh.project.basic.enumclass;

public enum DayEnum{
    MONDAY, TUESDAY, WEDNESDAY,
    THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    public static void main(String[] args) {
        DayEnum monday = DayEnum.MONDAY;
        // 获取枚举的name
        String name = monday.name();
        // 获取枚举定义的顺序，从0开始
        int ordinal = monday.ordinal();
        System.out.println("name:" + name + ",ordinal:" + ordinal);

        DayEnum tuesday = DayEnum.valueOf("TUESDAY");

        DayEnum[] enumConstants = DayEnum.class.getEnumConstants();
        System.out.println(DayEnum.class);
        System.out.println(DayEnum.class);
        System.out.println();
    }

}


