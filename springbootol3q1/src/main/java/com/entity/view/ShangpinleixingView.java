package com.entity.view;

import com.entity.ShangpinleixingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;

@TableName("shangpinleixing")
public class ShangpinleixingView  extends ShangpinleixingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShangpinleixingView(){
	}

 	public ShangpinleixingView(ShangpinleixingEntity shangpinleixingEntity){
 	try {
			BeanUtils.copyProperties(this, shangpinleixingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {

			e.printStackTrace();
		}

	}
}
