package com.entity.view;

import com.entity.ShangpinxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;

@TableName("shangpinxinxi")
public class ShangpinxinxiView  extends ShangpinxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShangpinxinxiView(){
	}

 	public ShangpinxinxiView(ShangpinxinxiEntity shangpinxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, shangpinxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {

			e.printStackTrace();
		}

	}
}
