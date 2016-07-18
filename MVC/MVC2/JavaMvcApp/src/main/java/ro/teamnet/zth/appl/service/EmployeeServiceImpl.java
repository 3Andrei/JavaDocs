package ro.teamnet.zth.appl.service;

import ro.teamnet.zth.appl.dao.EmployeeDao;
import ro.teamnet.zth.appl.domain.Employee;

import java.util.List;

/**
 * Created by Nicolescu on 15.07.2016.
 */
public class EmployeeServiceImpl implements EmployeeService {
    public EmployeeDao employeeDao=new EmployeeDao();

    @Override
    public List<Employee> findAllEmployees() {
       return employeeDao.getAllEmployees();
    }

    @Override
    public Employee findOneEmployee(long id) {
        return employeeDao.getEmployeeById(id);
    }
}
