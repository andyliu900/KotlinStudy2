package cross_env;

/**
 * Copyright (C), 2014-2025, 北京百度网讯股份有限公司
 *
 * @ProjectName: KotlinStudy2
 * @Package: org.example.cross_env
 * @ClassName: JavaArrayExample
 * @Description:
 * @Author: randysu
 * @CreateDate: 2025/1/29 20:57
 * @UpdateUser:
 * @UpdateDate: 2025/1/29 20:57
 * @UpdateRemark:
 * @Version: 1.0
 */
public class JavaArrayExample {

    public static String STATIC_VAL = "javaarrayexample_static_val";

    public JavaArrayExample() {

    }

    public void removeIndices(int[] indices) {
        System.out.println("JavaArrayExample removeIndices: ");
        for (int i : indices) {
            System.out.println("i: " + i + "  ");
        }
    }

    public void removeIndicesVarArg(int... indices) {
        System.out.println("JavaArrayExample removeIndicesVarArg size: " + indices.length);
    }

}
