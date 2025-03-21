package com.sky.service;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;

import java.util.List;

public interface CategoryService {

    /**
     * 分类分页查询
     * @param categoryPageQueryDTO
     * @return
     */
    PageResult categoryPageQuery(CategoryPageQueryDTO categoryPageQueryDTO);

    /**
     * 对分类信息进行修改
     * @param category
     * @return
     */
    int updateCategory(Category category);

    /**
     * 启用或禁用分类
     * @param status
     * @param id
     * @return
     */
    int startOrStop(Integer status, Long id);

    /**
     * 新增分类
     * @param category
     * @return
     */
    int addCategory(Category category);

    /**
     * 删除分类
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     * 根据类型查询分类
     * @param type
     * @return
     */
    List<Category> getALLCategoryByType(Integer type);
}
