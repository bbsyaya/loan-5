package com.loan.common.utils;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuttle on 5/30/17.
 */
public class CopyBeanUtils<E> {

    public <T> List<E> copyBeanUtils(Class<E> target, List<T> sourceList)
            throws IllegalAccessException, InstantiationException {
        List<E> beanList = new ArrayList<>();
        for(int i=0; i<sourceList.size(); i++){
            E bean = target.newInstance();
            BeanUtils.copyProperties(sourceList.get(i), bean);
            beanList.add(bean);
        }
        return beanList;
    }

    public static List copyBeanList(Class c, List<Object> sourceList){
        List list = new ArrayList();
        for(int i=0; i<sourceList.size(); i++){
            BeanUtils.copyProperties(sourceList.get(i), c);
            list.add(c);
        }

        return list;
    }
}
