package com.tata.storeapp.dao;

import com.tata.storeapp.models.Employee;

import java.util.Hashtable;
import java.util.List;

public interface EmployeeDao {
    public List<Employee> getAllEmployees();

    List<Employee> generateOutstanding();

    public Hashtable<Employee, Integer> countAllOutstandingEmployees();
}
