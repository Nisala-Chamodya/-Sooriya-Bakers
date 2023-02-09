package lk.blacky.bakerymanagement.bo.custom.impl;

import lk.blacky.bakerymanagement.dao.DAOFactory;
import lk.blacky.bakerymanagement.dao.custom.EmployeeDAO;
import lk.blacky.bakerymanagement.dto.EmployeeDTO;

public class EmployeeBOImpl implements EmployeeBO{
    //dipendancy
    EmployeeDAO employeeDAO  = (EmployeeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);
    @Override
    public boolean addEmployee(EmployeeDTO employee) {
        return employeeDAO.add(new EmployeeDTO(employee.getEmpId(),employee.getName(),employee.getGender(),employee.getDivision(),employee.getSalary(),employee.getTpNo(),employee.getEmail(),employee.getDate()));
    }

    @Override
    public EmployeeDTO searchEmployee(String empId) {
        return employeeDAO.search(empId);
    }

    @Override
    public boolean updateEmployee(EmployeeDTO employee) {
        return employeeDAO.update(new EmployeeDTO(employee.getEmpId(),employee.getName(),employee.getGender(),employee.getDivision(),employee.getSalary(),employee.getTpNo(),employee.getEmail(),employee.getDate()));
    }

    @Override
    public boolean deleteEmployee(String empId) {
        return employeeDAO.delete(empId);
    }
}
