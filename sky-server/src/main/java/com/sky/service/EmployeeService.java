package com.sky.service;

import com.sky.dto.EmployeeDTO;
import com.sky.dto.EmployeeLoginDTO;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import com.sky.result.PageResult;
import com.sky.result.Result;

public interface EmployeeService {

    /**
     * 员工登录
     * @param employeeLoginDTO
     * @return
     */
    Employee login(EmployeeLoginDTO employeeLoginDTO);

    /**
     * 新增员工
     * @param employeeDTO
     * @return
     */
    Result save(EmployeeDTO employeeDTO);

    /**
     * 对员工列表分页显示
     * @param employeePageQueryDTO
     * @return
     */
    PageResult pageQuery(EmployeePageQueryDTO employeePageQueryDTO);

    /**
     * 修改员工启用状态
     * @param status
     * @param id
     * @return
     */
    Long startOrStop(Integer status, Long id);

    /**
     * 查询用户相关信息，在用户的修改信息页面进行回显
     * @param id
     * @return
     */
    EmployeeDTO getById(Long id);

    /**
     * 将前端用户的更新信息保存
     * @param employeeDTO
     * @return
     */
    int update(EmployeeDTO employeeDTO);
}
