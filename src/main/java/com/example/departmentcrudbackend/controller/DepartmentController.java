package com.example.departmentcrudbackend.controller;

import com.example.departmentcrudbackend.dto.DepartmentDto;
import com.example.departmentcrudbackend.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @PostMapping()
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto dto){
        return new ResponseEntity<>(departmentService.createDepartment(dto),
                HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable int id){
        return ResponseEntity.ok(departmentService.getDepartmentById(id));
    }
    @GetMapping
    public ResponseEntity<List<DepartmentDto>> findAllDepartments(){
        return ResponseEntity.ok(departmentService.findAllDepartment());
    }
    @PutMapping("{id}")
    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable int id,
                                                          @RequestBody DepartmentDto dto){
        return ResponseEntity.ok(departmentService.updateDepartment(id,dto));
    }
    @DeleteMapping("{id}")
    public ResponseEntity deleteDepartmentById(@PathVariable int id){
        departmentService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
