package com.example.departmentcrudbackend.service;

import com.example.departmentcrudbackend.dao.DepartmentDao;
import com.example.departmentcrudbackend.dto.DepartmentDto;
import com.example.departmentcrudbackend.entity.Department;
import com.example.departmentcrudbackend.exception.ResourceNotFoundException;
import com.example.departmentcrudbackend.mapper.DepartmentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.departmentcrudbackend.mapper.DepartmentMapper.*;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentDao departmentDao;

    public DepartmentDto createDepartment(DepartmentDto dto) {
        return toDto(departmentDao.save(toEntity(dto)));
    }

    public DepartmentDto getDepartmentById(int id) {
        return toDto(departmentDao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department does not exist with id: " + id)));
    }

    public List<DepartmentDto> findAllDepartment(){
        return departmentDao.findAll()
                .stream()
                .map(DepartmentMapper::toDto)
                .collect(Collectors.toList());
    }
    @Transactional
    public DepartmentDto updateDepartment(int id, DepartmentDto dto){
        DepartmentDto dep = getDepartmentById(id);
        dep.setName(dto.getName());
        dep.setAddress(dto.getAddress());
        Department department = toEntity(dep);
        department.setId(id);
        return toDto(departmentDao.save(department));
    }
    public void deleteEmployee(int id){
        if (departmentDao.existsById(id)){
            departmentDao.deleteById(id);
        }
        else
            throw new ResourceNotFoundException("Department does not exist with id: " + id);
    }


     /*
    createDepartment
    getDepartment
    getAllDepartment
    updateDepartment
    deleteDepartment
    */
}
