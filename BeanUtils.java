package org.prac.reflect;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public final class BeanUtils {

	private BeanUtils() {
	}
	
	public static void copyProperties(Object writeBean, Object readBean) throws IntrospectionException {
		// readBeanのNullチェック
		if (readBean == null) {
			throw new NullPointerException("ReadBean must not be null");
		}
		// writeBeanのNullチェック
		if (writeBean == null) {
			throw new NullPointerException("WriteBean must not be null");
		}
		
	    // writeBeanのpropety情報を取得し、Mapを作成
		Map<String, Method> writeBeanMethodMap = new HashMap<String, Method>();
		BeanInfo writeBeanInfo = Introspector.getBeanInfo(writeBean.getClass());
		PropertyDescriptor[] writeBenaPropertyDescriptors = writeBeanInfo.getPropertyDescriptors();
		for (PropertyDescriptor descriptor : writeBenaPropertyDescriptors) {
			// keyをproperty名, valueをwriteMethod
			writeBeanMethodMap.put(descriptor.getName(), descriptor.getWriteMethod());
		}
		// 不要な情報を削除
		writeBeanMethodMap.remove("class");
		
		// readBeanのpropety情報を取得
		BeanInfo beanInfo = Introspector.getBeanInfo(readBean.getClass());
		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		
		// readBeanのpropetyをwriteBeanにコピーする。readBeanにしか無いpropertyは飛ばす
		for (PropertyDescriptor descriptor : propertyDescriptors) {
			
			try {
				// readBeanとwriteBeanのproperty名一致を検査
				Method writeMethod = writeBeanMethodMap.get(descriptor.getName());
				if (writeMethod == null) {
					continue;
				}
				
				Object value = descriptor.getReadMethod().invoke(readBean);
				writeMethod.invoke(writeBean, value);
			} catch(Exception e) {
				continue;
			}
		}
		
		return;
	}
	
	public static void logProperties(Object bean) throws Exception {
		if (bean == null) {
			throw new NullPointerException("Bean must not be null");
		}
		
		BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		
		for (PropertyDescriptor descriptor : propertyDescriptors) {
			if (descriptor.getName().equals("class")) {
				continue;
			}
			
			System.out.println("propertyName:" +  descriptor.getName() + ", propetyValue:" + descriptor.getReadMethod().invoke(bean));
		}
		
		return;
	}
}
