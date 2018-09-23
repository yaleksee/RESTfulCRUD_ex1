package org.o7planning.restfulcrud.service;

import org.o7planning.restfulcrud.dao.EmployeeDAO;
import org.o7planning.restfulcrud.model.Employee;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/employees")
public class EmployeeService {

    // URI:
    // /contextPath/servletPath/employees
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Employee> getEmployees_JSON() {
        List<Employee> listOfCountries = EmployeeDAO.getAllEmployees();
        return listOfCountries;
    }

    // URI:
    // /contextPath/servletPath/employees/{empNo}
    @GET
    @Path("/{empNo}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Employee getEmployee(@PathParam("empNo") String empNo) {
        return EmployeeDAO.getEmployee(empNo);
    }

    // URI:
    // /contextPath/servletPath/employees
    @POST
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Employee addEmployee(Employee emp) {
        return EmployeeDAO.addEmployee(emp);
    }

    // URI:
    // /contextPath/servletPath/employees
    //http://localhost:8080/rest/employees
    //http://localhost:8080/rest/employees/E01
    @PUT
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Employee updateEmployee(Employee emp) {

        return EmployeeDAO.updateEmployee(emp);
    }

    @DELETE
    @Path("/{empNo}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void deleteEmployee(@PathParam("empNo") String empNo) {

        EmployeeDAO.deleteEmployee(empNo);
    }

}
