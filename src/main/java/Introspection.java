import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

/**
 * Copyright (C), 2014-2025, 无业游民
 *
 * @ProjectName: KotlinStudy2
 * @Package: PACKAGE_NAME
 * @ClassName: Introspection
 * @Description:
 * @Author: randysu
 * @CreateDate: 2025/1/31 23:00
 * @UpdateUser:
 * @UpdateDate: 2025/1/31 23:00
 * @UpdateRemark:
 * @Version: 1.0
 */
public class Introspection {

    public static void main(String[] args) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(PF.class);

        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor prop : propertyDescriptors) {
            System.out.println("pro name: " + prop.getName());
        }

    }

}
