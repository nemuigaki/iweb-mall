package com.iweb.project.mapper;

import com.iweb.project.model.PmsProductAttributeCategory;
import com.iweb.project.model.PmsProductAttributeCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsProductAttributeCategoryMapper {
    long countByExample(PmsProductAttributeCategoryExample example);

    int deleteByExample(PmsProductAttributeCategoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PmsProductAttributeCategory row);

    int insertSelective(PmsProductAttributeCategory row);

    List<PmsProductAttributeCategory> selectByExample(PmsProductAttributeCategoryExample example);

    PmsProductAttributeCategory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") PmsProductAttributeCategory row, @Param("example") PmsProductAttributeCategoryExample example);

    int updateByExample(@Param("row") PmsProductAttributeCategory row, @Param("example") PmsProductAttributeCategoryExample example);

    int updateByPrimaryKeySelective(PmsProductAttributeCategory row);

    int updateByPrimaryKey(PmsProductAttributeCategory row);
}