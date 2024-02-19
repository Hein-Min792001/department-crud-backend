package com.example.departmentcrudbackend.mapper;

import com.example.departmentcrudbackend.dto.DepartmentDto;
import com.example.departmentcrudbackend.entity.Department;

public class DepartmentMapper {
    public static DepartmentDto toDto(Department department){
        return new DepartmentDto(
                department.getId(),
                department.getName(),
                department.getAddress()
        );
    }
    public static Department toEntity(DepartmentDto dto){
        return new Department(
                dto.getName(),
                dto.getAddress()
        );
    }
}
