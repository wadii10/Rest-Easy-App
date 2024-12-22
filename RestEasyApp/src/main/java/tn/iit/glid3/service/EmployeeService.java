package tn.iit.glid3.service;


import jakarta.ws.rs.core.Response;
import tn.iit.glid3.model.Employee;

public interface EmployeeService {
    Response addEmployee(Employee e);
    Response deleteEmployee(int id);
    Employee getEmployee(int id);
    Employee[] getAllEmployees();
    Employee getDummyEmployee(int id);
}