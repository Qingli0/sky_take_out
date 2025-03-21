package com.sky.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sky.constant.MessageConstant;
import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.exception.DeletionNotAllowedException;
import com.sky.mapper.CategoryMapper;
import com.sky.mapper.DishMapper;
import com.sky.mapper.SetmealMapper;
import com.sky.result.PageResult;
import com.sky.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private SetmealMapper setmealMapper;
    @Autowired
    private DishMapper dishMapper;
    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 分页查询
     * @param categoryPageQueryDTO
     * @return
     */
    @Override
    public PageResult categoryPageQuery(CategoryPageQueryDTO categoryPageQueryDTO) {
        PageHelper.startPage(categoryPageQueryDTO.getPage(), categoryPageQueryDTO.getPageSize());
        Page<Category> page = categoryMapper.categoryPageQuery(categoryPageQueryDTO);
        long total = page.getTotal();
        List<Category> pageResult = page.getResult();
        return new PageResult(total, pageResult);
    }


    /**
     * 更新分类信息
     * @param category
     * @return
     */
    @Override
    public int updateCategory(Category category) {
       return categoryMapper.updateCategory(category);
    }

    /**
     * 启用或禁用分类
     * @param status
     * @param id
     * @return
     */
    @Override
    public int startOrStop(Integer status, Long id) {
       return categoryMapper.startOrStop(status,id);
    }

    /**
     * 添加分类
     * @param category
     * @return
     */
    @Override
    public int addCategory(Category category) {
        return categoryMapper.addCategory(category);
    }


    /**
     * 删除分类
     * @param id
     * @return
     */
    @Override
    public int delete(Long id) {
        //查询当前分类是否关联了菜品，如果关联了就抛出业务异常
        Integer count = dishMapper.countByCategoryId(id);
        if(count > 0){
            //当前分类下有菜品，不能删除
            throw new DeletionNotAllowedException(MessageConstant.CATEGORY_BE_RELATED_BY_DISH);
        }
        //查询当前分类是否关联了套餐，如果关联了就抛出业务异常
        count = setmealMapper.countByCategoryId(id);
        if(count > 0){
            //当前分类下有菜品，不能删除
            throw new DeletionNotAllowedException(MessageConstant.CATEGORY_BE_RELATED_BY_SETMEAL);
        }
        return categoryMapper.delete(id);
    }

    /**
     * 根据类型查询分类
     * @param type
     * @return
     */
    @Override
    public List<Category> getALLCategoryByType(Integer type) {
        return categoryMapper.getALLCategoryByType(type);
    }
}
