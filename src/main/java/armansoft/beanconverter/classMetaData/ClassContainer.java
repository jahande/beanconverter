package armansoft.beanconverter.classMetaData;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: rmazloom
 * Date: 2/8/13
 * Time: 6:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class ClassContainer  implements GenericMetaDataInterface {
    private Class clazz;
    PropertyDescriptor[] properties;

    public String getPackage() {
        return this.clazz.getPackage().getName();
    }

    @Override
    public String getName() {
        return this.clazz.getSimpleName();
    }

    @Override
    public String setName(String name) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getAccessModifier() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setAccessModifier(String accessModifier) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public ClassContainer() {
    }

    public ClassContainer(Class clazz) throws IllegalAccessException, InstantiationException {
        this.clazz = clazz;


        StringBuffer buf = new StringBuffer();
        Object bean = clazz.newInstance();
        if (clazz != null) {
            try {
                BeanInfo binfo = Introspector.getBeanInfo(clazz);
                this.properties = binfo.getPropertyDescriptors();
                if (properties != null) {
                    for (int i = 0; i < properties.length; i++) {
                        Method readMethod = properties[i].getReadMethod();
                        if (readMethod != null) {
                            buf.append(properties[i].getName());
                            buf.append(" = ");
                            Object obj = readMethod.invoke(bean, null);
                            if (obj != null) {
                                buf.append(obj.toString());
                            } else {
                                buf.append("<empty>");
                            }
                            buf.append("\n");
                        }
                    }
                }
            } catch (Exception e) {
                // ignore exceptions thrown, this is a development aid
            }
        }
    }
}
