package com.tata.storeapp.dao;

import com.tata.storeapp.models.Employee;

import java.util.*;

public class EmployeeImpl implements EmployeeDao{

    @Override
    public List<Employee> getAllEmployees() {
        Employee employee = null;
        List<Employee> employeeList = new ArrayList<>();
        for(int i=0; i<100; i++){
            employee = new Employee(new Random().nextInt(10000),"emp"+i, 123456789+new Random().nextInt(100000000));
            employeeList.add(employee);
        }
        return employeeList;
    }

    @Override
    public List<Employee> generateOutstanding(){
        List<Employee> outstandingEmployeeList = new ArrayList<>();
        List<Employee> allEmployees = getAllEmployees();
        for(int j=0; j<3; j++) {
            Random randGen = new Random();
            for (int i = 0; i < 10; i++) {
                outstandingEmployeeList.add(allEmployees.get(randGen.nextInt(99)));
            }
        }
        return outstandingEmployeeList;
    }

    @Override
    public Hashtable<Employee, Integer> countAllOutstandingEmployees() {
        Hashtable<Employee, Integer> finalData= new Hashtable<>();
        LinkedHashSet<Employee> lset = new LinkedHashSet<>();
        int count=0;
        for(Employee employee: generateOutstanding()){
            if(!lset.add(employee)){
                count++;
                finalData.put(employee, count);
            }
        }
        return finalData;
    }
}
