package com.sedion.mynawang.model.dao;


import com.sedion.mynawang.model.ArticleType;

import java.util.List;

public interface ArticleTypeMapper{

	/**
	 * 
	  * @Title: getAll
	  * @Description: 获取全部信息
	  * @param @return   
	  * @return List<ArticleType>
	 */
	List<ArticleType> getAll();
	
	/**
	 * 
	  * @Title: getByUpType
	  * @Description: 获取二级目录
	  * @param @param upTypeName
	  * @param @return   
	  * @return List<ArticleType>
	 */
	List<ArticleType> getByUpType(String upTypeName);
	
	/**
	 * 
	  * @Title: getByName
	  * @Description: 根据name获取类型对象
	  * @param @param typeName
	  * @param @return   
	  * @return ArticleType
	 */
	ArticleType getByName(String typeName);

}