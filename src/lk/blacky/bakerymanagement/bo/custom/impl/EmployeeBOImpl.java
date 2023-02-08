package lk.blacky.bakerymanagement.bo.custom.impl;

import lk.blacky.bakerymanagement.dao.DAOFactory;
import lk.blacky.bakerymanagement.dao.custom.EmployeeDAO;
import lk.blacky.bakerymanagement.dto.EmployeeDTO;
import lk.blacky.bakerymanagement.to.Customer;
import lk.blacky.bakerymanagement.to.Employee;

public class EmployeeBOImpl implements EmployeeBO{
    //dipendancy
    EmployeeDAO employeeDAO  = (EmployeeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);
    @Override
    public boolean addEmployee(EmployeeDTO employee) {
        return employeeDAO.addEmployee(new Employee(employee.getEmpId(),employee.getName(),employee.getGender(),employee.getDivision(),employee.getSalary(),employee.getTpNo(),employee.getEmail(),employee.getDate()));
    }

    @Override
    public Employee searchEmployee(String empId) {
        return employeeDAO.searchEmployee(empId);
    }

    @Override
    public boolean updateEmployee(EmployeeDTO employee) {
        return employeeDAO.updateEmployee(new Employee(employee.getEmpId(),employee.getName(),employee.getGender(),employee.getDivision(),employee.getSalary(),employee.getTpNo(),employee.getEmail(),employee.getDate()));
    }

    @Override
    public boolean deleteEmployee(String empId) {
        return employeeDAO.deleteEmployee(empId);
    }
}
