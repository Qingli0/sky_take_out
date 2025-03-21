package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface CategoryMapper {

    Page<Category> categoryPageQuery(CategoryPageQueryDTO categoryPageQueryDTO);

    int updateCategory(Category category);

    int startOrStop(Integer status, Long id);

    int addCategory(Category category);

    @Delete("delete from category where id = #{id}")
    int delete(Long id);

    List<Category> getALLCategoryByType(Integer type);
}
