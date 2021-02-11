package com.tata.storeapp.utility;

import com.tata.storeapp.dao.EmployeeDao;
import com.tata.storeapp.dao.EmployeeImpl;
import com.tata.storeapp.models.Employee;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public class EmployeeApp {
    public static void main(String [] args){
        EmployeeDao employeeImpl = new EmployeeImpl();
        Iterator<Map.Entry<Employee, Integer>> finalData = employeeImpl.countAllOutstandingEmployees().entrySet().iterator();
        while (finalData.hasNext()){
            Map.Entry<Employee, Integer> emp = finalData.next();
            System.out.println(emp.getKey(),emp.getValue());
        }
    }
}
