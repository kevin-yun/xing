package com.kevin.xing.enums;

public class AqjdEnums {

    // 工程状态
    public enum Gczt implements GenericEnum<Integer, String, AqjdEnums.Gczt> {
        JJDQ(0, "即将到期"),
        YGQ(1, "已过期");

        private Integer value;

        private String description;

        Gczt(Integer value, String description) {
            this.value = value;
            this.description = description;
        }

        @Override
        public Gczt get() {
            return this;
        }

        @Override
        public Integer getValue() {
            return value;
        }

        @Override
        public String getDescription() {
            return description;
        }
    }

    // 任务状态
    public enum Rwzt implements GenericEnum<Integer, String, AqjdEnums.Rwzt> {
        WXF(0, "未下发"),
        YXF(1, "已下发"),
        YSB(3, "已上报"),
        RWGB(2, "任务关闭");

        private Integer value;

        private String description;

        Rwzt(Integer value, String description) {
            this.value = value;
            this.description = description;
        }

        @Override
        public Rwzt get() {
            return this;
        }

        @Override
        public Integer getValue() {
            return value;
        }

        @Override
        public String getDescription() {
            return description;
        }
    }

    // 计划类型
    public enum Jhlx implements GenericEnum<Integer, String, AqjdEnums.Jhlx> {
        SJXF(0, "上级下发"),
        DFSB(1, "地方上报"),
        ;

        private Integer value;

        private String description;

        Jhlx(Integer value, String description) {
            this.value = value;
            this.description = description;
        }

        @Override
        public Jhlx get() {
            return this;
        }

        @Override
        public Integer getValue() {
            return value;
        }

        @Override
        public String getDescription() {
            return description;
        }
    }

    // 计划状态
    public enum Jhzt implements GenericEnum<Integer, String, AqjdEnums.Jhzt> {
        WSB(1, "未上报"),
        YSB(2, "已上报"),
        YPJ(3, "已评价"),
        DSC(4, "待审查"),
        DSD(5, "待审定"),
        SHWC(6, "审核完成");

        private Integer value;

        private String description;

        Jhzt(Integer value, String description) {
            this.value = value;
            this.description = description;
        }

        @Override
        public Jhzt get() {
            return this;
        }

        @Override
        public Integer getValue() {
            return value;
        }

        @Override
        public String getDescription() {
            return description;
        }
    }

    public enum Aqlb implements GenericEnum<Integer, String, AqjdEnums.Aqlb> {
        YLB(0, "一类坝"),
        ELB(1, "二类坝"),
        SLB(6, "三类坝"),
        YLZ(2, "一类闸"),
        ELZ(3, "二类闸"),
        SLZ(7, "三类闸"),
        SILZ(8, "四类闸"),
        YLBZ(4, "一类泵站"),
        ELBZ(5, "二类泵站"),
        SLBZ(9, "三类泵站"),
        SILBZ(10, "四类泵站");

        private Integer value;

        private String description;

        Aqlb(Integer value, String description) {
            this.value = value;
            this.description = description;
        }

        @Override
        public Aqlb get() {
            return this;
        }

        @Override
        public Integer getValue() {
            return value;
        }

        @Override
        public String getDescription() {
            return description;
        }
    }
}
