package lk.blacky.bakerymanagement.bo.custom.impl;

import lk.blacky.bakerymanagement.dao.DAOFactory;
import lk.blacky.bakerymanagement.dao.custom.EmployeeDAO;
import lk.blacky.bakerymanagement.dto.EmployeeDTO;
import lk.blacky.bakerymanagement.entity.EmployeeEntity;

import java.sql.SQLException;

public class EmployeeBOImpl implements EmployeeBO{
    //dipendancy
    EmployeeDAO employeeDAO  = (EmployeeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);
    @Override
    public boolean addEmployee(EmployeeDTO employee) throws SQLException, ClassNotFoundException {
        return employeeDAO.add(new EmployeeEntity(employee.getEmpId(),employee.getName(),employee.getGender(),employee.getDivision(),employee.getSalary(),employee.getTpNo(),employee.getEmail(),employee.getDate()));
    }

    @Override
    public EmployeeDTO searchEmployee(String empId) {
        EmployeeEntity search = employeeDAO.search(empId);
        return new EmployeeDTO(search.getEmpId(),search.getName(),search.getGender(),search.getDivision(),search.getSalary(),search.getTpNo(),search.getEmail(),search.getDate());
    }

    @Override
    public boolean updateEmployee(EmployeeDTO employee) {
        return employeeDAO.update(new EmployeeEntity(employee.getEmpId(),employee.getName(),employee.getGender(),employee.getDivision(),employee.getSalary(),employee.getTpNo(),employee.getEmail(),employee.getDate()));
    }

    @Override
    public boolean deleteEmployee(String empId) {
        return employeeDAO.delete(empId);
    }
}
