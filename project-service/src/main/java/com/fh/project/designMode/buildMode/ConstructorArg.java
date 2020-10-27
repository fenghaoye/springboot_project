package com.fh.project.designMode.buildMode;

/**
 * @Description 当 isRef 为 true 的时候，arg 表示 String 类型的 refBeanId，type 不需要设置；
 * 当 isRef 为 false 的时候，arg、type 都需要设置。
 * @Author fenghao
 * @Email 849260688@qq.com
 * @Date 2020/4/8 10:37 上午
 */
public class ConstructorArg {

    private boolean isRef;
    private Class type;
    private Object arg;

    public ConstructorArg(Build build) {
        this.isRef = build.isRef;
        this.type = build.type;
        this.arg = build.arg;
    }

    public static class Build {
        private boolean isRef;
        private Class type;
        private Object arg;

        public ConstructorArg build() {
            if (isRef) {
                if (arg == null || arg.getClass() != String.class) {
                    throw new IllegalArgumentException("");
                }
            } else {
                if (arg == null || type == null) {
                    throw new IllegalArgumentException("");
                }
            }
            return new ConstructorArg(this);
        }

        public Build setRef(boolean ref) {
            isRef = ref;
            return this;
        }

        public Build setType(Class type) {
            this.type = type;
            return this;
        }

        public Build setArg(Object arg) {
            this.arg = arg;
            return this;
        }
    }

    public static void main(String[] args) {
        ConstructorArg build = new ConstructorArg.Build()
                .setRef(true)
                .setArg("xxx")
                .build();
    }
}
