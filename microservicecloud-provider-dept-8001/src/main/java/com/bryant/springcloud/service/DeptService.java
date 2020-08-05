package com.bryant.springcloud.service;

import com.bryant.springcloud.entity.Dept;

import java.util.List;

public interface DeptService {

    public boolean addDept(Dept dept);
    public Dept findById(Long id);
    public List<Dept> list();

}
