package lk.blacky.bakerymanagement.dao.custom;

import lk.blacky.bakerymanagement.to.Employee;

public interface  EmployeeDAO  {
    public  boolean addEmployee(Employee employee);
    public  Employee searchEmployee(String empId);
    public  boolean updateEmployee(Employee employee);

    public  boolean deleteEmployee(String empId);
}
