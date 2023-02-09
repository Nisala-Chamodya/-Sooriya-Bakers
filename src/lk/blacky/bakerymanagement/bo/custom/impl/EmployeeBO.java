package lk.blacky.bakerymanagement.bo.custom.impl;

import lk.blacky.bakerymanagement.dto.EmployeeDTO;
import lk.blacky.bakerymanagement.to.Employee;

public interface EmployeeBO extends SuperBo {
    public  boolean addEmployee(EmployeeDTO employee);
    public  EmployeeDTO searchEmployee(String empId);
    public  boolean updateEmployee(EmployeeDTO employee);

    public  boolean deleteEmployee(String empId);
}
